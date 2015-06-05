package ua.com.goit.gojava.POM.services;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.CostItem;
import ua.com.goit.gojava.POM.persistence.hibernate.CostItemDAO;
import ua.com.goit.gojava.POM.persistence.hibernate.abstraction.AbstractDAO;
import ua.com.goit.gojava.POM.services.common.abstraction.NamedDataObjectService;

public class CostItemService extends NamedDataObjectService<CostItem> {
	
	private static final String CLASS_NAME = "Cost Item"; 
	private static final Logger LOG = Logger.getLogger(CostItemService.class);
	CostItemDAO costItemDAO;

	public void setCostItemDAO(CostItemDAO costItemDAO) {
		this.costItemDAO = costItemDAO;
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
	protected AbstractDAO<CostItem> getDataObjectDAO() {
		return costItemDAO;
	}

}
