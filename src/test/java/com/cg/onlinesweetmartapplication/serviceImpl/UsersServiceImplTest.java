package com.cg.onlinesweetmartapplication.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlinesweetmartapplication.entities.Product;
import com.cg.onlinesweetmartapplication.entities.User;
import com.cg.onlinesweetmartapplication.exceptions.InvalidProductDetailsException;
import com.cg.onlinesweetmartapplication.exceptions.InvalidUsersDetailsException;
import com.cg.onlinesweetmartapplication.exceptions.ProductNotFoundException;
import com.cg.onlinesweetmartapplication.model.UserDTO;
import com.cg.onlinesweetmartapplication.repository.iUserRepository;
import com.cg.onlinesweetmartapplication.service.iUserService;
import com.cg.onlinesweetmartapplication.utils.ProductUtils;
import com.cg.onlinesweetmartapplication.utils.UserUtils;


@RunWith(SpringRunner.class)
@SpringBootTest
class UsersServiceImplTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsersServiceImplTest.class);

	@MockBean
	private iUserRepository usersRepo;
	
	@Autowired
	private iUserService usersservice;
	
	@BeforeAll
	public static void init() {
		LOGGER.info("UsersServiceImpl Testing Initiated");
	}
	
	@Test
	public void addUsersTest()  {
		LOGGER.info("Testing addUsersTest()");
		
	User users = new User();
	users.setUsername("sudheer");
//	users.setEmail("sudheer00925@gmail.com");
//	users.setUserType("Admin ");
	System.out.println("UserId"+users.getUserId());
	Mockito.when(usersRepo.save(users)).thenReturn(users);
  UserDTO userDTO = UserUtils.convertToUserDto(users);
	assertEquals(users.getUsername(),"sudheer");
}
	
	@Test
	public void showUsersByIdTest() {
		LOGGER.info("Testing showUSersByIdTest()");
		User users = new User();
		users.setUsername("sudheer");
		//users.setUserId(123);
//		users.setEmail("sudheer00925@gmail.com");
//		users.setUserType("Admin ");	
		Mockito.when(usersRepo.save(users)).thenReturn(users);
		System.out.println("name"+users.getUserId()+ " "+ users.getUserId());
		//assertEquals(users.getUserId(), 1);
	
	}
	/*@Test
	public void showAllUsersTest() throws ProductNotFoundException
	{
			Users userOne = new Users();
			userOne.setUsername("sudheer");
			//userOne.setUserId(123);
			userOne.setEmail("sudheer00925@gmail.com");
			userOne.setUserType(" Admin");
			
			Users userTwo = new Users();
			userTwo.setUsername("suresh");
			//userTwo.setUserId(124);
			userTwo.setEmail("suresh00925@gmail.com");
			userTwo.setUserType("customer ");
			
		List<Users> usersList = new ArrayList<>();
		usersList.add(userOne);
		usersList.add(userTwo);
		Mockito.when(UsersService.showAllUsers()).thenReturn(UsersUtils.convertToUserDtoList(usersList));
		assertSame(usersList.size(),2);
	}*/

	@Test
	public void deleteProductTest() throws ProductNotFoundException, InvalidProductDetailsException
	{
		LOGGER.info("Testing deleteProductTest()");
		User users = new User();
		users.setUsername("sudheer");
		//users.setUserId(123);
//		users.setEmail("sudheer00925@gmail.com");
//		users.setUserType("Admin ");

		Mockito.when(usersRepo.save(users)).thenReturn(users);
		usersRepo.deleteById(users.getUserId());
		assertNotEquals(users, new User());
	}
	
	@Test
	public void updateProductTest() throws InvalidProductDetailsException, ProductNotFoundException
	{
		LOGGER.info("Testing updateProductTest()");
		User users = new User();
		users.setUsername("sudheer");
		//users.setUserId(123);
//		users.setEmail("sudheer00925@gmail.com");
//		users.setUserType("Admin ");
		
		usersRepo.save(users);
		Mockito.when(usersRepo.save(users)).thenReturn(users);
		
	}

	@AfterAll
	public static void end() {
		LOGGER.info("UsersServiceImpl Testing Terminated");
	}
}
