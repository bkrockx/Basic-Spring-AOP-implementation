package base;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;

@Aspect
public class Log {

	//@Pointcut("execution(*base..(..))")
	
	@Pointcut("execution(* base.*.get*(..))")
	private void selectAll(){}
	
	@Pointcut("execution(* base.*.setEmpId(..))")
	private void selectSetId(){}
	
	@Pointcut("execution(* base.*.setEmpName(..))")
	private void selectSetName(){}
	
	@Before("selectSetId()")
	public void beforeSelectSetId(){
		System.out.println("EmployeeId successfully set");
	}
	
	@Before("selectSetName()")
	public void beforeSelectSetName(){
		System.out.println("EmployeeName successfully set");
	}
	
	@Before("selectAll()")
	public void beforeSelect(){
		System.out.println("starting transaction");
	}
	
	@After("selectAll()")
	public void afterSelect(){
		System.out.println("transaction committed");
	}
	
	@AfterReturning(pointcut="selectAll()", returning="ret")
	public void afterReturningSelect(Object ret){
		System.out.println("returning"+":"+ret.toString());
	}
	
}
