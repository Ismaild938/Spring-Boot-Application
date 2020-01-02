package com.student.service.model;

public class Student extends Address {
	
	private String firstName;
	private String lastName;
	private String clazz;
	private String fatherName;
	private String motherName;
	
	
	public Student() {
		
	}
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param clazz
	 * @param fatherName
	 * @param motherName
	 */
	public Student(String firstName, String lastName, String clazz, String fatherName, String motherName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.clazz = clazz;
		this.fatherName = fatherName;
		this.motherName = motherName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", clazz=" + clazz + ", fatherName="
				+ fatherName + ", motherName=" + motherName + ", getAddress_1()=" + getAddress_1() + ", getAddress_2()="
				+ getAddress_2() + ", getAddress_3()=" + getAddress_3() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	

}
