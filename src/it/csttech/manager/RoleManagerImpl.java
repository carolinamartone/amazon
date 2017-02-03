package it.csttech.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.csttech.dao.RoleDao;
import it.csttech.model.Role;

@Service
public class RoleManagerImpl implements RoleManager {
	@Autowired
	public RoleDao roleDao;

	@Override
	@Transactional(readOnly = true)
	public Role findById(Long id) {
		return roleDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Role> getAllRoles() {
		return roleDao.getAllRoles();
	}

}
