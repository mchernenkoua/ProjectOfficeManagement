package ua.com.goit.gojava.POM.presentation.beans.cash;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.presentation.beans.common.abstraction.DataObjectAutoCompleter;
import ua.com.goit.gojava.POM.services.BankAccountService;
import ua.com.goit.gojava.POM.services.common.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;


@RequestScoped
@ManagedBean
public class BankAccountAutoCompleter extends DataObjectAutoCompleter<BankAccount> {

	private static final long serialVersionUID = 1L;
	private static final String CLASS_NAME = "Bank Account"; 
	private static final Logger LOG = Logger.getLogger(BankAccountAutoCompleter.class);
	private BankAccountService bankAccountService = 
			ApplicationContextProvider.getApplicationContext().getBean(BankAccountService.class);

	@Override
	protected String getClassName() {
		return CLASS_NAME;		
	}

	@Override
	protected Logger getLogger() {
		return LOG;
	}

	@Override
	protected DataObjectService<BankAccount> getDataService() {
		return bankAccountService;
	}
}
