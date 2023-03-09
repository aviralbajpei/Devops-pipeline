package com.nagarro.userManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.nagarro.userManagement.entity.User;
import com.nagarro.userManagement.repository.UserRepository;
import com.nagarro.userManagement.service.UserService;


@SpringBootTest
class UserManagementApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private UserService userService;
	
	
	@MockBean
	private UserRepository repository;
	
	@Test
	public void getUserTest() {
		when(repository.findAll()).thenReturn(Stream.of
				(new User( 100l, "abc","xyz","abc@gmail"),new User( 200l, "pqt","pqr","dxc@gmail")).collect(Collectors.toList()));  
				assertEquals(2, userService.getAllUser().size());
	}
	
	@Test
	public void createuser() {
		User user = new User( 1001l, "aviral1","bajpei","aviral@gmail");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, userService.createUser(user));
		
	}
	
	@Test
	public void deleteUser() {
		doNothing().when(repository).deleteById(1000l);
		userService.deleteUser(1000l);
		verify(this.repository).deleteById(1000l);		
	}
	
	

}
