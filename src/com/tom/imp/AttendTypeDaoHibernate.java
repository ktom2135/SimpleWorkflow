package com.tom.imp;

import java.util.List;

import com.tom.dao.IAttendTypeDao;
import com.tom.model.AttendType;

public class AttendTypeDaoHibernate extends YeekuHibernateDaoSupport implements
		IAttendTypeDao {

	@Override
	public AttendType get(Integer id) {
		return getHibernateTemplate().get(AttendType.class, id);
	}

	@Override
	public Integer save(AttendType type) {
		return (Integer) getHibernateTemplate().save(type);
	}

	@Override
	public void update(AttendType type) {
		getHibernateTemplate().update(type);
	}

	@Override
	public void delete(AttendType type) {
		getHibernateTemplate().delete(type);
	}

	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public List<AttendType> findAll() {
		return (List<AttendType>) getHibernateTemplate()
				.find("from AttendType");
	}
}
