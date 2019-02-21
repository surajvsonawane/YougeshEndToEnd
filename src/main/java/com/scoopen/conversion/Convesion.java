package com.scoopen.conversion;

import java.util.ArrayList;
import java.util.List;

import com.scoopen.entites.EmpEntites;
import com.scoopen.pojoes.EmpPojoes;

public class Convesion {
	// public static final String mapEntityToPojoes = null;

	public static Object mapEntityToPojoes;

	public static EmpPojoes mapEntityToPojoes(EmpEntites empEntity) {
		if (empEntity == null) {
			return null;
		}

		EmpPojoes pojo = new EmpPojoes();
		pojo.setEmpId(empEntity.getEmpId());
		pojo.setActive(empEntity.getisActive());
		pojo.setEmpPassword(empEntity.getEmpPassword());
		pojo.setEmpUserName(empEntity.getEmpUserName());
		return pojo;

	}

	public static EmpEntites mapPojoToEntity(EmpPojoes empPojoes) {
		if (empPojoes == null) {
			return null;
		}

		EmpEntites entity = new EmpEntites();
		entity.setEmpId(empPojoes.getEmpId());
		entity.setisActive(empPojoes.isActive());
		entity.setEmpPassword(empPojoes.getEmpPassword());
		entity.setEmpUserName(empPojoes.getEmpUserName());

		return entity;

	}

	public static List<EmpPojoes> mapListofEntitesToListofPojoes(List<EmpEntites> listofEntites) {
		List<EmpPojoes> listofEntityPojo = null;

		if (listofEntites == null || listofEntites.isEmpty()) {
			return null;
		}

		listofEntityPojo = new ArrayList<EmpPojoes>();
		for (EmpEntites empPojoes : listofEntites) {
			listofEntityPojo.add(mapEntityToPojoes(empPojoes));

		}

		return listofEntityPojo;

	}

}
