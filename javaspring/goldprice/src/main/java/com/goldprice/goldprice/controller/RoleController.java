package com.goldprice.goldprice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goldprice.goldprice.dto.DataResponse;
import com.goldprice.goldprice.dto.RoleDto;
import com.goldprice.goldprice.service.RoleService;

@RestController
@CrossOrigin
public class RoleController {
	@Autowired
	private RoleService roleService;

	@PostMapping("/role")
	public DataResponse accountLogin(@RequestBody RoleDto roleDto) {
		if (roleDto.getServiceCall().equals("add")) {
			//Case: Add Role By roleDto property 
			return new DataResponse(roleService.addRole(roleDto));
		} else if (roleDto.getServiceCall().equals("get")) {
			//Case: Get One  Role By roleDto property 
			return new DataResponse(roleService.getRole(roleDto));
		} else if (roleDto.getServiceCall().equals("getAll")) {
			//Case: Get All  Role
			return new DataResponse(roleService.getAllRole());
		} else if (roleDto.getServiceCall().equals("update")) {
			//Case: Update  Role By roleDto property 
			return new DataResponse(roleService.updateRole(roleDto));
		} else if (roleDto.getServiceCall().equals("delete")) {
			//Case: Delete  Role By roleDto property 
			return new DataResponse(roleService.deleteRole(roleDto));
		}
		return new DataResponse("500", "Method Not Found");

	}

}
