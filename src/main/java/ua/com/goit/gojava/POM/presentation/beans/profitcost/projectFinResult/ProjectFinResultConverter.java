package ua.com.goit.gojava.POM.presentation.beans.profitcost.projectFinResult;

import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectFinResultEntry;
import ua.com.goit.gojava.POM.presentation.beans.common.abstraction.DataObjectConverter;
import ua.com.goit.gojava.POM.services.ProjectFinResultEntryService;
import ua.com.goit.gojava.POM.services.common.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;


@FacesConverter(forClass = ProjectFinResultEntry.class)
public class ProjectFinResultConverter extends DataObjectConverter<ProjectFinResultEntry> {

	private static final String CLASS_NAME = "Cash Movement"; 
	private static final Logger LOG = Logger.getLogger(ProjectFinResultConverter.class);
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

}
