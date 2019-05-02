package xbc.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import xbc.model.BootcampTestType;

@Repository
public class BootcampTestTypeDaoImpl extends AbstractHibernateDao<BootcampTestType> implements BootcampTestTypeDao {

	public BootcampTestTypeDaoImpl() {
		setClazz(BootcampTestType.class);
	}
	
	public Collection<BootcampTestType> search(String name) {
		String hql = "FROM BootcampTestType t WHERE LOWER(t.name) LIKE LOWER(:name) "
					+ "AND t.isDelete='false'";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("name", "%" + name + "%");
		
		Collection<BootcampTestType> result = q.list();
		return result;
	}
	
	public Collection<BootcampTestType> searchDb(String name) {
		String hql = "FROM BootcampTestType t WHERE LOWER(t.name) LIKE LOWER(:name) "
					+ "AND t.isDelete='false'";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("name", name);
		
		Collection<BootcampTestType> result = q.list();
		return result;
	}
}
