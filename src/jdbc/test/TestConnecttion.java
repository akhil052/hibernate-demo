package jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;



public class TestConnecttion {

	public static void main(String[] args) {
		System.out.println("hsgyyxhgxyqwgx");
          
		String url="jdbc:mysql://localhost/student_tracker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
          
          System.out.println("11111111111111111");
          //"jdbc:mysql://localhost:3306/AKHIL?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		
		//jdbc:mysql://localhost:3306/student_tracker?useSSL=false&amp;serverTimezone=UTC
		
		//This works-> jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
		
        //jdbc:mysql://localhost/test?useUnicode=true&amp;useJDBCCompliantTimezoneShift=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC   
           
           
           String user="AKHIL";
		String password="priyanka";
		
		
		
	try {
		Connection cnn = DriverManager.getConnection(url, user, password);
		
		System.out.println("Bandobast badiya hai");
	
		
	}
	
	catch(Exception e){
		
		e.printStackTrace();
	}

	}

}
