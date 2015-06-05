package ua.com.goit.gojava.POM.services;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.Project;
import ua.com.goit.gojava.POM.persistence.hibernate.ProjectDAO;
import ua.com.goit.gojava.POM.persistence.hibernate.abstraction.AbstractDAO;
import ua.com.goit.gojava.POM.services.common.abstraction.NamedDataObjectService;

public class ProjectService extends NamedDataObjectService<Project> {
	
	private static final String CLASS_NAME = "Project"; 
	private static final Logger LOG = Logger.getLogger(ProjectService.class);
	ProjectDAO projectDAO;

	public void setProjectDAO(ProjectDAO projectDAO) {		
		this.projectDAO = projectDAO;	
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
	protected AbstractDAO<Project> getDataObjectDAO() {
		return projectDAO;
	}

}
