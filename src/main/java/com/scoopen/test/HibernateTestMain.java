package com.scoopen.test;

import java.util.HashMap;
import java.util.List;

import com.scoopen.constant.AppLevelsConstants;
import com.scoopen.constant.AppLevelsConstants.EmpFields;
import com.scoopen.emp.service.EmpService;
import com.scoopen.emp.service.impl.EmpServiceImpl;
import com.scoopen.entites.EmpEntites;
import com.scoopen.pojoes.EmpPojoes;

public class HibernateTestMain {
public static void main(String[] args) {
	EmpPojoes employee=new EmpPojoes(10,"Suraj","Surya", true);
/*	EmpPojoes employee2=new EmpPojoes(11,"Suraj","Surya", true);
	EmpPojoes employee3=new EmpPojoes(12,"Suraj","Surya", true);
	EmpPojoes employee4=new EmpPojoes(13,"Suraj","Surya", true);
	EmpPojoes employee5=new EmpPojoes(14,"Suraj","Surya", true);
	EmpPojoes employee6=new EmpPojoes(15,"Suraj","Surya", true);*/
	EmpService empService=new EmpServiceImpl();
	boolean isAdded=empService.addEmp(employee);
	/*boolean isAdded2=empService.addEmp(employee2);
	boolean isAdded3=empService.addEmp(employee3);
	boolean isAdded4=empService.addEmp(employee4);
	boolean isAdded5=empService.addEmp(employee5);
	boolean isAdded6=empService.addEmp(employee6);*/
	System.out.println("**********SAVE*********");
	System.out.println("Is Emp1 added="+isAdded);
	
	System.out.println("************GET***********");
	
	EmpPojoes getfronDb=new EmpServiceImpl().getEmp(10);
	System.out.println("data from database="+getfronDb);
	
	
	System.out.println("************UPDATE***************");
	EmpPojoes employee2=new EmpPojoes(11,"Pragti","manya", true);
	boolean isUpdate=empService.updateEmp(employee2);
	boolean update=empService.updateEmp(employee2);
	System.out.println("data updated="+update);
	
	System.out.println("************GET***********");
	
	EmpPojoes getfronDb1=new EmpServiceImpl().getEmp(10);
	System.out.println("data from database="+getfronDb1);
	System.out.println("--------------------");
	 
	EmpPojoes getfronDb2=new EmpServiceImpl().getEmp(11);
	System.out.println("data from database="+getfronDb2);
	System.out.println("*************GET-ALL***************");
	 List<EmpPojoes> listofEmp =empService.getAllEmp();
	 System.out.println(listofEmp);
	//System.out.println("************DELETE************");
	// boolean delfromDb=new EmpServiceImpl().deleteEmp(10);
	 //System.out.println("data deleted="+delfromDb);
	System.out.println("***************SEARCH*****UNDER CONSTRUCTION*******");
	//HashMap<AppLevelsConstants.EmpFields,String > map=new HashMap<>();
	//map.put(EmpFields.EMOID,"10");
	//map.put(EmpFields.ISACTIVE,"Yes");
	//List<EmpPojoes> searchEmp=empService.searchEmp(map);
	 //System.out.println(searchEmp);
	String username = "Suraj";
	String password = "Surya";
	
	for (EmpPojoes empPojoes : listofEmp) {
		System.out.println(empPojoes.getEmpPassword());
		System.out.println(empPojoes.getEmpUserName());
	}
	
}//main

}
