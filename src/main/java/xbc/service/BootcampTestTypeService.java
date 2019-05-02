package xbc.service;

import java.util.Collection;

import xbc.model.BootcampTestType;



public interface BootcampTestTypeService {

	public BootcampTestType findOne(Integer id);
	public Collection<BootcampTestType> findAll();
	public BootcampTestType update(BootcampTestType bootcampTestType, Integer sessionId);
	public void delete(BootcampTestType bootcampTestType);
	public void deleteById(Integer id);
	public Integer save(BootcampTestType bootcampTestType, Integer sessionId);
	public Collection<BootcampTestType> search(String name);
	public BootcampTestType softDeleteById(Integer id, Integer sessionId);
}
