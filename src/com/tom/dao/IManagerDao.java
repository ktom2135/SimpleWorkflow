package com.tom.dao;

import java.util.List;

import com.tom.model.Manager;

public interface IManagerDao {
	Manager get(Integer id);

	String save(Manager manager);

	void update(Manager manager);

	void delete(Manager manager);

	void delete(Integer id);

	List<Manager> findAll();
	
	List<Manager> findByNameAndPass(Manager mgr);
	
	Manager findByName(String name);
}
