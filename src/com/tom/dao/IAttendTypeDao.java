package com.tom.dao;

import java.util.List;

import com.tom.model.AttendType;

public interface IAttendTypeDao {
	AttendType get(Integer id);

	Integer save(AttendType type);

	void update(AttendType type);

	void delete(AttendType type);

	void delete(Integer id);

	List<AttendType> findAll();
}
