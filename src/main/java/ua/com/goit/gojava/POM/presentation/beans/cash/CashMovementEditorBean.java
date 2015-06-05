package ua.com.goit.gojava.POM.presentation.beans.cash;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.cash.CashMovementEntry;
import ua.com.goit.gojava.POM.presentation.beans.common.abstraction.DataObjectEditor;
import ua.com.goit.gojava.POM.services.CashMovementService;
import ua.com.goit.gojava.POM.services.common.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;


@RequestScoped
@ManagedBean
public class CashMovementEditorBean extends DataObjectEditor<CashMovementEntry> {

	private static final long serialVersionUID = 1L;
	private static final String CLASS_NAME = "Cash Movement"; 
	private static final Logger LOG = Logger.getLogger(CashMovementEditorBean.class);
	private CashMovementService cashMovementService = 
			ApplicationContextProvider.getApplicationContext().getBean(CashMovementService.class);

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

	@Override
	protected CashMovementEntry getNewObject() {
		return new CashMovementEntry();
	}
	
}
