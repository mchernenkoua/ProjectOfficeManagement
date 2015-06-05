package ua.com.goit.gojava.POM.presentation.beans.profitcost.projectStage;

import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectStage;
import ua.com.goit.gojava.POM.presentation.beans.common.abstraction.DataObjectConverter;
import ua.com.goit.gojava.POM.services.ProjectStageService;
import ua.com.goit.gojava.POM.services.common.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;


@FacesConverter(forClass = ProjectStage.class)
public class ProjectStageConverter extends DataObjectConverter<ProjectStage> {

	private static final String CLASS_NAME = "Project Stage"; 
	private static final Logger LOG = Logger.getLogger(ProjectStageConverter.class);
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
	protected DataObjectService<ProjectStage> getDataService() {
		return projectStageService;
	}

}
