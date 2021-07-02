package com.cg.onlinesweetmartapplication.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlinesweetmartapplication.entities.User;
@RunWith(SpringRunner.class)
@DataJpaTest
class UsersRepositoryTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UsersRepositoryTest.class);

		@Autowired
		private iUserRepository usersRepo;
		
		@Autowired
		private TestEntityManager testEntityManager;
		
		@BeforeAll
		public static void init() {
			LOGGER.info("UsersRepository Testing Initiated");
		}

		@Test
		public void getUsersByIdTest()
		{
			LOGGER.info("Testing getUserByIdTest()");
			 User users = new User();
			users.setUsername("sudheer");
//			users.setEmail("sudheer00925@gmail.com");
//			users.setUserType("Admin ");
			User saveInDb = testEntityManager.persist(users);
		   System.out.println(users.getUsername()+ " "+ saveInDb.getUserId());
			User getFromDb = usersRepo.findById(saveInDb.getUserId()).get();
			assertEquals(getFromDb, saveInDb);
		}
		@Test
		public void getAllUsersTest()
		{
			LOGGER.info("Testing getAllUsersTest()");
			User userOne = new User();
			userOne.setUsername("sudheer");
//			userOne.setEmail("sudheer00925@gmail.com");
//			userOne.setUserType(" Admin");
			
			User userTwo = new User();
			userTwo.setUsername("suresh");
//			userTwo.setEmail("suresh00925@gmail.com");
//			userTwo.setUserType("customer ");
			
			testEntityManager.persist(userOne);
			testEntityManager.persist(userTwo);
			
			List<User> usersList = usersRepo.findAll();
			assertEquals(2, usersList.size());
		}
		@Test
		public void deleteUsersTest()
		{
			LOGGER.info("Testing deleteUsersTest()");
			User UserOne = new User();
			UserOne.setUsername("suresh");
//			UserOne.setEmail("suresh00925@gmail.com");
			User UserTwo = new User();
			UserTwo.setUsername("sudheer");
//			UserTwo.setEmail("sudheer00925@gmail.com");
			
			testEntityManager.persist(UserOne);
			testEntityManager.persist(UserTwo);
			
			testEntityManager.remove(UserOne);
			
			List<User> users = usersRepo.findAll();
			assertEquals(1,users.size());
		}
		
		  @Test
		    public void testUpdateUsers(){

				LOGGER.info("Testing testUpdateUsers()");
		        User users = new User();
		        users.setUsername("sudheer");
//				users.setEmail("sudheer00925@gmail.com");
//				users.setUserType(" ");
				
				User saveToDb = testEntityManager.persist(users);
		  User getFromDb = usersRepo.findById(saveToDb.getUserId()).get();
			System.out.println("UPdate test"+ getFromDb.getUsername()+ " "+ getFromDb.getUserId());
			System.out.println("Afetr update"+getFromDb.getUsername()+" "+ getFromDb.getUserId());
			
		
		
		
		  } 
		
			@AfterAll
			public static void end() {
				LOGGER.info("UsersRepository Testing Terminated");
			}
	}



