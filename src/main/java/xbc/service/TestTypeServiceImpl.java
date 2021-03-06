package xbc.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xbc.dao.TestTypeDao;
import xbc.model.TestType;

@Service
@Transactional
public class TestTypeServiceImpl implements TestTypeService{
	
	@Autowired
	private TestTypeDao testTypeDao;
	
	@Autowired
	private AuditLogService auditLogService;
	
	@Override
	public TestType findOne(Integer id){
		return testTypeDao.findOne(id);
	}
	
	@Override
	public Collection<TestType> findAll() {
		return testTypeDao.findAll();
	}
	
	@Override
	public TestType update(TestType newTestType, Integer sessionId) {
		TestType testType = testTypeDao.findOne(newTestType.getId());
		
		String jsonBefore = auditLogService.objectToJsonString(testType);
		
		testType.setName(newTestType.getName());
		testType.setNotes(newTestType.getNotes());
		testType.setModifiedBy(sessionId);
		testType.setModifiedOn(new Date());
		
		TestType result = testTypeDao.update(testType);
		
		String jsonAfter = auditLogService.objectToJsonString(result);
		auditLogService.logUpdate(jsonBefore, jsonAfter, sessionId);
		
		return result;
	}
	
	@Override
	public void delete(TestType testType) {
		testTypeDao.delete(testType);
	}
	
	@Override
	public void deleteById(Integer id) {
		testTypeDao.deleteById(id);
	}
	
	@Override
	public boolean checkDuplicate(String name, Integer idSekarang) {
		return testTypeDao.checkDuplicate(name, idSekarang);
	}
	
	@Override
	public void save(TestType testType, Integer sessionId) {
		testType.setCreatedBy(sessionId);
		testType.setCreatedOn(new Date());
		testType.setIsDelete(false);
		testType.setTypeOfAnswer(0);
		testTypeDao.save(testType);
		
		auditLogService.logInsert(auditLogService.objectToJsonString(testType), sessionId);
	
	}
	
	@Override
	public Collection<TestType> search(String name) {
		return testTypeDao.search(name);
	}
	
	@Override
	public TestType softDeleteById(Integer id, Integer sessionId) {
		TestType testType = testTypeDao.findOne(id);
		testType.setDeletedBy(sessionId);
		testType.setDeletedOn(new Date());
		testType.setIsDelete(true);
		TestType result = testTypeDao.update(testType);
		
		auditLogService.logDelete(auditLogService.objectToJsonString(testType), sessionId);
		
		return result;
	}
	
}
