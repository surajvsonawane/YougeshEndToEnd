package com.scoopen.emp.business;

import java.util.List;

import com.scoopen.constant.AppLevelsConstants;
import com.scoopen.emp.service.EmpService;
import com.scoopen.emp.service.impl.EmpServiceImpl;
import com.scoopen.pojoes.EmpPojoes;

public class EmpController {

	@SuppressWarnings("finally")
	public static String ValidateCredential(String username,String password){
		
		String dbUserName=null;
		String dbUserPassword=null;
		
		username=username.trim();
		password=password.trim();
		try {
			EmpService empservice= new EmpServiceImpl();
			List<EmpPojoes> listOfEmp=empservice.getAllEmp();
			 
			
			for (EmpPojoes empPojoes : listOfEmp) {
				  dbUserName=empPojoes.getEmpUserName();
				  dbUserPassword=empPojoes.getEmpPassword();
				  System.out.println(dbUserName+"-------"+dbUserPassword);
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
		finally {
			if(dbUserName==null){
				dbUserName="";
			}
				if(dbUserPassword==null){
					dbUserPassword="";
				}
		
		
		if(username==null|!(username.equals(dbUserName))){
			return AppLevelsConstants.USERNAME_INVALID;
		}
		else if (password==null|!(password.equals(dbUserPassword))) {
			return AppLevelsConstants.PASSWORD_INVALID;
		} 
		else if (username.equals(dbUserName)&password.equals(dbUserPassword)) {
			return AppLevelsConstants.LOGIN_SUCESS;
		}
	
		return  AppLevelsConstants.INVALID_CREDENTIAL;
		
	}
		
}
}