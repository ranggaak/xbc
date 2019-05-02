package xbc.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xbc.dao.AssignmentDao;
import xbc.model.Assignment;

@Service
@Transactional
public class AssignmentServiceImpl implements AssignmentService {

	@Autowired
	private AssignmentDao assignmentDao;

	@Autowired
	private AuditLogService auditLogService;

	@Override
	public Assignment findOne(Integer id) {
		return assignmentDao.findOne(id);
	}

	@Override
	public Collection<Assignment> findAll() {
		return assignmentDao.findAll();
	}

	@Override
	public Collection<Assignment> findAllMenu() {
		return assignmentDao.findAllMenu();
	}

	@Override
	public Assignment update(Assignment newAssignment, Integer sessionId) {
		Assignment assignment = assignmentDao.findOne(newAssignment.getId());

		String jsonBefore = auditLogService.objectToJsonString(assignment);
		
		assignment.setBiodataId(newAssignment.getBiodataId());
		assignment.setTitle(newAssignment.getTitle());
		assignment.setStartDate(newAssignment.getStartDate());
		assignment.setEndDate(newAssignment.getEndDate());
		assignment.setDescription(newAssignment.getDescription());
		assignment.setModifiedBy(sessionId);
		assignment.setModifiedOn(new Date());
		Assignment result = assignmentDao.update(assignment);
		
		String jsonAfter = auditLogService.objectToJsonString(assignment);
		auditLogService.logUpdate(jsonBefore, jsonAfter, sessionId);

		return result;
	}

	@Override
	public void delete(Assignment assignment) {
		assignmentDao.delete(assignment);
	}

	@Override
	public void deleteById(Integer id) {
		assignmentDao.deleteById(id);
	}

	
	
	@Override
	public Collection<Assignment> searchByDate(Date startDate) {
		return assignmentDao.searchByDate(startDate);
	}

	@Override
	public void save(Assignment assignment, Integer sessionId) {
		assignment.setCreatedBy(sessionId);
		assignment.setCreatedOn(new Date());
		assignment.setIsDelete(false);
		assignment.setIsHold(false);
		assignment.setIsDone(false);
		assignmentDao.save(assignment);
		assignmentDao.update(assignment);

		auditLogService.logInsert(auditLogService.objectToJsonString(assignment), sessionId);
	}

	@Override
	public Collection<Assignment> search(String title) {
		return assignmentDao.search(title);
	}

	@Override
	public Assignment softDeleteById(Integer id, Integer sessionId) {
		Assignment assignment = assignmentDao.findOne(id);
		assignment.setDeletedBy(sessionId);
		assignment.setDeletedOn(new Date());
		assignment.setIsDelete(true);
		Assignment result = assignmentDao.update(assignment);
		
		auditLogService.logDelete(auditLogService.objectToJsonString(assignment), sessionId);

		return result;
	}

	@Override
	public Assignment holdById(Integer id, Integer sessionId) {
		Assignment assignment = assignmentDao.findOne(id);
		
		String jsonBefore = auditLogService.objectToJsonString(assignment);
		
		assignment.setIsHold(true);
		Assignment result = assignmentDao.update(assignment);
		
		String jsonAfter = auditLogService.objectToJsonString(assignment);
		auditLogService.logUpdate(jsonBefore, jsonAfter, sessionId);

		return result;
	}
	
	@Override
	public Assignment doneById(Assignment newAssignment, Integer sessionId) {
		Assignment assignment = assignmentDao.findOne(newAssignment.getId());
		
		String jsonBefore = auditLogService.objectToJsonString(assignment);
		
		assignment.setRealizationDate(newAssignment.getRealizationDate());
		assignment.setNotes(newAssignment.getNotes());
		assignment.setIsDone(true);
		Assignment result = assignmentDao.update(assignment);
		
		String jsonAfter = auditLogService.objectToJsonString(assignment);
		auditLogService.logUpdate(jsonBefore, jsonAfter, sessionId);

		return result;
	}
}
