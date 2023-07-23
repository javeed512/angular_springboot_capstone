package com.agi.shopforhome.serviceImp;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.agi.shopforhome.dto.UserDTO;
import com.agi.shopforhome.serviceImp.UserServiceImp;

@SpringBootTest
class UserServiceImpTest {
	@SuppressWarnings("unused")
	@Autowired
	private UserServiceImp service;
	
	@Test
	void testAddUser() {

		UserDTO userdto = new UserDTO(0, "User1","user@gmail.com","User123",52365423);
		String addedUser= service.addUser(userdto);
		assertNotNull(addedUser);

	}

	@Test
	void testGetAllUser() {
		List list = service.getAllUser();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	void testUpdateUser() {
//		User user = new User();
//		user.setId(1);
//		user.setEmail("user1@gmail.com");
//		user.setName("user1");
//		user.setPhone(536256325);
//		user.setPassword("User@123");
//		//when(repo.save(user)).thenReturn(user);
//		UserDTO userdto = new UserDTO(1, "User1","user@gmail.com","User123",52365423);
//		String response = service.updateUser(userdto);
//		//assertTrue(response.isEmpty());
//		assertEquals("User Updated Successfully",response);
	}

	@Test
	void testDeleteUser() {
		fail("Not yet implemented");
	}

	@Test
	void testGetUserById() {
		fail("Not yet implemented");
	}

}
