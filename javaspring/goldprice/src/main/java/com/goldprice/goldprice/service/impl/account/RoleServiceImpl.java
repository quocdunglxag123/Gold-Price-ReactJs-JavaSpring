package com.goldprice.goldprice.service.impl.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldprice.goldprice.dto.account.RoleDto;
import com.goldprice.goldprice.entity.account.RoleEntity;
import com.goldprice.goldprice.exception.AccountException;
import com.goldprice.goldprice.mapstruct.GenerateMapper;
import com.goldprice.goldprice.repository.account.RoleRepository;
import com.goldprice.goldprice.service.account.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private GenerateMapper roleMapper;

	/**
	 * Get Role
	 * 
	 * @param roleDto RoleDto contains information about an role to get
	 * 
	 * @return roleDto Object contains information about an role in database
	 */
	@Override
	public Object getRole(RoleDto roleDto) {
		return roleMapper.roleEntityToRoleDto(roleRepository.findOneById(roleDto.getId()));
	}

	/**
	 * Get All Role
	 * 
	 * @return roleDto Object contains all information about role in database
	 */
	@Override
	public Object getAllRole() {
		return roleMapper.listRoleEntityToListRoleDto(roleRepository.findAll());
	}

	/**
	 * Add Role
	 * 
	 * @param roleDto RoleDto contains information about an role to add
	 * 
	 * @return true/Exception Success/failed to add
	 */
	@Override
	public Object addRole(RoleDto roleDto) {
		RoleEntity roleEntity = roleMapper.roleDtoToRoleEntity(roleDto);
		roleRepository.save(roleEntity);
		return true;
	}

	/**
	 * Update Role
	 * 
	 * @param roleDto RoleDto contains information about an role to update
	 * 
	 * @return true/Exception Success/failed to update
	 */
	@Override
	public Object updateRole(RoleDto roleDto) {
		RoleEntity roleEntityUpdate = roleRepository.findOneById(roleDto.getId());
		if (roleEntityUpdate != null) {
			// Case: Role is in database
			roleEntityUpdate.setName(roleDto.getName());
			roleRepository.save(roleEntityUpdate);
			return true;
		} else {
			throw new AccountException("Role Not Found!");
		}
	}

	/**
	 * Delete Role
	 * 
	 * @param roleDto RoleDto contains information about an role to delete
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	@Override
	public Object deleteRole(RoleDto roleDto) {
		roleRepository.deleteById(roleDto.getId());
		return true;
	}

}
