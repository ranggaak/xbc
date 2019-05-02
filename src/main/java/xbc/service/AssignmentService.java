package xbc.service;

import java.util.Collection;
import java.util.Date;

import xbc.model.Assignment;

public interface AssignmentService {

	public Assignment findOne(Integer id);
	public Collection<Assignment> findAll();
	public Collection<Assignment> findAllMenu();
	public Assignment update(Assignment assignment, Integer sessionId);
	public void delete(Assignment assignment);
	public void deleteById(Integer id);
	public void save(Assignment assignment, Integer sessionId);
	public Collection<Assignment> search(String title);
	public Collection<Assignment> searchByDate(Date startDate);
	public Assignment softDeleteById(Integer id, Integer sessionId);
	public Assignment holdById(Integer id, Integer sessionId);
	public Assignment doneById(Assignment assignment, Integer sessionId);
}
