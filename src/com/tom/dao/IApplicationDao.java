package com.tom.dao;

import java.util.List;
import com.tom.model.Application;
import com.tom.model.Employee;

public interface IApplicationDao {
	Application get(Integer id);

	Integer save(Application application);

	void update(Application application);

	void delete(Application application);

	void delete(Integer id);

	List<Application> findAll();

	List<Application> findByEmp(Employee emp);
}
