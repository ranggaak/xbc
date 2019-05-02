package xbc.service;

import java.util.Collection;

import xbc.model.AuditLog;

public interface AuditLogService {

	public String objectToJsonString(Object object);

	public void logInsert(String jsonInsert, Integer sessionId);

	public void logUpdate(String jsonBefore, String jsonAfter, Integer sessionId);

	public void logDelete(String jsonDelete, Integer sessionId);
}