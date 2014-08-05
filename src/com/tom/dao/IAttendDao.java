package com.tom.dao;

import java.util.List;

import com.tom.model.Attend;
import com.tom.model.AttendType;
import com.tom.model.Employee;

public interface IAttendDao {
	Attend get(Integer id);

	Integer save(Attend attend);

	void update(Attend attend);

	void delete(Attend attedn);

	void delete(Integer id);

	List<Attend> findAll();

	List<Attend> findByEmpAndDutyDay(Employee emp, String dutyDay);

	Attend findByEmpAndDutyDayAndCome(Employee emp, String dutyDay,
			Boolean isCome);

	List<Attend> findByEmpUnAttend(Employee emp, AttendType type);
}
