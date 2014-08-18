package com.tom.imp;

import java.util.List;

import com.tom.dao.IManagerDao;
import com.tom.model.Manager;

public class ManagerDaoHibernate extends YeekuHibernateDaoSupport implements
		IManagerDao {

	@Override
	public Manager get(Integer id) {
		return getHibernateTemplate().get(Manager.class, id);
	}

	@Override
	public String save(Manager manager) {
		return (String) getHibernateTemplate().save(manager);
	}

	@Override
	public void update(Manager manager) {
		getHibernateTemplate().update(manager);
	}

	@Override
	public void delete(Manager manager) {
		getHibernateTemplate().delete(manager);

	}

	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public List<Manager> findAll() {
		return (List<Manager>) getHibernateTemplate().find("from Manager");
	}

	@Override
	public List<Manager> findByNameAndPass(Manager mgr) {
		return (List<Manager>) getHibernateTemplate().find(
				"from Manager where name = ? and pass = ?",
				new String[] { mgr.getName(), mgr.getPass() });
	}

	@Override
	public Manager findByName(String name) {
		List<Manager> mgrs = getHibernateTemplate().find(
				"from Manager where name = ?", name);

		if (mgrs != null && mgrs.size() >= 1) {
			return mgrs.get(0);
		}
		return null;
	}

}
