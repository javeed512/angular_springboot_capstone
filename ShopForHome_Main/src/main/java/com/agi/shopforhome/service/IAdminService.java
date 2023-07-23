package com.agi.shopforhome.service;

import java.util.List;

import com.agi.shopforhome.dto.AdminDTO;
import com.agi.shopforhome.entity.Admin;

/**
 * @author Soumyadeep
 * Modified Date: 27/08/2022
 * Description: Admin service interface
 *
 */
public interface IAdminService {
	
	public String addAdmin(AdminDTO adminDto);
	
	public List<Admin> getAllAdmin();

}
