package com.tom.imp;

import java.util.List;

import com.tom.dao.ICheckBackDao;
import com.tom.model.CheckBack;

public class CheckBackDaoHibernate extends YeekuHibernateDaoSupport implements
		ICheckBackDao {

	@Override
	public CheckBack get(Integer id) {
		return getHibernateTemplate().get(CheckBack.class, id);
	}

	@Override
	public Integer save(CheckBack checkBack) {
		return (Integer) getHibernateTemplate().save(checkBack);
	}

	@Override
	public void update(CheckBack checkBack) {
		getHibernateTemplate().update(checkBack);
	}

	@Override
	public void delete(CheckBack checkBack) {
		getHibernateTemplate().delete(checkBack);
	}

	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public List<CheckBack> findAll() {
		return (List<CheckBack>) getHibernateTemplate().find("from CheckBack");
	}
}
