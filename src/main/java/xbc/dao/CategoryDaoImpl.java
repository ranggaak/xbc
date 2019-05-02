package xbc.dao;


import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import xbc.model.Category;

@Repository
public class CategoryDaoImpl extends AbstractHibernateDao<Category> implements CategoryDao {

	public CategoryDaoImpl () {
		setClazz(Category.class);
	}

	// ------------- tambahan
	
	@Override
	public Collection<Category> search(String codeOrName) {
		String hql  = "FROM Category C "
					+ "WHERE (LOWER(C.name) LIKE LOWER(:codeOrName) "
					+ "OR LOWER(C.code) LIKE LOWER(:codeOrName)) "
					+ "AND C.isDelete = 'false'";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("codeOrName", "%" + codeOrName + "%");

		Collection<Category> result = query.list();
		return result;
	}
	
	@Override
	public Collection<Category> findAll() {
		String hql  = "FROM Category C "
					+ "WHERE C.isDelete = 'false'";
		Query query = getCurrentSession().createQuery(hql);

		Collection<Category> result = query.list();
		return result;
	}
	
	@Override
	public boolean checkDuplicate(String name) {
		String hql  = "SELECT COUNT(*) "
					+ "FROM Category c "
					+ "WHERE LOWER(c.name) = LOWER(:name) "
					+ "AND c.isDelete = 'false' ";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("name", name);
	
		Long count = (Long) query.list().get(0);
		if (count == 0) {
			return false;	
		} else {
			return true;
		}
	}
}