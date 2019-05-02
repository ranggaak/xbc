package xbc.dao;

import java.util.Collection;
import java.util.Date;

import xbc.model.Assignment;

public interface AssignmentDao {
	public Assignment findOne(Integer id);

	public Collection<Assignment> findAll();

	public Assignment update(Assignment assignment);

	public void delete(Assignment assignment);

	public void deleteById(Integer id);

	public void save(Assignment assignment);

	public Collection<Assignment> search(String title);
	
	public Collection<Assignment> searchByDate(Date startDate);
	
	public Collection<Assignment> findAllMenu();
}
