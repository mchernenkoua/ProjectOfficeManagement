package ua.com.goit.gojava.POM.presentation.beans.cash;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.dataModel.cash.CashMovementEntry;
import ua.com.goit.gojava.POM.presentation.beans.common.abstraction.DataObjectListViewer;
import ua.com.goit.gojava.POM.services.CashMovementService;
import ua.com.goit.gojava.POM.services.POMServicesException;
import ua.com.goit.gojava.POM.services.common.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.common.Paginator;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;


@ViewScoped
@ManagedBean
public class CashMovementListBean extends DataObjectListViewer<CashMovementEntry> {

	private static final long serialVersionUID = 1L;
	private static final String CLASS_NAME = "Cash Movement"; 
	private static final Logger LOG=Logger.getLogger(CashMovementListBean.class);
	private CashMovementService cashMovementService = 
			ApplicationContextProvider.getApplicationContext().getBean(CashMovementService.class);

	private BankAccount bankAccountFilter;
	
	@Override
	protected List<CashMovementEntry> getDataList(
			DataObjectService<CashMovementEntry> dataObjectService, Paginator paginator) throws POMServicesException {
	
		if (bankAccountFilter == null) {
			return cashMovementService.retrieveAll(paginator);
		} else {
			return cashMovementService.retrieveAll(bankAccountFilter, paginator);
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
	protected DataObjectService<CashMovementEntry> getDataService() {
		return cashMovementService;
	}
	
	public BankAccount getBankAccountFilter() {
		return bankAccountFilter;
	}

	public void setBankAccountFilter(BankAccount bankAccountFilter) {
		this.bankAccountFilter = bankAccountFilter;
	}
	
}
