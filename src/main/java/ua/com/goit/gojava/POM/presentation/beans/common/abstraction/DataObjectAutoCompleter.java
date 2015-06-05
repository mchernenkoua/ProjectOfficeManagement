package ua.com.goit.gojava.POM.presentation.beans.common.abstraction;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.common.DataObject;
import ua.com.goit.gojava.POM.services.POMServicesException;
import ua.com.goit.gojava.POM.services.common.abstraction.NamedDataObjectService;


public abstract class DataObjectAutoCompleter<T extends DataObject> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected abstract String getClassName(); 
	protected abstract Logger getLogger();
	protected abstract NamedDataObjectService<T> getDataService();

	public List<T> completeText(String query) {

		NamedDataObjectService<T> dataObjectService = getDataService();
		List<T> result = null;
		try {
			if(!query.isEmpty()){
				result = dataObjectService.findByName(query);
			} else {
				result = dataObjectService.retrieveAll();
			}
		} catch (POMServicesException e) {
			getLogger().error("Can not retrieve "+getClassName()+" List: " + e.getMessage(), e);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not retrieve "+getClassName()+" List!"));
		}
		result.add(0, null);
		return result;
    }
}
