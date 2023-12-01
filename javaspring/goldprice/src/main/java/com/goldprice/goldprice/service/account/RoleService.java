package com.goldprice.goldprice.service.account;

import org.springframework.stereotype.Service;

import com.goldprice.goldprice.dto.account.RoleDto;

@Service
public interface RoleService {
	/**
	 * Get Role
	 * 
	 * @param roleDto RoleDto contains information about an role to get
	 * 
	 * @return roleDto Object contains information about an role in database
	 */
	Object getRole(RoleDto roleDto);

	/**
	 * Get All Role
	 * 
	 * @return roleDto Object contains all information about role in database
	 */
	Object getAllRole();

	/**
	 * Add Role
	 * 
	 * @param roleDto RoleDto contains information about an role to add
	 * 
	 * @return true/Exception Success/failed to add
	 */
	Object addRole(RoleDto roleDto);

	/**
	 * Delete Role
	 * 
	 * @param roleDto RoleDto contains information about an role to delete
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	Object deleteRole(RoleDto roleDto);

	/**
	 * Update Role
	 * 
	 * @param roleDto RoleDto contains information about an role to update
	 * 
	 * @return true/Exception Success/failed to update
	 */
	Object updateRole(RoleDto roleDto);
}
