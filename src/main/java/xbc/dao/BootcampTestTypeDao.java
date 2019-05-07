package xbc.dao;

import java.util.Collection;

import xbc.model.BootcampTestType;

public interface BootcampTestTypeDao {

	public Collection<BootcampTestType> findAll();

	public BootcampTestType findOne(Integer id);

	public void delete(BootcampTestType bootcampTestType);

	public void deleteById(Integer id);

	public BootcampTestType update(BootcampTestType bootcampTestType);

	public void save(BootcampTestType bootcampTestType);

	public Collection<BootcampTestType> search(String name);
	
	public Collection<BootcampTestType> searchDb(String name);
	public boolean checkDuplicate(String name, Integer idSekarang);
}
