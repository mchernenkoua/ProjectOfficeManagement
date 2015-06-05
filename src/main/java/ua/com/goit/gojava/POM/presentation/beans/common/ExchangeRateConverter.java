package ua.com.goit.gojava.POM.presentation.beans.common;

import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.common.ExchangeRate;
import ua.com.goit.gojava.POM.presentation.beans.common.abstraction.DataObjectConverter;
import ua.com.goit.gojava.POM.services.ExchangeRateService;
import ua.com.goit.gojava.POM.services.common.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;


@FacesConverter(forClass = ExchangeRate.class)
public class ExchangeRateConverter extends DataObjectConverter<ExchangeRate> {

	private static final String CLASS_NAME = "Exchange Rate"; 
	private static final Logger LOG = Logger.getLogger(ExchangeRateConverter.class);
	private ExchangeRateService exchangeRateService = 
			ApplicationContextProvider.getApplicationContext().getBean(ExchangeRateService.class);

	@Override
	protected String getClassName() {
		return CLASS_NAME;
	}

	@Override
	protected Logger getLogger() {
		return LOG;
	}

	@Override
	protected DataObjectService<ExchangeRate> getDataService() {
		return exchangeRateService;
	}

}
