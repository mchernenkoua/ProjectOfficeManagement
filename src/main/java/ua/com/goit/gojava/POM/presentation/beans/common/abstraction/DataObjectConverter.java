package ua.com.goit.gojava.POM.presentation.beans.common.abstraction;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.common.DataObject;
import ua.com.goit.gojava.POM.services.POMServicesException;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;

public abstract class DataObjectConverter<T extends DataObject> implements Converter {

	protected abstract String getClassName(); 
	protected abstract Logger getLogger();
	protected abstract DataObjectService<T> getDataService();

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		T result = null;
		
		if(arg2 != null && arg2.trim().length() > 0) {
			
			DataObjectService<T> dataObjectService = getDataService();
			try {
            	result = dataObjectService.retrieveById(Long.parseLong(arg2));    
            } catch( NullPointerException | IllegalArgumentException | POMServicesException e) {
            	getLogger().error("Can not convert "+getClassName()+": " + e.getMessage(), e);
            	arg0.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not convert "+getClassName()+": !"));
    		}
        }
		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		
		String objName = "";
		if(arg2 != null) {
			objName = ((Long)((T)arg2).getId()).toString();
        }

		return objName;
	}

}
