package ua.com.goit.gojava.POM.dataModel.profitcost;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ua.com.goit.gojava.POM.dataModel.common.DataObject;

@Entity
@Table(name = "projects")
public class Project implements DataObject {
	
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	@Enumerated(EnumType.STRING)
	private ProjectType type = ProjectType.OUTER;
	
	@Column
	private boolean active;
	
	@Column
	private String pm;
	
	@Override
	public long getId() {
		
		return id;
		
	}
	
	public void setId(long id) {
		
		this.id = id;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public String getDescription() {
		
		return description;
		
	}
	
	public void setDescription(String description) {
		
		this.description = description;
		
	}
	
	public ProjectType getType() {
		
		return type;
		
	}
	
	public void setType(ProjectType type) {
		
		this.type = type;
		
	}
	
	public boolean isActive() {
		
		return active;
		
	}
	
	public void setActive(boolean active) {
		
		this.active = active;
		
	}
	
	public String getPm() {
		
		return pm;
		
	}
	
	public void setPm(String pm) {
		
		this.pm = pm;
		
	}
	
}