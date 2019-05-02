package xbc.dao;

import java.util.Collection;

import xbc.model.TestType;

public interface TestTypeDao {
	public TestType findOne(Integer id);

	public Collection<TestType> findAll();

	public TestType update(TestType testType);

	public void delete(TestType testType);

	public void deleteById(Integer id);

	public void save(TestType testType);

	public Collection<TestType> search(String name);
	
	public Collection<TestType> searchDb(String name);
	
	public boolean checkDuplicate(String name, Integer idSekarang);
}
