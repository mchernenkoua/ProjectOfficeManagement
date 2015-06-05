package ua.com.goit.gojava.POM.presentation.beans.profitcost;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.Project;
import ua.com.goit.gojava.POM.presentation.beans.common.abstraction.DataObjectAutoCompleter;
import ua.com.goit.gojava.POM.services.ProjectService;
import ua.com.goit.gojava.POM.services.common.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.common.abstraction.NamedDataObjectService;


@RequestScoped
@ManagedBean
public class ProjectAutoCompleter extends DataObjectAutoCompleter<Project>{

	private static final long serialVersionUID = 1L;
	private static final String CLASS_NAME = "Project"; 
	private static final Logger LOG = Logger.getLogger(ProjectAutoCompleter.class);
	private ProjectService projectService = 
			ApplicationContextProvider.getApplicationContext().getBean(ProjectService.class);
	
	@Override
	protected String getClassName() {
		return CLASS_NAME;
	}

	@Override
	protected Logger getLogger() {
		return LOG;
	}

	@Override
	protected NamedDataObjectService<Project> getDataService() {
		return projectService;
	}
}
