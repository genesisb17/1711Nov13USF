package com.ex.AngHibBank.AngHibBank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ex.beans.User;
import com.ex.repositories.UserRepository;



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
		user.setId(1);
		user.setFn("Bruce");
		user.setLn("Wayne");
		user.setUsername("iAm");
		user.setPw("BATMAN");
		user.setBalance(1000000000);
		repository.save(user);
	}
}
