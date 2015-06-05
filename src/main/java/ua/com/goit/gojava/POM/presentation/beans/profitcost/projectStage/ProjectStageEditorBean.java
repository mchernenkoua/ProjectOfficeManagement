package ua.com.goit.gojava.POM.presentation.beans.profitcost.projectStage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectStage;
import ua.com.goit.gojava.POM.presentation.beans.common.abstraction.DataObjectEditor;
import ua.com.goit.gojava.POM.services.ProjectStageService;
import ua.com.goit.gojava.POM.services.common.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;


@RequestScoped
@ManagedBean
public class ProjectStageEditorBean extends DataObjectEditor<ProjectStage> {

	private static final long serialVersionUID = 1L;
	private static final String CLASS_NAME = "Project Stage"; 
	private static final Logger LOG=Logger.getLogger(ProjectStageEditorBean.class);
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

	@Override
	protected ProjectStage getNewObject() {
		return new ProjectStage();
	}
	
}
