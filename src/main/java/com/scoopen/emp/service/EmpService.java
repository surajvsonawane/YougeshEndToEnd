package com.scoopen.emp.service;

import java.util.HashMap;
import java.util.List;

import com.scoopen.constant.AppLevelsConstants;
import com.scoopen.pojoes.EmpPojoes;

public interface EmpService {

	public boolean addEmp(EmpPojoes emp);
	public boolean deleteEmp(int empID);
	public EmpPojoes getEmp(int empID);
	public boolean updateEmp(EmpPojoes emp);
	public List<EmpPojoes> getAllEmp();
	public List<EmpPojoes> searchEmp(HashMap<AppLevelsConstants.EmpFields,String> hmap);
}
