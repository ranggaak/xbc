package xbc.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import xbc.model.TestType;

@Repository
public class TestTypeDaoImpl extends AbstractHibernateDao<TestType> implements TestTypeDao{
	
	public TestTypeDaoImpl () {
		setClazz(TestType.class);
	}
	
	public Collection<TestType> search(final String name){
		String hql = "FROM TestType t WHERE LOWER(t.name) LIKE LOWER(:name) "
				+ "AND t.isDelete='false'";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("name", "%" + name + "%");
		
		Collection<TestType> result = q.list();
		return result;
	}
	
	public Collection<TestType> searchDb(final String name){
		String hql = "FROM TestType t WHERE LOWER(t.name) LIKE LOWER(:name) "
				+ "AND t.isDelete='false'";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("name", name);
		
		Collection<TestType> result = q.list();
		return result;
	}
}
