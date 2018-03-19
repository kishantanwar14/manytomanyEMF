package domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import domain.Project;

public class Main {
	
	public static void main(String[] args) {
		 
	       addNewMasterAndDetail();
	
	}
	
	private static void addNewMasterAndDetail()
	{		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SameNameMainNPersistence");
		EntityManager em = emf.createEntityManager();
		System.out.println("Starting ManytoMany");
		em.getTransaction().begin();

		Employee e1 = new Employee();
		e1.setName("Prasad Kharkar");
 
		Employee e2 = new Employee();
		e2.setName("Taware");
 
		Project p1 = new Project();
		p1.setName("Ecommerce");
 
		Project p2 = new Project();
		p2.setName("Tracking");
 
		
		List<Employee> emp = new ArrayList<Employee>();
		emp.add(e1);
		emp.add(e2);
		List<Project> projects = new ArrayList<Project>();
		projects.add(p1);
		projects.add(p2);

		p1.setEmployees(emp);
		p2.setEmployees(emp);
 
		e1.setProjects(projects);
		e2.setProjects(projects);
 
		em.persist(e1);
		em.persist(e2);
		em.persist(p1);
		em.persist(p2);

		
		
		
		
/*		EntityManager em = emf.createEntityManager();
		System.out.println("Starting ManytoMany");

		
		em.getTransaction().begin();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

 
		Employee prasad = new Employee();
		prasad.setName("prasad kharkar");
 
		Employee harish = new Employee();
		harish.setName("Harish taware");
 
		Project ceg = new Project();
		ceg.setName("CEG");
 
		Project gtt = new Project();
		gtt.setName("GTT");
 
		List<Project> projects = new ArrayList<Project>();
		projects.add(ceg);
		projects.add(gtt);
 
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(prasad);
		employees.add(harish);
 
		ceg.setEmployees(employees);
		gtt.setEmployees(employees);
 
		prasad.setProjects(projects);
		harish.setProjects(projects);
 
		em.persist(prasad);
		em.persist(harish);
		em.persist(ceg);
		em.persist(gtt);*/	
		
		em.getTransaction().commit();
		//transaction.commit();
		em.close();
		emf.close();
		
	}
}
