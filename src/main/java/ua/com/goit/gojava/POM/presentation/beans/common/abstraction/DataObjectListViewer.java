package ua.com.goit.gojava.POM.presentation.beans.common.abstraction;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import ua.com.goit.gojava.POM.dataModel.common.DataObject;
import ua.com.goit.gojava.POM.services.POMServicesException;
import ua.com.goit.gojava.POM.services.common.Paginator;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;


public abstract class DataObjectListViewer<T extends DataObject> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private LazyDataModel<T> dataObjects;
	private T selectedDataObject;
	
	protected abstract String getClassName(); 
	protected abstract Logger getLogger();
	protected abstract DataObjectService<T> getDataService();
	
	protected List<T> getDataList(DataObjectService<T> dataObjectService, Paginator paginator) throws POMServicesException {
		return dataObjectService.retrieveAll(paginator);
	}
	
	protected class DataObjectModel extends LazyDataModel<T> {
		
		private static final long serialVersionUID = 1L;
		private List<T> dataObjectList;
		
		@Override
		public List<T> load(int first, int pageSize, 
						String sortField, SortOrder sortOrder, Map<String, Object> filters) {
			
			DataObjectService<T> dataObjectService = getDataService();
			Paginator paginator = new Paginator();
			paginator.setFirstResult(first);
			paginator.setMaxResults(pageSize);
			
			try {
				dataObjectList = getDataList(dataObjectService, paginator);
			} catch (POMServicesException e) {
				getLogger().error("Can not retrieve "+getClassName()+" List: " + e.getMessage(), e);
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not retrieve "+getClassName()+" List!"));
			}
			
			setRowCount(paginator.getTotal());
	        setPageSize(pageSize);
	 
	        return dataObjectList;
	    }

		@Override
		public Object getRowKey(T dataObject) {
			return dataObject.getId();
		}

		@Override
		public T getRowData(String dataObjectId) {
			Long id = Long.valueOf(dataObjectId);
			for (T dataObject : dataObjectList) {
				if (id.equals(dataObject.getId())) {
					return dataObject;
				}
			}
			return null;
		}
	} 
	
	protected LazyDataModel<T> initDataObjects() {
		return new DataObjectModel();
	}

	public void deleteDataObject(T dataObject){
		
		if(dataObject == null){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Nothing is done!", ""+getClassName()+" not selected!"));
			return;
		}
		
		DataObjectService<T> dataObjectService = getDataService();
		try {
			dataObjectService.delete(dataObject);
			dataObjects = initDataObjects();
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Complete!", ""+getClassName()+" deleted!"));
			
		} catch (POMServicesException e) {
			getLogger().error("Can not delete "+getClassName()+": " + e.getMessage(), e);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not delete "+getClassName()+"!"));
		}
	}
	
	protected void resetObjects() {
		dataObjects = null;
	}
	
	public LazyDataModel<T> getDataObjects() {
		if(dataObjects == null){			
			dataObjects = initDataObjects();
		}
		return dataObjects;
	}
	
	public T getSelectedDataObject() {
		return selectedDataObject;
	}

	public void setSelectedDataObject(T selectedDataObject) {
		this.selectedDataObject = selectedDataObject;
	}

	// Temporary solution for step-by-step migration on JSF.
	// This method redirects to non JSF pages
	public String redirectTo(String action, long id) {
		
		FacesContext context = FacesContext.getCurrentInstance();  
		String rootRef  = context.getExternalContext().getRequestContextPath();  
		HttpServletResponse response  = ((HttpServletResponse)context.getExternalContext().getResponse());  
	    try {
	    	//throw new IOException("Can not redirect to");
	    	String url = rootRef + "/" + action + ((id == 0)? ("") : ("?id=" + id));
			response.sendRedirect(url);
		} catch (IOException e) {
			getLogger().error("Can not redirect to "+action+": " + e.getMessage(), e);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not redirect to "+action+"!"));
		}  
	    context.responseComplete();  
		return action;
	}
	
}
