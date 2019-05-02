package xbc.service;

import java.util.Collection;

import xbc.model.IdleNews;

public interface IdleNewsService {

	public IdleNews findOne(Integer id);
	public Collection<IdleNews> findAll();
	public IdleNews update(IdleNews idleNews, Integer sessionId);
	public void delete(IdleNews idleNews);
	public void deleteById(Integer id);
	public void save(IdleNews idleNews, Integer sessionId);
	public Collection<IdleNews> search(String title);
	public IdleNews softDeleteById(Integer id, Integer sessionId);
	public IdleNews publishById(Integer id, Integer sessionId);
}
