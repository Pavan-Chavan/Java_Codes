package com.EmployeeSalaryGenarator;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.controller.MainController;
import com.vo.EmployeeVO;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc=new Scanner(System.in);
		System.out.println("enter customer name::");
		String name=sc.next();
		System.out.println("enter customer Salary::");
		String salary=sc.next();
		
		EmployeeVO vo = new EmployeeVO();
		vo.setEmpName(name);vo.setEmpSalary(salary);
		
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		 XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		 reader.loadBeanDefinitions("com/cfgs/applicationContext.xml"); 
		 
		 MainController controller = factory.getBean("controller",MainController.class);
		 try {
			 String result=controller.processEmployee(vo);
			 System.out.println(result);
		 }
		 catch(Exception e) {
			 //e.printStackTrace();
			 System.out.println("Internal Problem --Try Again:::"+e.getMessage());
		 }
    }
}
