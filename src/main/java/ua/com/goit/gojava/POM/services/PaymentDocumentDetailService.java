package ua.com.goit.gojava.POM.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;

import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocumentDetail;
import ua.com.goit.gojava.POM.persistence.POMPersistenceException;
import ua.com.goit.gojava.POM.persistence.hibernate.PaymentDocumentDetailDAO;
import ua.com.goit.gojava.POM.persistence.hibernate.abstraction.AbstractDAO;
import ua.com.goit.gojava.POM.services.common.Paginator;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;

public class PaymentDocumentDetailService extends DataObjectService<PaymentDocumentDetail> {

	private static final String CLASS_NAME = "Payment Document Details"; 
	private static final Logger LOG = Logger.getLogger(PaymentDocumentDetailService.class);
	private PaymentDocumentDetailDAO paymentDocumentDetailDAO;

	@Override
	protected String getClassName() {
		return CLASS_NAME;
	}

	@Override
	protected Logger getLogger() {
		return LOG;
	}

	@Override
	protected AbstractDAO<PaymentDocumentDetail> getDataObjectDAO() {
		return paymentDocumentDetailDAO;
	}
	
	public PaymentDocumentDetailDAO getPaymentDocumentDetailDAO() {
		return paymentDocumentDetailDAO;
	}
	public void setPaymentDocumentDetailDAO(PaymentDocumentDetailDAO paymentDocumentDetailDAO) {
		this.paymentDocumentDetailDAO = paymentDocumentDetailDAO;
	}

	public List<PaymentDocumentDetail> retrieve(Criterion restriction, Paginator paginator) throws POMServicesException {
		try {
			return paymentDocumentDetailDAO.retrieve(restriction, paginator);
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve doc detail: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve doc detail",e);
		}
	}

	public List<PaymentDocumentDetail> retrieve(Criterion restriction) throws POMServicesException {
		try {
			return paymentDocumentDetailDAO.retrieve(restriction);
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve doc detail: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve doc detail",e);
		}
	}
}