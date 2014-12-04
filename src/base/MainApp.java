package base;

import java.io.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	
	public static void main(String[]args) throws NumberFormatException, IOException{

		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Employee emp = (Employee) context.getBean("Employee");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("enter employeeId and employeeName");
		Integer id = Integer.parseInt(br.readLine());
		String empName = br.readLine();
		
		emp.setEmpId(id);
		emp.setEmpName(empName);
		
		System.out.println("output");
		
		emp.getEmpId();
		emp.getEmpName();
		
	}
}
