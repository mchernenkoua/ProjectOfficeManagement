package ua.com.goit.gojava.POM.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import ua.com.goit.gojava.POM.dataModel.common.FinancialDocument;
import ua.com.goit.gojava.POM.dataModel.profitcost.Project;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectFinResultEntry;
import ua.com.goit.gojava.POM.persistence.POMPersistenceException;
import ua.com.goit.gojava.POM.persistence.hibernate.ProjectFinResultEntryDAO;
import ua.com.goit.gojava.POM.persistence.hibernate.abstraction.AbstractDAO;
import ua.com.goit.gojava.POM.services.common.Paginator;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;

public class ProjectFinResultEntryService extends DataObjectService<ProjectFinResultEntry> {
	
	private static final String CLASS_NAME = "Project FinResult Entry"; 
	private static final Logger LOG = Logger.getLogger(ProjectFinResultEntryService.class);
	ProjectFinResultEntryDAO projectFinResultEntryDAO;

	public void setProjectFinResultEntryDAO(ProjectFinResultEntryDAO projectFinResultEntryDAO) {	
		this.projectFinResultEntryDAO = projectFinResultEntryDAO;		
	}
	
	public List<ProjectFinResultEntry> retrieveAll(Project project, Paginator paginator) throws POMServicesException {

		try {
			Criterion restriction = Restrictions.eq("project", project);
			return projectFinResultEntryDAO.retrieve(restriction, paginator);
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve all "+CLASS_NAME+"s: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve all "+CLASS_NAME+"s",e);
		}
		
	}
	
	public void deleteAllByDoc(FinancialDocument doc) throws POMServicesException {
		try {
			projectFinResultEntryDAO.deleteAllByDoc(doc);
		} catch (POMPersistenceException e) {
			LOG.error("Could not delete all by Doc: "+e.getMessage(), e);
			throw new POMServicesException("Could not delete all by Doc",e);
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
	protected AbstractDAO<ProjectFinResultEntry> getDataObjectDAO() {
		return projectFinResultEntryDAO;
	}

}
