package xbc.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import xbc.dao.AuditLogDao;
import xbc.model.AuditLog;
import xbc.web.IgnoranceInstropector;

@Service
@Transactional
public class AuditLogServiceImpl implements AuditLogService {

	@Autowired
	private AuditLogDao auditLogDao;

	@Override
	public String objectToJsonString(Object object) {
		String jsonString = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
			objectMapper.setAnnotationIntrospector(new IgnoranceInstropector());
			jsonString = objectMapper.writeValueAsString(object);
//			AuditLog lama
//			jsonString = new ObjectMapper().enable(SerializationFeature.WRAP_ROOT_VALUE).writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString;

	}

	@Override
	public void logInsert(String jsonInsert, Integer sessionId) {
		AuditLog auditLog = new AuditLog();
		auditLog.setJsonInsert(jsonInsert);
		auditLog.setType("INSERT");
		auditLog.setCreatedBy(sessionId);
		auditLog.setCreatedOn(new Date());
		auditLogDao.save(auditLog);
	}

	@Override
	public void logUpdate(String jsonBefore, String jsonAfter, Integer sessionId) {
		AuditLog auditLog = new AuditLog();
		auditLog.setJsonBefore(jsonBefore);
		auditLog.setJsonAfter(jsonAfter);
		auditLog.setType("MODIFY");
		auditLog.setCreatedBy(sessionId);
		auditLog.setCreatedOn(new Date());
		auditLogDao.save(auditLog);
	}

	@Override
	public void logDelete(String jsonDelete, Integer sessionId) {
		AuditLog auditLog = new AuditLog();
		auditLog.setJsonDelete(jsonDelete);
		auditLog.setType("DELETE");
		auditLog.setCreatedBy(sessionId);
		auditLog.setCreatedOn(new Date());
		auditLogDao.save(auditLog);
	}

}