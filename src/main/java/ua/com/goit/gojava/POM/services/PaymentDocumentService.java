package ua.com.goit.gojava.POM.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import ua.com.goit.gojava.POM.dataModel.cash.CashMovementEntry;
import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocument;
import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocumentDetail;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectFinResultEntry;
import ua.com.goit.gojava.POM.persistence.hibernate.PaymentDocumentDAO;
import ua.com.goit.gojava.POM.persistence.hibernate.abstraction.AbstractDAO;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;

public class PaymentDocumentService extends DataObjectService<PaymentDocument> {

	private static final String CLASS_NAME = "Payment Document"; 
	private static final Logger LOG = Logger.getLogger(PaymentDocumentService.class);
	private PaymentDocumentDAO paymentDocumentDAO;
	
	private PaymentDocumentDetailService paymentDocumentDetailService;
	private CashMovementService cashMovementService;
	private ProjectFinResultEntryService projectFinResultEntryService;
	
	public PaymentDocumentDAO getPaymentDocumentDAO() {
		return paymentDocumentDAO;
	}
	public void setPaymentDocumentDAO(PaymentDocumentDAO paymentDocumentDAO) {
		this.paymentDocumentDAO = paymentDocumentDAO;
	}
	public PaymentDocumentDetailService getPaymentDocumentDetailService() {
		return paymentDocumentDetailService;
	}
	public void setPaymentDocumentDetailService(PaymentDocumentDetailService paymentDocumentDetailService) {
		this.paymentDocumentDetailService = paymentDocumentDetailService;
	}
	public CashMovementService getCashMovementService() {
		return cashMovementService;
	}
	public void setCashMovementService(CashMovementService cashMovementService) {
		this.cashMovementService = cashMovementService;
	}
	public ProjectFinResultEntryService getProjectFinResultEntryService() {
		return projectFinResultEntryService;
	}
	public void setProjectFinResultEntryService(ProjectFinResultEntryService projectFinResultEntryService) {
		this.projectFinResultEntryService = projectFinResultEntryService;
	}
	
	@Override
	public void create(PaymentDocument newDoc) throws POMServicesException {
		super.create(newDoc);
		for(PaymentDocumentDetail detail:newDoc.getPaymentDocumentDetails()){
			paymentDocumentDetailService.create(detail);
		}
	}
	
	@Override
	public void update(PaymentDocument doc) throws POMServicesException {
		
		super.update(doc);	
		for(PaymentDocumentDetail detail:doc.getPaymentDocumentDetails()){
			
			if(detail.isMarkedForDelete()){
				paymentDocumentDetailService.delete(detail);
			} else {
				paymentDocumentDetailService.update(detail);
			}
		}
		
	}
	
	@Override
	public void delete(PaymentDocument doc) throws POMServicesException {
		
		for(PaymentDocumentDetail docDetail: retrieveAllDetails(doc)){
			paymentDocumentDetailService.delete(docDetail);
		}
		super.delete(doc);
		
	}
	
	public List<PaymentDocumentDetail> retrieveAllDetails(PaymentDocument doc) throws POMServicesException {	
		Criterion restriction = Restrictions.eq("doc", doc);
		return paymentDocumentDetailService.retrieve(restriction);
	}
	public PaymentDocumentDetail retrieveDocDetailById(long id) throws POMServicesException {	
		return paymentDocumentDetailService.retrieveById(id);
	}
	public void createDocDetail(PaymentDocumentDetail newDocDetail) throws POMServicesException {
		
		if(newDocDetail.getDoc().getId() == 0) {
		
			create(newDocDetail.getDoc());
			paymentDocumentDetailService.create(newDocDetail);
			
		} else {
			
			update(newDocDetail.getDoc());
			paymentDocumentDetailService.create(newDocDetail);
			
		}
		
	}
	public void updateDocDetail(PaymentDocumentDetail docDetail) throws POMServicesException {
		
		update(docDetail.getDoc());
		paymentDocumentDetailService.update(docDetail);
		
	}
	public void deleteDocDetail(PaymentDocumentDetail docDetail) throws POMServicesException {
		
		paymentDocumentDetailService.delete(docDetail);
		
	}
	
	public void generateTransactions(PaymentDocument doc) throws POMServicesException {
		
		try {
			deleteTransactions(doc);
		
			if((doc != null) && (doc.getBankAccount() != null)) {
				
				CashMovementEntry newEntry = new CashMovementEntry();
				newEntry.setDate(doc.getDate());
				newEntry.setBankAccount(doc.getBankAccount());
				newEntry.setSum(doc.getDocSum());
				newEntry.setDoc(doc);
				
				cashMovementService.create(newEntry);
				
			}
			
			if( doc != null ) {
				
				for(PaymentDocumentDetail docDetail: retrieveAllDetails(doc)) {
				
					ProjectFinResultEntry newEntry = new ProjectFinResultEntry();
					
					newEntry.setDate(doc.getDate());
					newEntry.setCostItem(docDetail.getCostItem());
					newEntry.setProject(docDetail.getProject());
					newEntry.setProjectStage(docDetail.getProjectStage());
					newEntry.setSum(docDetail.getSum());
					newEntry.setDoc(doc);
					
					projectFinResultEntryService.create(newEntry);
					
				}
				
			}
			
		} catch (POMServicesException e) {
			LOG.error("Could not generate Transactions: "+e.getMessage(), e);
			throw new POMServicesException("Could not  generate Transactions",e);
		}
		
	}	
	public void deleteTransactions(PaymentDocument doc) throws POMServicesException {
	
		try {
			
			cashMovementService.deleteAllByDoc(doc);
			projectFinResultEntryService.deleteAllByDoc(doc);
		
		} catch (POMServicesException e) {
			
			LOG.error("Could not delete Transactions: "+e.getMessage(), e);
			throw new POMServicesException("Could not  delete Transactions",e);
			
		}
	}
	@Override
	protected String getClassName() {
		return CLASS_NAME;
	}
	@Override
	protected Logger getLogger() {
		return LOG;
	}
	@Override
	protected AbstractDAO<PaymentDocument> getDataObjectDAO() {
		return paymentDocumentDAO;
	}

}
