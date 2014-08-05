package com.tom.dao;

import java.util.List;

import com.tom.model.Employee;
import com.tom.model.Manager;

public interface IEmployeeDao {
	Employee get(Integer id);

	Integer save(Employee emp);

	void Update(Employee emp);

	void delete(Employee emp);
	
	void delete(Integer id);
	
	List<Employee> findAll();
	
	List<Employee> findByNameAndPass(Employee emp);
	
	Employee findByName(String name);
	
	List<Employee> findByMgr(Manager mgr);
	
}
