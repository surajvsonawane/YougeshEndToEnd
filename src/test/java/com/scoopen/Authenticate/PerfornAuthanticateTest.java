package com.scoopen.Authenticate;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.scoopen.emp.business.EmpController;
import com.scoopen.read.Read;

public class PerfornAuthanticateTest {

	@DataProvider
	public Object[][] getTestData() throws IOException{
		return Read.readdata();
	}
	
	
	
	@Test(dataProvider="getTestData")
	public void PerformLogic(String uname,String password,String msg){
		System.out.println(uname+"-->"+password+"-->"+msg);
		  String actualMsg=EmpController.ValidateCredential(uname,password);
		Assert.assertEquals(actualMsg,msg);
		  
	}
}
