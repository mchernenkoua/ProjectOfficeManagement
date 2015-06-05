package ua.com.goit.gojava.POM.services.common.abstraction;

import java.util.List;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.common.DataObject;
import ua.com.goit.gojava.POM.persistence.POMPersistenceException;
import ua.com.goit.gojava.POM.persistence.hibernate.abstraction.AbstractDAO;
import ua.com.goit.gojava.POM.services.POMServicesException;
import ua.com.goit.gojava.POM.services.common.Paginator;

public abstract class DataObjectService<T extends DataObject> {

	protected abstract String getClassName(); 
	protected abstract Logger getLogger();
	protected abstract AbstractDAO<T> getDataObjectDAO(); 
	
	public T retrieveById(long id) throws POMServicesException {
		try {
			return getDataObjectDAO().retrieveById(id);
		} catch (POMPersistenceException e) {
			getLogger().error("Could not retrieve "+getClassName()+" by ID: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve "+getClassName()+" by ID",e);
		}
	}
	public void create(T dataObject) throws POMServicesException {
		try {
			getDataObjectDAO().create(dataObject);
		} catch (POMPersistenceException e) {
			getLogger().error("Could not create "+getClassName()+": "+e.getMessage(), e);
			throw new POMServicesException("Could not create "+getClassName()+"",e);
		}
	}
	public void update(T dataObject) throws POMServicesException {
		try {
			getDataObjectDAO().update(dataObject);
		} catch (POMPersistenceException e) {
			getLogger().error("Could not update "+getClassName()+": "+e.getMessage(), e);
			throw new POMServicesException("Could not update "+getClassName()+"",e);
		}
	}
	public void delete(T dataObject) throws POMServicesException {
		try {
			getDataObjectDAO().delete(dataObject);
		} catch (POMPersistenceException e) {
			getLogger().error("Could not delete "+getClassName()+": "+e.getMessage(), e);
			throw new POMServicesException("Could not delete "+getClassName()+"",e);
		}
	}
	public List<T> retrieveAll() throws POMServicesException {
		try {
			return getDataObjectDAO().retrieveAll();
		} catch (POMPersistenceException e) {
			getLogger().error("Could not retrieve all "+getClassName()+"s: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve all "+getClassName()+"s: ",e);
		}
	}
	public List<T> retrieveAll(Paginator paginator) throws POMServicesException {
		try {
			return getDataObjectDAO().retrieveAll(paginator);
		} catch (POMPersistenceException e) {
			getLogger().error("Could not retrieve all "+getClassName()+"s: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve all "+getClassName()+"s: ",e);
		}
	}
	
}
