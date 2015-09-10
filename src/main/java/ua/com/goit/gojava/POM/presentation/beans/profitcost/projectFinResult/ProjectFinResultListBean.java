package ua.com.goit.gojava.POM.presentation.beans.profitcost.projectFinResult;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.Project;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectFinResultEntry;
import ua.com.goit.gojava.POM.presentation.beans.common.abstraction.DataObjectListViewer;
import ua.com.goit.gojava.POM.services.POMServicesException;
import ua.com.goit.gojava.POM.services.ProjectFinResultEntryService;
import ua.com.goit.gojava.POM.services.common.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.common.Paginator;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;


@ViewScoped
@ManagedBean
public class ProjectFinResultListBean extends DataObjectListViewer<ProjectFinResultEntry> {

	private static final long serialVersionUID = 1L;
	private static final String CLASS_NAME = "Project Fin Result"; 
	private static final Logger LOG=Logger.getLogger(ProjectFinResultListBean.class);
	private ProjectFinResultEntryService projectFinResultEntryService = 
			ApplicationContextProvider.getApplicationContext().getBean(ProjectFinResultEntryService.class);

	private Project projectFilter;
	
	@Override
	protected List<ProjectFinResultEntry> getDataList(
			DataObjectService<ProjectFinResultEntry> dataObjectService, Paginator paginator) throws POMServicesException {
	
		if (projectFilter == null) {
			return projectFinResultEntryService.retrieveAll(paginator);
		} else {
			return projectFinResultEntryService.retrieveAll(projectFilter, paginator);
		}
	}

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
	
	public Project getProjectFilter() {
		return projectFilter;
	}

	public void setProjectFilter(Project projectFilter) {
		this.projectFilter = projectFilter;
	}
	
}
