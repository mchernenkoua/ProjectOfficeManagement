package ua.com.goit.gojava.POM.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import ua.com.goit.gojava.POM.dataModel.profitcost.CostItem;
import ua.com.goit.gojava.POM.persistence.POMPersistenceException;
import ua.com.goit.gojava.POM.persistence.hibernate.CostItemDAO;
import ua.com.goit.gojava.POM.services.common.Paginator;

public class CostItemService {
	
	private static final String CLASS_NAME = "Cost Item"; 
	private static final Logger LOG = Logger.getLogger(CostItemService.class);
	CostItemDAO costItemDAO;

	public void setCostItemDAO(CostItemDAO costItemDAO) {
		
		this.costItemDAO = costItemDAO;
		
	}
	
	public List<CostItem> retrieveAll() throws POMServicesException {
		
		try {
			return costItemDAO.retrieveAll();
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve all "+CLASS_NAME+"s: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve all "+CLASS_NAME+"s",e);
		}
		
	}
	
	public List<CostItem> retrieveAll(Paginator paginator) throws POMServicesException {
		
		try {
			return costItemDAO.retrieveAll(paginator);
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve all "+CLASS_NAME+"s: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve all "+CLASS_NAME+"s",e);
		}
	}

	public CostItem retrieveById(long id) throws POMServicesException {

		try {
			return costItemDAO.retrieveById(id);
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve "+CLASS_NAME+" by ID: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve "+CLASS_NAME+" by ID",e);
		}
	}

	public void delete(CostItem costItem) throws POMServicesException {

		try {
			costItemDAO.delete(costItem);
		} catch (POMPersistenceException e) {
			LOG.error("Could not delete "+CLASS_NAME+": "+e.getMessage(), e);
			throw new POMServicesException("Could not delete "+CLASS_NAME+"",e);
		}
	}

	public void create(CostItem costItem) throws POMServicesException {

		try {
			costItemDAO.create(costItem);
		} catch (POMPersistenceException e) {
			LOG.error("Could not create "+CLASS_NAME+": "+e.getMessage(), e);
			throw new POMServicesException("Could not create "+CLASS_NAME+"",e);
		}
	}

	public void update(CostItem costItem) throws POMServicesException {

		try {
			costItemDAO.update(costItem);
		} catch (POMPersistenceException e) {
			LOG.error("Could not update "+CLASS_NAME+": "+e.getMessage(), e);
			throw new POMServicesException("Could not update "+CLASS_NAME+"",e);
		}
	}

	public List<CostItem> findByName(String query) throws POMServicesException  {

		try {
			
			Criterion restriction = Restrictions.like("name", query);
			return costItemDAO.retrieve(restriction);
		} catch (POMPersistenceException e) {
			LOG.error("Could not find by name "+CLASS_NAME+": "+e.getMessage(), e);
			throw new POMServicesException("Could not find by name "+CLASS_NAME+"",e);
		}
	}

}
