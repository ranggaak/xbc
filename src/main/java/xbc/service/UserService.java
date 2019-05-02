package xbc.service;

import java.util.Collection;

import xbc.model.User;

public interface UserService {
	public User findOne(Integer id);

	public Collection<User> findAll();
	
	public void save(User user, Integer id);

	public User update(User user, Integer id);

	public void delete(User user);

	public void deleteById(Integer id);

	public Collection<User> search(String find);
	
	public User findByUsername(String name);
	
	public User deleteDisabled(Integer id, Integer sessionId);
}