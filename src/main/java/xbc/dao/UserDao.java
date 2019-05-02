package xbc.dao;

import java.util.Collection;

import xbc.model.User;

public interface UserDao {
	public User findOne(Integer id);

	public Collection<User> findAll();

	public User update(User user);

	public void delete(User user);

	public void deleteById(Integer id);

	public void save(User user);
	
	public User findByUsername(String username);
	
	public Collection<User> search(String find);
}