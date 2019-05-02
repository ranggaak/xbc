package xbc.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import xbc.model.Biodata;

@Repository
public class BiodataDaoImpl extends AbstractHibernateDao<Biodata> implements BiodataDao  {
	
	public BiodataDaoImpl () {
		setClazz(Biodata.class);
	}
	
	public Collection<Biodata> search(final String nameOrMajors) {
		String hql = "FROM Biodata B "
				   + "WHERE (LOWER(B.name) LIKE LOWER(:nameOrMajors) "
				   + "OR LOWER(B.majors) LIKE LOWER(:nameOrMajors)) "
				   + "AND B.isDelete = 'false'";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("nameOrMajors", "%" + nameOrMajors + "%");
		Collection<Biodata> result = q.list();
		return result;
	}
	
	public Collection<Biodata> findAll() {
		String hql = "FROM Biodata B "
				   + "WHERE B.isDelete = 'false' "
				   + "AND B.id IN ( "
				   + "SELECT M.biodataId FROM IdleMonitoring M "
				   + "WHERE (CURRENT_DATE BETWEEN M.idleDate AND M.placementDate "
				   + "OR M.idleDate <= CURRENT_DATE AND M.placementDate IS NULL))";
		Query q = getCurrentSession().createQuery(hql);
		Collection<Biodata> result = q.list();
		return result;
	}
	
	// query idle
	// SELECT * FROM t_biodata JOIN t_monitoring 
	// ON t_biodata."id" = t_monitoring.biodata_id 
	// WHERE (CURRENT_DATE BETWEEN t_monitoring.idle_date AND t_monitoring.placement_date 
	// OR t_monitoring.idle_date <= CURRENT_DATE AND t_monitoring.placement_date is NULL) AND B.isDelete = 'false'
	
	// query idle 2
	// SELECT * FROM t_biodata tb WHERE tb.is_delete = 'false' AND tb.id IN (
	// SELECT biodata_id FROM t_monitoring
	// WHERE (CURRENT_DATE BETWEEN t_monitoring.idle_date AND t_monitoring.placement_date 
	// OR t_monitoring.idle_date <= CURRENT_DATE AND t_monitoring.placement_date is NULL))
	
}
