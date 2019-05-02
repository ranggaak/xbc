package xbc.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import xbc.model.IdleMonitoring;

@Repository
public class IdleMonitoringDaoImpl extends AbstractHibernateDao<IdleMonitoring> implements IdleMonitoringDao {

	public IdleMonitoringDaoImpl () {
		setClazz(IdleMonitoring.class);
	}
	
	public Collection<IdleMonitoring> findAll() {
		String hql = "FROM IdleMonitoring B "
				   + "WHERE B.isDelete = 'false'";
		Query q = getCurrentSession().createQuery(hql);
		Collection<IdleMonitoring> result = q.list();
		return result;
	}
}
