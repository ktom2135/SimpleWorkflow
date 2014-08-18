package com.tom.imp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.tom.dao.IAttendDao;
import com.tom.model.Attend;
import com.tom.model.AttendType;
import com.tom.model.Employee;

public class AttendDaoHibernate extends YeekuHibernateDaoSupport implements
		IAttendDao {

	@Override
	public Attend get(Integer id) {
		return getHibernateTemplate().get(Attend.class, id);
	}

	@Override
	public Integer save(Attend attend) {
		return (Integer) getHibernateTemplate().save(attend);
	}

	@Override
	public void update(Attend attend) {
		getHibernateTemplate().update(attend);
	}

	@Override
	public void delete(Attend attend) {
		getHibernateTemplate().delete(attend);
	}

	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public List<Attend> findAll() {
		return (List<Attend>) getHibernateTemplate().find("from Attend");
	}

	@Override
	public List<Attend> findByEmpAndDutyDay(Employee emp, String dutyDay) {
		return (List<Attend>) getHibernateTemplate().find(
				"from Attend as a where a.employee = ? and a.dutyDay = ?",
				new Object[] { emp, dutyDay });
	}

	@Override
	public Attend findByEmpAndDutyDayAndCome(Employee emp, String dutyDay,
			Boolean isCome) {
		List<Attend> attends = findByEmpAndDutyDay(emp, dutyDay);
		if (attends != null && attends.size() > 1) {
			for (Attend attend : attends) {
				if (attend.getIsCome() == isCome) {
					return attend;
				}
			}
		}

		return null;
	}

	@Override
	public List<Attend> findByEmpUnAttend(Employee emp, AttendType type) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		String end = sdf.format(c.getTime());
		c.add(Calendar.DAY_OF_MONTH, -3);
		String start = sdf.format(c.getTime());
		Object[] args = { emp, type, start, end };
		return (List<Attend>) getHibernateTemplate()
				.find("from Attend as a where a.employee = ? and a.type != ? and a.dutyDay between ? and ?",
						args);
	}

}
