package com.practice.springbootjpa.sprngbootjpacrud;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.practice.springbootjpa.sprngbootjpacrud.dao.UserRepository;
import com.practice.springbootjpa.sprngbootjpacrud.entities.User;

@SpringBootApplication
public class SprngbootjpacrudApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SprngbootjpacrudApplication.class, args);
		
		System.out.println("** working start ** ");
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		// add/insert user in database
		User user = new User();
		user.setName("temp name 1");
		user.setCity("temp city");
		user.setStatus("temp status");
		User addedUser = userRepository.save(user);
		System.out.println(addedUser);
		
		// update user
//		System.out.println("** GET user by id **");
//		Optional<User> Useroptional = userRepository.findById(2);
//		User userbyid = Useroptional.get();
//		userbyid.setName("updated updated");
//		User update_result = userRepository.save(userbyid);
//		System.out.println(update_result);
		
		// get all users from database
		System.out.println("** print all user **");
		Iterable<User> userIterable = userRepository.findAll();
		Iterator<User> userIterator = userIterable.iterator();
		
		while (userIterator.hasNext()) {
			User user1 = userIterator.next();
			System.out.println(user1);
			
		}
		
		// delete all records of users from database
		System.out.println("** delete all records of users from database **");
		userRepository.deleteAll();
	}

}
