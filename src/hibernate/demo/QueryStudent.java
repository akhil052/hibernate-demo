package hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Student;

public class QueryStudent {
	
	public static void main(String args[]) {
		
		//create the Sessionfactory
		
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create the Session object
		
		Session sessionobject = factory.getCurrentSession();
		
		try {
		
			//start a transaction			
			sessionobject.beginTransaction();
			
           List<Student> stulist = sessionobject.createQuery("from Student").getResultList();
       
			displayObjects(stulist);
		
			stulist = sessionobject.createQuery("from Student s where "
					+ " s.firstName='Ishita'  or  s.firstName='kuchbhi'").getResultList();	
			
			System.out.println("\n\nQuery based on last name");
			displayObjects(stulist);
			//commit transaction			
			sessionobject.getTransaction().commit();
			
			
		
		
	}finally {
		factory.close();
	}

}

	private static void displayObjects(List<Student> stulist) {
		for(Student stuobjects : stulist ) {
			
			System.out.println(stuobjects);
			
		}
	}
	
}
