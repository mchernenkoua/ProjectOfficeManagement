package ua.com.goit.gojava.POM.presentation.beans.cash;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.dataModel.common.Money;
import ua.com.goit.gojava.POM.presentation.beans.common.abstraction.DataObjectListViewer;
import ua.com.goit.gojava.POM.services.BankAccountService;
import ua.com.goit.gojava.POM.services.CashMovementService;
import ua.com.goit.gojava.POM.services.POMServicesException;
import ua.com.goit.gojava.POM.services.common.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;

@ViewScoped
@ManagedBean
public class BankAccountListBean extends DataObjectListViewer<BankAccount> {

	private static final long serialVersionUID = 1L;
	private static final String CLASS_NAME = "Bank Account"; 
	private static final Logger LOG=Logger.getLogger(BankAccountListBean.class);
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
	
	public Money getTotal(BankAccount bankAccount){
		
		Money result = null;
		CashMovementService cashMovementService = ApplicationContextProvider.getApplicationContext().getBean(CashMovementService.class);
		try {
			result = cashMovementService.getTotalByBankAccount(bankAccount);
		} catch (POMServicesException e) {
			LOG.error("Can not retrieve Total by BankAccount: " + e.getMessage(), e);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not retrieve Total by BankAccount!"));
		}
		return result;
		
	}	 
	
}
