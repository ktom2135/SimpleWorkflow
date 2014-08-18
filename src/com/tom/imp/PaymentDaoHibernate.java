package com.tom.imp;

import java.util.List;

import com.tom.dao.IPaymentDao;
import com.tom.model.Employee;
import com.tom.model.Payment;

public class PaymentDaoHibernate extends YeekuHibernateDaoSupport implements
		IPaymentDao {

	@Override
	public Payment get(Integer id) {
		return getHibernateTemplate().get(Payment.class, id);
	}

	@Override
	public Integer save(Payment payment) {
		return (Integer) getHibernateTemplate().save(payment);
	}

	@Override
	public void update(Payment payment) {
		getHibernateTemplate().update(payment);
	}

	@Override
	public void delete(Payment payment) {
		getHibernateTemplate().delete(payment);
	}

	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public List<Payment> findAll() {
		return (List<Payment>) getHibernateTemplate().find("from Payment");
	}

	@Override
	public List<Payment> findByEmp(Employee emp) {
		return (List<Payment>) getHibernateTemplate().find(
				"from Payment as p where p.Employee = ?", emp);
	}

	@Override
	public Payment findByMothAndEmp(String payMonth, Employee emp) {
		List<Payment> pays = (List<Payment>) getHibernateTemplate().find(
				"from payment as p where p.employee = ? and p.payMonth = ?",
				new Object[] { emp, payMonth });

		if (pays != null && pays.size() >= 1) {
			return pays.get(0);
		}
		return null;
	}

}
