package com.tom.model;

import java.io.Serializable;
import java.util.*;

/**
 * Description: <br/>
 * Copyright (C), 2001-2010, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class Manager extends Employee implements Serializable {
	private static final long serialVersionUID = 48L;

	private String dept;

	private Set<Employee> employees = new HashSet<Employee>();

	private Set<CheckBack> checks = new HashSet<CheckBack>();

	public Manager() {
	}

	public Manager(String dept, Set<Employee> employees, Set<CheckBack> checks) {
		this.dept = dept;
		this.employees = employees;
		this.checks = checks;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDept() {
		return this.dept;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setChecks(Set<CheckBack> checks) {
		this.checks = checks;
	}

	public Set<CheckBack> getChecks() {
		return this.checks;
	}
}