package com.scoopen.pojoes;

public class EmpPojoes {

	private int empId;
	private String empUserName;
	private String empPassword;
	private boolean isActive;

	public EmpPojoes() {
		super();

	}

	public EmpPojoes(int empId, String empUserName, String empPassword, boolean isActive) {
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "EmpPojoes [empId=" + empId + ", empUserName=" + empUserName + ", empPassword=" + empPassword
				+ ", isActive=" + isActive + "]";
	}

}
