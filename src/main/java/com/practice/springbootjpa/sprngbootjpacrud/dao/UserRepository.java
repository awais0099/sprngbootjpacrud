package com.practice.springbootjpa.sprngbootjpacrud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.practice.springbootjpa.sprngbootjpacrud.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	public List<User> findByName(String name);
	public List<User> findByNameAndCity(String name, String city);
	public List<User> findByNameStartingWith(String prefix);
	public List<User> findByNameEndWith(String suffix);
	public List<User> findByNameContaining(String words);
	public List<User> findByIdLessThan(int id);
	public List<User> findByIdGreaterThan(int id);
	
	@Query("select u from Usere u")
	public List<User> getAllUser();
	
	@Query("select u from Usere u where id = :")
	public List<User> getUserById(int id_user);
	
	@Query("select u from Usere u where u.name =:n")
	public List<User> getUserByName(@Param("n") String name);
}
