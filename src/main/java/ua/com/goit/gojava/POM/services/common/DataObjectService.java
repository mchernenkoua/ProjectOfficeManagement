package ua.com.goit.gojava.POM.services.common;

import java.util.List;

import ua.com.goit.gojava.POM.dataModel.common.DataObject;
import ua.com.goit.gojava.POM.services.POMServicesException;

public abstract class DataObjectService<T extends DataObject> {

	public abstract T retrieveById(long id) throws POMServicesException;
	public abstract List<T> findByName(String query) throws POMServicesException;
	public abstract List<T> retrieveAll() throws POMServicesException;
	public abstract List<T> retrieveAll(Paginator paginator) throws POMServicesException;
	
}
