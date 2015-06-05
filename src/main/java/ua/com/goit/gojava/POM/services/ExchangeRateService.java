package ua.com.goit.gojava.POM.services;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.common.ExchangeRate;
import ua.com.goit.gojava.POM.persistence.hibernate.ExchangeRateDAO;
import ua.com.goit.gojava.POM.persistence.hibernate.abstraction.AbstractDAO;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;

public class ExchangeRateService extends DataObjectService<ExchangeRate> {
	
	private static final String CLASS_NAME = "Exchange Rate"; 
	private static final Logger LOG = Logger.getLogger(ExchangeRateService.class);
	ExchangeRateDAO exchangeRateDAO;

	public void setExchangeRateDAO(ExchangeRateDAO exchangeRateDAO) {
		
		this.exchangeRateDAO = exchangeRateDAO;
		
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
	protected AbstractDAO<ExchangeRate> getDataObjectDAO() {
		return exchangeRateDAO;
	}

}
