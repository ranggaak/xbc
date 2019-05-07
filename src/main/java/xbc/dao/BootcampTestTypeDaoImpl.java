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
	
	@Override
	public boolean checkDuplicate(String name, Integer idSekarang) {
		String hql  = "SELECT COUNT(*) "
					+ "FROM BootcampTestType c "
					+ "WHERE LOWER(c.name) = LOWER(:name) "
					+ "AND c.isDelete = 'false' "
					+ "AND c.id != :idSekarang";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("name", name);
		if(idSekarang == null) {
			idSekarang = 0;
		}
		query.setParameter("idSekarang", idSekarang);
	
		Long count = (Long) query.list().get(0);
		if (count == 0) {
			return false;	
		} else {
			return true;
		}
	}
}
