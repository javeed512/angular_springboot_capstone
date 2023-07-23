
package com.agi.shopforhome.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agi.shopforhome.dto.AdminDTO;
import com.agi.shopforhome.entity.Admin;
import com.agi.shopforhome.repository.AdminRepository;
import com.agi.shopforhome.service.IAdminService;

/**
 * @author hakeem
 * Modified Date: 24-08-2022
 * Description:Admin service class
 */
@Service
public class AdminServiceImp implements IAdminService {
	
	
	@Autowired
	private AdminRepository repo;

	/**
	 * @author hakeem
	 * Modified Date: 24-08-2022
	 * Description: to add admin
	 * Return Type: String
	 * Params:AdminDTO object
	 */	

	@Override
	public String addAdmin(AdminDTO adminDto) {
		// TODO Auto-generated method stub
		Admin admin=new Admin();
		admin.setEmail(adminDto.getEmail());
		admin.setPassword(adminDto.getPassword());
			repo.save(admin);
			return "New Admin data saved";
		
	}
	
	/**
	 * @author hakeem
	 * Modified Date: 24-08-2022
	 * Description: to add admin
	 * Return Type: List of Admin object
	 * Params: NA
	 */	

	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return repo.findAll();
		
	}

}
