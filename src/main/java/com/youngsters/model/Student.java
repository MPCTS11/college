package com.youngsters.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private int studentId;
	private String name;
	private String dob;
	private String address;
	private String deptId;

	public Student() {

	}

	public Student(int studentId, String name, String dob, String address,String deptId) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.deptId = deptId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getdeptId() {
		return deptId;
	}

	public void setdeptId(int deptId) {
		this.studentId = deptId;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", dob=" + dob + ", address=" + address + "]";
	}

}
