package com.tom.dao;

import java.util.List;

import com.tom.model.Employee;
import com.tom.model.Payment;

public interface IPaymentDao {
	Payment get(Integer id);

	Integer save(Payment payment);

	void update(Payment payment);

	void delete(Payment payment);

	void delete(Integer id);

	List<Payment> findAll();

	List<Payment> findByEmp(Employee emp);

	Payment findByMothAndEmp(String payMonth, Employee emp);
}
