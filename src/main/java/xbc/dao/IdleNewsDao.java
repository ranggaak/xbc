package xbc.dao;

import java.util.Collection;

import xbc.model.IdleNews;

public interface IdleNewsDao {
	public IdleNews findOne(Integer id);

	public Collection<IdleNews> findAll();

	public IdleNews update(IdleNews idleNews);

	public void delete(IdleNews idleNews);

	public void deleteById(Integer id);

	public void save(IdleNews idleNews);

	public Collection<IdleNews> search(String title);
}
