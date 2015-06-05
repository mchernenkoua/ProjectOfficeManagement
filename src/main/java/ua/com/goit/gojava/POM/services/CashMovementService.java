package ua.com.goit.gojava.POM.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.dataModel.cash.CashMovementEntry;
import ua.com.goit.gojava.POM.dataModel.common.FinancialDocument;
import ua.com.goit.gojava.POM.dataModel.common.Money;
import ua.com.goit.gojava.POM.persistence.POMPersistenceException;
import ua.com.goit.gojava.POM.persistence.hibernate.CashMovementDAO;
import ua.com.goit.gojava.POM.persistence.hibernate.abstraction.AbstractDAO;
import ua.com.goit.gojava.POM.services.common.Paginator;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;

public class CashMovementService extends DataObjectService<CashMovementEntry> {
	
	private static final String CLASS_NAME = "Cash Movement"; 
	private static final Logger LOG = Logger.getLogger(CashMovementService.class);
	CashMovementDAO cashMovementDAO;

	@Override
	protected String getClassName() {
		return CLASS_NAME;
	}

	@Override
	protected Logger getLogger() {
		return LOG;
	}

	@Override
	protected AbstractDAO<CashMovementEntry> getDataObjectDAO() {
		return cashMovementDAO;
	}

	public void setCashMovementDAO(CashMovementDAO cashMovementDAO) {
		
		this.cashMovementDAO = cashMovementDAO;
		
	}
	
	public Money getTotalByBankAccount(BankAccount bankAccount) throws POMServicesException {
		
		try {
			return cashMovementDAO.getTotalByBankAccount(bankAccount);
		} catch (POMPersistenceException e) {
			LOG.error("Could not get total by "+CLASS_NAME+": "+e.getMessage(), e);
			throw new POMServicesException("Could not get total by "+CLASS_NAME+"",e);
		}
		
	}

	public List<CashMovementEntry> retrieveAll(BankAccount bankAccount, Paginator paginator) throws POMServicesException {

		try {
			Criterion restriction = Restrictions.eq("bankAccount", bankAccount);
			return cashMovementDAO.retrieve(restriction, paginator);
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve all "+CLASS_NAME+"s: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve all "+CLASS_NAME+"s",e);
		}
		
	}
	
	public void deleteAllByDoc(FinancialDocument doc) throws POMServicesException {

		try {
			cashMovementDAO.deleteAllByDoc(doc);
		} catch (POMPersistenceException e) {
			LOG.error("Could not delete all "+CLASS_NAME+"s by doc: "+e.getMessage(), e);
			throw new POMServicesException("Could not delete all "+CLASS_NAME+"s by doc",e);
		}
		
	}

}
