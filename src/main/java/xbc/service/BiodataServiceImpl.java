package xbc.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xbc.dao.BiodataDao;
import xbc.model.Biodata;

@Service
@Transactional
public class BiodataServiceImpl implements BiodataService {

	@Autowired
	private BiodataDao biodataDao;

	@Autowired
	private AuditLogService auditLogService;

	@Override
	public Biodata findOne(Integer id) {
		return biodataDao.findOne(id);
	}

	@Override
	public Collection<Biodata> findAll() {
		return biodataDao.findAll();
	}

	@Override
	public Biodata update(Biodata newBiodata, Integer sessionId) {
		Biodata biodata = biodataDao.findOne(newBiodata.getId());
		String jsonBefore = auditLogService.objectToJsonString(biodata);
		
		biodata.setModifiedBy(1);
		biodata.setModifiedOn(new Date());
		biodata.setName(newBiodata.getName());
		biodata.setLastEducation(newBiodata.getLastEducation());
		biodata.setEducationalLevel(newBiodata.getEducationalLevel());
		biodata.setGraduationYear(newBiodata.getGraduationYear());
		biodata.setMajors(newBiodata.getMajors());
		biodata.setGpa(newBiodata.getGpa());
		biodata.setGender(newBiodata.getGender());
		biodata.setBootcampTestType(newBiodata.getBootcampTestType());
		biodata.setIq(newBiodata.getIq());
		biodata.setDu(newBiodata.getDu());
		biodata.setNestedLogic(newBiodata.getNestedLogic());
		biodata.setJoinTable(newBiodata.getJoinTable());
		biodata.setArithmetic(newBiodata.getArithmetic());
		biodata.setTro(newBiodata.getTro());
		biodata.setInterviewer(newBiodata.getInterviewer());
		biodata.setNotes(newBiodata.getNotes());
		Biodata result = biodataDao.update(biodata);
		
		String jsonAfter = auditLogService.objectToJsonString(biodata);
		auditLogService.logUpdate(jsonBefore, jsonAfter, sessionId);
		return result;
	}

	@Override
	public void delete(Biodata biodata) {
		biodataDao.delete(biodata);
	}

	@Override
	public void deleteById(Integer id) {
		biodataDao.deleteById(id);
	}

	@Override
	public void save(Biodata biodata, Integer sessionId) {
		biodata.setCreateBy(1);
		biodata.setCreatedOn(new Date());
		biodata.setDelete(false);
		biodataDao.save(biodata);
		
		auditLogService.logInsert(auditLogService.objectToJsonString(biodata), sessionId);
	}

	@Override
	public Collection<Biodata> search(String nameOrMajors) {
		return biodataDao.search(nameOrMajors);
	}

	@Override
	public Biodata softDeleteById(Integer id, Integer sessionId) {
		Biodata biodata = biodataDao.findOne(id);
		biodata.setDeleteBy(1);
		biodata.setDeleteOn(new Date());
		biodata.setDelete(true);
		Biodata result = biodataDao.update(biodata);
		
		auditLogService.logDelete(auditLogService.objectToJsonString(biodata), sessionId);
		return result;
	}
}
