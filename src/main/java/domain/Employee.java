package domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
	@Entity
	@Table(name="employee")
	public class Employee {
	
			@Id
			@GeneratedValue(strategy = GenerationType.AUTO)
			@Column(name = "idemployee")
			private int idemployee;
			private String name;
	 
			@ManyToMany
			@JoinTable(name="employee_project",
			joinColumns= @JoinColumn(name="idemployee"),
			inverseJoinColumns= @JoinColumn(name="idproject"))
			private List<Project> projects= new ArrayList<Project>();
	 
			public int getIdemployee() {
				return idemployee;
			}
	 
			public void setIdemployee(int idemployee) {
				this.idemployee = idemployee;
			}
	 
			public String getName() {
				return name;
			}
			
			public void setName(String name) {
				this.name = name;
			}
	 
			public List<Project> getProjects() {
				return projects;
			}
	 
			public void setProjects(List<Project> projects) {
				this.projects = projects;
			}

			@Override
			public String toString() {
				return "Employee [idemployee=" + idemployee + ", name=" + name + ", projects=" + projects
						+ ", getIdemployee()=" + getIdemployee() + ", getName()=" + getName() + ", getProjects()="
						+ getProjects() + "]";
			}
}
