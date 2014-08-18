package com.tom.imp;

import java.util.List;

import com.tom.dao.IEmployeeDao;
import com.tom.model.Employee;
import com.tom.model.Manager;

public class EmployeeDaoHibernate extends YeekuHibernateDaoSupport implements
		IEmployeeDao {

	@Override
	public Employee get(Integer id) {
		return getHibernateTemplate().get(Employee.class, id);
	}

	@Override
	public Integer save(Employee emp) {
		return (Integer) getHibernateTemplate().save(emp);
	}

	@Override
	public void Update(Employee emp) {
		getHibernateTemplate().update(emp);
	}

	@Override
	public void delete(Employee emp) {
		getHibernateTemplate().delete(emp);
	}

	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public List<Employee> findAll() {
		return (List<Employee>) getHibernateTemplate().find(("from Employee"));
	}

	@Override
	public List<Employee> findByNameAndPass(Employee emp) {
		Object[] args = { emp.getName(), emp.getPass() };
		return (List<Employee>) getHibernateTemplate().find(
				"from Employee as a where a.name=? and a.pass = ?", args);
	}

	@Override
	public Employee findByName(String name) {
		List<Employee> emps = (List<Employee>) getHibernateTemplate().find(
				"from Employee where name = ?", name);

		if (emps != null && emps.size() >= 1) {
			return emps.get(0);
		}
		return null;

	}

	@Override
	public List<Employee> findByMgr(Manager mgr) {

		return (List<Employee>) getHibernateTemplate().find(
				"from Employee as e where e.manager = ?", mgr);
	}

}
