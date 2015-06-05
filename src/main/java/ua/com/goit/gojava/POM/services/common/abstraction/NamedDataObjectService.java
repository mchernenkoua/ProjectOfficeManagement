package ua.com.goit.gojava.POM.services.common.abstraction;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import ua.com.goit.gojava.POM.dataModel.common.DataObject;
import ua.com.goit.gojava.POM.persistence.POMPersistenceException;
import ua.com.goit.gojava.POM.services.POMServicesException;

public abstract class NamedDataObjectService<T extends DataObject> extends DataObjectService<T>  {

	public List<T> findByName(String query) throws POMServicesException {
		try {
			Criterion restriction = Restrictions.like("name", query);
			return getDataObjectDAO().retrieve(restriction);
		} catch (POMPersistenceException e) {
			getLogger().error("Could not find by name "+getClassName()+": "+e.getMessage(), e);
			throw new POMServicesException("Could not find by name "+getClassName()+"",e);
		}
	}
	
}
