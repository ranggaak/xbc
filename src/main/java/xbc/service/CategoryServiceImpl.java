package xbc.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xbc.dao.CategoryDao;
import xbc.model.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private AuditLogService auditLogService;
	
	@Override
	public Category findOne(Integer id) {
		return categoryDao.findOne(id);
	}

	@Override
	public Collection<Category> findAll() {
		return categoryDao.findAll(); 
	}

	@Override
	public Category update(Category newCategory, Integer sessionId) {
		Category category = categoryDao.findOne(newCategory.getId());
		
		String jsonBefore = auditLogService.objectToJsonString(category);
		
		category.setName(newCategory.getName());
		category.setDescription(newCategory.getDescription());
		category.setModifiedBy(555);
		category.setModifiedOn(new Date());
		Category result = categoryDao.update(category);
		
		String jsonAfter = auditLogService.objectToJsonString(category);
		auditLogService.logUpdate(jsonBefore, jsonAfter, sessionId);
		
		return result;
	}

	@Override
	public void delete(Category category) {
		categoryDao.delete(category);
	}

	@Override
	public void deleteById(Integer id) {
		categoryDao.deleteById(id);
	}

	@Override
	public void save(Category category, Integer sessionId) {
		category.setCreatedBy(555);
		category.setCreatedOn(new Date());
		category.setIsDelete(false);
		categoryDao.save(category);
		category.setCode(generateCode(category.getId()));
		categoryDao.update(category);
		
		auditLogService.logInsert(auditLogService.objectToJsonString(category), sessionId);
	}

	// ------------- tambahan
	
	@Override
	public Collection<Category> search(String codeOrName) {
		return categoryDao.search(codeOrName);
	}
	
	@Override
	public Category softDeleteById(Integer id, Integer sessionId) {
		Category category = categoryDao.findOne(id);
		category.setDeletedBy(555);
		category.setDeletedOn(new Date());
		category.setIsDelete(true);
		Category result = categoryDao.update(category);
		
		auditLogService.logDelete(auditLogService.objectToJsonString(category), sessionId);
		
		return result;
	}

	@Override
	public String generateCode(Integer id) {
		String code = "C";
		String angka = String.format("%04d", id);
		
		return code + angka;
	}

}