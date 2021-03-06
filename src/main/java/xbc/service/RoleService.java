package xbc.service;

import java.util.Collection;

import xbc.model.Role;

public interface RoleService {
	public Role findOne(Integer id);

	public Collection<Role> findAll();

	public void save(Role role);
	
	public Role update(Role role);

	public void delete(Role role);

	public void deleteById(Integer id);

	public Collection<Role> search(String name);
	
	public Role deleteDisabled(int id);
}