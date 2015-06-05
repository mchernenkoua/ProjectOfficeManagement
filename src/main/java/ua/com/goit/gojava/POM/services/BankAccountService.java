package ua.com.goit.gojava.POM.services;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.persistence.hibernate.BankAccountDAO;
import ua.com.goit.gojava.POM.persistence.hibernate.abstraction.AbstractDAO;
import ua.com.goit.gojava.POM.services.common.abstraction.NamedDataObjectService;

public class BankAccountService extends NamedDataObjectService<BankAccount> {
	
	private static final String CLASS_NAME = "Bank Account"; 
	private static final Logger LOG = Logger.getLogger(BankAccountService.class);
	BankAccountDAO bankAccountDAO;

	public void setBankAccountDAO(BankAccountDAO bankAccountDAO) {
		this.bankAccountDAO = bankAccountDAO;
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
	protected AbstractDAO<BankAccount> getDataObjectDAO() {
		return bankAccountDAO;
	}

}
