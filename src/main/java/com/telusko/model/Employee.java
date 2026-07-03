package com.telusko.model;

public class Employee {
	
	
	private Integer emp_id;
	
	private String emp_name;
	
	private String emp_dept;
	
	private String location;
	
	public Employee() {
		
	}

	public Employee(Integer emp_id, String emp_name, String emp_dept, String location) {
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_dept = emp_dept;
		this.location = location;
	}

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_dept() {
		return emp_dept;
	}

	public void setEmp_dept(String emp_dept) {
		this.emp_dept = emp_dept;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_dept=" + emp_dept + ", location="
				+ location + "]";
	}
	
	
	
	

}
