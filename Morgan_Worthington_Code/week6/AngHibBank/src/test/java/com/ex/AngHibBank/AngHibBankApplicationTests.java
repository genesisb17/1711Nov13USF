package com.ex.AngHibBank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ex.AngHibBank.model.User;
import com.ex.AngHibBank.repositories.UserRepository;




@RunWith(SpringRunner.class)
@SpringBootTest
public class AngHibBankApplicationTests {

	@Autowired
	UserRepository repository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreate() {
		User user=new User();
		user.setFn("Bruce");
		user.setLn("Wayne");
		user.setUsername("iAmNot");
		user.setPw("BATMAN");
		user.setBalance(9);
		repository.save(user);
	}
	
}
