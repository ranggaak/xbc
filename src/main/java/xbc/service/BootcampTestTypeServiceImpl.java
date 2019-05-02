package xbc.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xbc.dao.BootcampTestTypeDao;
import xbc.model.BootcampTestType;
import xbc.model.TestType;

@Service
@Transactional
public class BootcampTestTypeServiceImpl implements BootcampTestTypeService{

	@Autowired
	private BootcampTestTypeDao bootcampTestTypeDao;
	
	@Autowired
	private AuditLogService auditLogService;
	
	@Override
	public BootcampTestType findOne(Integer id){
		return bootcampTestTypeDao.findOne(id);
	}
	
	@Override
	public Collection<BootcampTestType> findAll() {
		return bootcampTestTypeDao.findAll(); 
	}

	@Override
	public BootcampTestType update(BootcampTestType newBootcampTestType, Integer sessionId) {
		BootcampTestType bootcampTestType = bootcampTestTypeDao.findOne(newBootcampTestType.getId());
		
		String jsonBefore = auditLogService.objectToJsonString(bootcampTestType);
		
		bootcampTestType.setName(newBootcampTestType.getName());
		bootcampTestType.setNotes(newBootcampTestType.getNotes());
		bootcampTestType.setModifiedBy(sessionId);
		bootcampTestType.setModifiedOn(new Date());
		BootcampTestType result = bootcampTestTypeDao.update(bootcampTestType);
		
		String jsonAfter = auditLogService.objectToJsonString(bootcampTestType);
		auditLogService.logUpdate(jsonBefore, jsonAfter, sessionId);
		
		return result;
	}

	@Override
	public void delete(BootcampTestType bootcampTestType) {
		bootcampTestTypeDao.delete(bootcampTestType);
	}

	@Override
	public void deleteById(Integer id) {
		bootcampTestTypeDao.deleteById(id);
	}

	@Override
	public Integer save(BootcampTestType bootcampTestType, Integer sessionId) {
		bootcampTestType.setCreatedBy(sessionId);
		bootcampTestType.setCreatedOn(new Date());
		bootcampTestType.setIsDelete(false);
		
		Integer countName = this.checkName(bootcampTestType.getName());
		if (countName > 0) {
			bootcampTestType.setName(bootcampTestType.getName());
			return 1;
		} else {
			bootcampTestTypeDao.save(bootcampTestType);
			auditLogService.logInsert(auditLogService.objectToJsonString(bootcampTestType), sessionId);
			return 2;
		}
	}

	// ------------- tambahan
	
	@Override
	public Collection<BootcampTestType> search(String name) {
		return bootcampTestTypeDao.search(name);
	}
	
	@Override
	public BootcampTestType softDeleteById(Integer id, Integer sessionId) {
		BootcampTestType bootcampTestType = bootcampTestTypeDao.findOne(id);
		bootcampTestType.setDeletedBy(sessionId);
		bootcampTestType.setDeletedOn(new Date());
		bootcampTestType.setIsDelete(true);
		
		auditLogService.logDelete(auditLogService.objectToJsonString(bootcampTestType), sessionId);
		
		return bootcampTestTypeDao.update(bootcampTestType);
	}

	public Integer checkName(String name) {
		Collection<BootcampTestType> list = bootcampTestTypeDao.searchDb(name);
		Integer countName = 0;
		if (list == null) {
			countName = 0;
		} else {
			countName = list.size();
		}
		return countName;
	}
	

}
