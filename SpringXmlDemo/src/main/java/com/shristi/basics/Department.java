package com.shristi.basics;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class Department {

	String deptName;

	public String getDeptName() {
		return deptName;
	}
	@Value("Admin")
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [deptName=" + deptName + "]";
	}
	
}
