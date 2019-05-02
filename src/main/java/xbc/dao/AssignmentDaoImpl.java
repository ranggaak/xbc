package xbc.dao;

import java.util.Collection;
import java.util.Date;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import xbc.model.Assignment;

@Repository
public class AssignmentDaoImpl extends AbstractHibernateDao<Assignment> implements AssignmentDao{

	public AssignmentDaoImpl () {
		setClazz(Assignment.class);
	}
	
	public Collection<Assignment> search(final String title){
		String hql = "FROM Assignment t WHERE LOWER(t.title) LIKE LOWER(:title) "
				+ "AND t.isDelete='false'";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("title", "%" + title + "%");
		
		Collection<Assignment> result = q.list();
		return result;
	}
	
	public Collection<Assignment> searchByDate(Date startDate){
		String hql = "FROM Assignment t WHERE t.startDate = :startDate "
				+ "AND t.isDelete='false'";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("startDate", startDate);
		
		Collection<Assignment> result = q.list();
		return result;
	}
	
	public Collection<Assignment> findAllMenu(){
		String hql = "FROM Assignment t WHERE t.isDelete='false'";
		Query q = getCurrentSession().createQuery(hql);
		
		Collection<Assignment> result = q.list();
		return result;
	}
}
