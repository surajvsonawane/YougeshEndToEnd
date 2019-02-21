package com.scoopen.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Emp_Assinment")
public class EmpEntites {
	@Id
	@Column(name = "Emp_ID")
	private int empId;
	@Column(name = "Emp_Name")
	private String empUserName;
	@Column(name = "Emp_Password")
	private String empPassword;
	@Column(name = "Emp_isActive")
	private boolean isActive;

	public EmpEntites() {
		super();

	}

	public EmpEntites(int empId, String empUserName, String empPassword, boolean isActive) {
		super();
		this.empId = empId;
		this.empUserName = empUserName;
		this.empPassword = empPassword;
		this.isActive = isActive;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpUserName() {
		return empUserName;
	}

	public void setEmpUserName(String empUserName) {
		this.empUserName = empUserName;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public boolean getisActive() {
		return isActive;
	}

	public void setisActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "EmpEntites [empId=" + empId + ", empUserName=" + empUserName + ", empPassword=" + empPassword
				+ ", isActive=" + isActive + "]";
	}

}
