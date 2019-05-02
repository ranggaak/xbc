package xbc.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import xbc.model.IdleNews;

@Repository
public class IdleNewsDaoImpl extends AbstractHibernateDao<IdleNews> implements IdleNewsDao{

	public IdleNewsDaoImpl () {
		setClazz(IdleNews.class);
	}
	
	public Collection<IdleNews> search(final String title){
		String hql = "FROM IdleNews t WHERE LOWER(t.title) LIKE LOWER(:title) "
				+ "AND t.isDelete='false'";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("title", "%" + title + "%");
		
		Collection<IdleNews> result = q.list();
		return result;
	}
}
