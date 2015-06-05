package ua.com.goit.gojava.POM.presentation.beans.profitcost.projectStage;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;

import ua.com.goit.gojava.POM.dataModel.profitcost.Project;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectStage;
import ua.com.goit.gojava.POM.presentation.beans.common.abstraction.DataObjectListViewer;
import ua.com.goit.gojava.POM.services.POMServicesException;
import ua.com.goit.gojava.POM.services.ProjectStageService;
import ua.com.goit.gojava.POM.services.common.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.common.Paginator;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;


@ViewScoped
@ManagedBean
public class ProjectStageListBean extends DataObjectListViewer<ProjectStage> {

	private static final long serialVersionUID = 1L;
	private static final String CLASS_NAME = "Project Stage"; 
	private static final Logger LOG=Logger.getLogger(ProjectStageListBean.class);
	private ProjectStageService projectStageService = 
			ApplicationContextProvider.getApplicationContext().getBean(ProjectStageService.class);

	private Project projectFilter;
	
	@Override
	protected LazyDataModel<ProjectStage> initDataObjects() {
		
		return new DataObjectModel() {

			private static final long serialVersionUID = 1L;
			
			@Override
			public List<ProjectStage> getDataList(
					DataObjectService<ProjectStage> dataObjectService, Paginator paginator) throws POMServicesException {
			
				if (projectFilter == null) {
					return projectStageService.retrieveAll(paginator);
				} else {
					return projectStageService.retrieveAll(projectFilter, paginator);
				}
			}

		};
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
	protected DataObjectService<ProjectStage> getDataService() {
		return projectStageService;
	}
	
	public Project getProjectFilter() {
		return projectFilter;
	}

	public void setProjectFilter(Project projectFilter) {
		this.projectFilter = projectFilter;
	}
	
}
