package ua.com.goit.gojava.POM.presentation.beans.profitcost.projectFinResult;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectFinResultEntry;
import ua.com.goit.gojava.POM.presentation.beans.common.abstraction.DataObjectEditor;
import ua.com.goit.gojava.POM.services.ProjectFinResultEntryService;
import ua.com.goit.gojava.POM.services.common.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;


@RequestScoped
@ManagedBean
public class ProjectFinResultEditorBean extends DataObjectEditor<ProjectFinResultEntry> {

	private static final long serialVersionUID = 1L;
	private static final String CLASS_NAME = "Project Fin Result"; 
	private static final Logger LOG = Logger.getLogger(ProjectFinResultEditorBean.class);
	private ProjectFinResultEntryService projectFinResultEntryService = 
			ApplicationContextProvider.getApplicationContext().getBean(ProjectFinResultEntryService.class);

	@Override
	protected String getClassName() {
		return CLASS_NAME;
	}

	@Override
	protected Logger getLogger() {
		return LOG;
	}

	@Override
	protected DataObjectService<ProjectFinResultEntry> getDataService() {
		return projectFinResultEntryService;
	}

	@Override
	protected ProjectFinResultEntry getNewObject() {
		return new ProjectFinResultEntry();
	}
	
}
