package com.youngsters.model;

import java.util.List;

public class Request {
   
	private String deptId;
	private String deptName;
	private List<Student> student;

	public Request() {

	}

	public Request(String deptId, String deptName, List<Student> student) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.student = student;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", student=" + student + "]";
	}

}
