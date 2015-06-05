package ua.com.goit.gojava.POM.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import ua.com.goit.gojava.POM.dataModel.profitcost.Project;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectStage;
import ua.com.goit.gojava.POM.persistence.POMPersistenceException;
import ua.com.goit.gojava.POM.persistence.hibernate.ProjectStageDAO;
import ua.com.goit.gojava.POM.persistence.hibernate.abstraction.AbstractDAO;
import ua.com.goit.gojava.POM.services.common.Paginator;
import ua.com.goit.gojava.POM.services.common.abstraction.NamedDataObjectService;

public class ProjectStageService extends NamedDataObjectService<ProjectStage> {
	
	private static final String CLASS_NAME = "Project Stage"; 
	private static final Logger LOG = Logger.getLogger(ProjectStageService.class);
	ProjectStageDAO projectStageDAO;

	public void setProjectStageDAO(ProjectStageDAO projectStageDAO) {
		this.projectStageDAO = projectStageDAO;
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
	protected AbstractDAO<ProjectStage> getDataObjectDAO() {
		return projectStageDAO;
	}

	public List<ProjectStage> retrieveAll(Project project, Paginator paginator) throws POMServicesException {

		try {
			Criterion restriction = Restrictions.eq("parent", project);
			return projectStageDAO.retrieve(restriction, paginator);
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve all "+CLASS_NAME+"s: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve all "+CLASS_NAME+"s",e);
		}
		
	}
	
	
}
