package ua.com.goit.gojava.POM.presentation.beans.common.abstraction;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.common.DataObject;
import ua.com.goit.gojava.POM.services.POMServicesException;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;

public abstract class DataObjectEditor<T extends DataObject> implements Serializable {

	private static final long serialVersionUID = 1L;
	private T dataObject;
	
	protected abstract String getClassName(); 
	protected abstract Logger getLogger();
	protected abstract DataObjectService<T> getDataService();
	protected abstract T getNewObject();
	
	public void setDataObject(T dataObject) {
		this.dataObject = dataObject;
	}

	public T getDataObject() {
		if(dataObject == null){			
			dataObject = getNewObject();
		}
		return dataObject;
	}
	
	public void save() {
		
		DataObjectService<T> dataObjectService = getDataService();
		try {
			if(dataObject.getId() == 0) {
				dataObjectService.create(dataObject);
			} else {
				dataObjectService.update(dataObject);
			}
			
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Complete!", ""+getClassName()+" saved!"));
		
		} catch (POMServicesException e) {
			getLogger().error("Can not save "+getClassName()+": " + e.getMessage(), e);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not save "+getClassName()+"!"));
		}
	}
	
}
