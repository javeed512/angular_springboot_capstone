package com.agi.shopforhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agi.shopforhome.dto.UserDTO;
import com.agi.shopforhome.entity.User;
import com.agi.shopforhome.service.IUserService;

/**
 * @author Soumyadeep Maji
 * Modified Date: 24/08/2022
 * Description: User Rest Controller
 *
 */

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200/")
public class UserController {
	
	@Autowired
	private IUserService service;
	
	@PostMapping("/add-user")
	public String AddUser(@RequestBody UserDTO dto) {
		return service.addUser(dto);
		
	}
	
	@GetMapping("/getAll")
	public List<User> getAllUser(){
		return service.getAllUser();
	}
	
	@PutMapping("/updateUser")
	public String updateUser(@RequestBody UserDTO dto) {
		return service.updateUser(dto);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable long id) {
		return service.deleteUser(id);
	}
	
	@GetMapping("/get-user/{id}")
	public User getUserById(@PathVariable long id) {
		return service.getUserById(id);
	}

}
