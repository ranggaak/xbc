package xbc.service;

import java.util.Collection;

import xbc.model.TestType;

public interface TestTypeService {
	
	public TestType findOne(Integer id);
	public Collection<TestType> findAll();
	public TestType update(TestType testType, Integer sessionId);
	public void delete(TestType testType);
	public void deleteById(Integer id);
	public Integer save(TestType testType, Integer sessionId);
	public Collection<TestType> search(String name);
	public TestType softDeleteById(Integer id, Integer sessionId);

}
