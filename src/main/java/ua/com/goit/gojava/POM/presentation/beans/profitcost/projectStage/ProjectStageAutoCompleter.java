package ua.com.goit.gojava.POM.presentation.beans.profitcost.projectStage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectStage;
import ua.com.goit.gojava.POM.presentation.beans.common.abstraction.DataObjectAutoCompleter;
import ua.com.goit.gojava.POM.services.ProjectStageService;
import ua.com.goit.gojava.POM.services.common.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.common.abstraction.NamedDataObjectService;


@RequestScoped
@ManagedBean
public class ProjectStageAutoCompleter extends DataObjectAutoCompleter<ProjectStage>{

	private static final long serialVersionUID = 1L;
	private static final String CLASS_NAME = "Project Stage"; 
	private static final Logger LOG = Logger.getLogger(ProjectStageAutoCompleter.class);
	private ProjectStageService projectStageService = 
			ApplicationContextProvider.getApplicationContext().getBean(ProjectStageService.class);
	
	@Override
	protected String getClassName() {
		return CLASS_NAME;
	}

	@Override
	protected Logger getLogger() {
		return LOG;
	}

	@Override
	protected NamedDataObjectService<ProjectStage> getDataService() {
		return projectStageService;
	}
}
