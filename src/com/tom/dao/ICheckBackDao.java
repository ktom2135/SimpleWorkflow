package com.tom.dao;

import java.util.List;

import com.tom.model.CheckBack;

public interface ICheckBackDao {
	CheckBack get(Integer id);

	Integer save(CheckBack checkBack);

	void update(CheckBack checkBack);

	void delete(CheckBack checkBack);

	void delete(Integer id);

	List<CheckBack> findAll();
}
