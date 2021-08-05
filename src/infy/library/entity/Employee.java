package infy.library.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Employee {
	
	@Id
	private String empId ;
	private String empName;
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

}
