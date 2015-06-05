package ua.com.goit.gojava.POM.presentation.beans.profitcost;

import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.Project;
import ua.com.goit.gojava.POM.presentation.beans.common.abstraction.DataObjectConverter;
import ua.com.goit.gojava.POM.services.ProjectService;
import ua.com.goit.gojava.POM.services.common.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;


@FacesConverter(forClass = Project.class)
public class ProjectConverter extends DataObjectConverter<Project> {

	private static final String CLASS_NAME = "Project"; 
	private static final Logger LOG = Logger.getLogger(ProjectConverter.class);
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
	protected DataObjectService<Project> getDataService() {
		return projectService;
	}

}
