package xbc.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xbc.dao.IdleNewsDao;
import xbc.model.IdleNews;

@Service
@Transactional
public class IdleNewsServiceImpl implements IdleNewsService {

	@Autowired
	private IdleNewsDao idleNewsDao;

	@Autowired
	private AuditLogService auditLogService;

	@Override
	public IdleNews findOne(Integer id) {
		return idleNewsDao.findOne(id);
	}

	@Override
	public Collection<IdleNews> findAll() {
		return idleNewsDao.findAll();
	}

	@Override
	public IdleNews update(IdleNews newIdleNews, Integer sessionId) {
		IdleNews idleNews = idleNewsDao.findOne(newIdleNews.getId());

		String jsonBefore = auditLogService.objectToJsonString(idleNews);

		idleNews.setTitle(newIdleNews.getTitle());
		idleNews.setCategoryId(newIdleNews.getCategoryId());
		idleNews.setContent(newIdleNews.getContent());
		idleNews.setModifiedBy(sessionId);
		idleNews.setModifiedOn(new Date());
		IdleNews result = idleNewsDao.update(idleNews);
		
		String jsonAfter = auditLogService.objectToJsonString(idleNews);
		auditLogService.logUpdate(jsonBefore, jsonAfter, sessionId);

		return result;
	}

	@Override
	public void delete(IdleNews idleNews) {
		idleNewsDao.delete(idleNews);
	}

	@Override
	public void deleteById(Integer id) {
		idleNewsDao.deleteById(id);
	}

	@Override
	public void save(IdleNews idleNews, Integer sessionId) {
		idleNews.setCreatedBy(sessionId);
		idleNews.setCreatedOn(new Date());
		idleNews.setIsDelete(false);
		idleNews.setIsPublish(false);
		idleNewsDao.save(idleNews);
		idleNewsDao.update(idleNews);

		auditLogService.logInsert(auditLogService.objectToJsonString(idleNews), sessionId);
	}

	@Override
	public Collection<IdleNews> search(String title) {
		return idleNewsDao.search(title);
	}

	@Override
	public IdleNews softDeleteById(Integer id, Integer sessionId) {
		IdleNews idleNews = idleNewsDao.findOne(id);
		idleNews.setDeletedBy(sessionId);
		idleNews.setDeletedOn(new Date());
		idleNews.setIsDelete(true);
		IdleNews result = idleNewsDao.update(idleNews);
		
		auditLogService.logDelete(auditLogService.objectToJsonString(idleNews), sessionId);

		return result;
	}

	@Override
	public IdleNews publishById(Integer id, Integer sessionId) {
		IdleNews idleNews = idleNewsDao.findOne(id);
		
		String jsonBefore = auditLogService.objectToJsonString(idleNews);
		
		idleNews.setIsPublish(true);
		IdleNews result = idleNewsDao.update(idleNews);
		
		String jsonAfter = auditLogService.objectToJsonString(idleNews);
		auditLogService.logUpdate(jsonBefore, jsonAfter, sessionId);

		return result;
	}
}
