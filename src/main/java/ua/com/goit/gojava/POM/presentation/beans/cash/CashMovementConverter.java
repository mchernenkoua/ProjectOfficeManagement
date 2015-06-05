package ua.com.goit.gojava.POM.presentation.beans.cash;

import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.cash.CashMovementEntry;
import ua.com.goit.gojava.POM.presentation.beans.common.abstraction.DataObjectConverter;
import ua.com.goit.gojava.POM.services.CashMovementService;
import ua.com.goit.gojava.POM.services.common.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;


@FacesConverter(forClass = CashMovementEntry.class)
public class CashMovementConverter extends DataObjectConverter<CashMovementEntry> {

	private static final String CLASS_NAME = "Cash Movement"; 
	private static final Logger LOG = Logger.getLogger(CashMovementConverter.class);
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

}
