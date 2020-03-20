package me.BaHeTo0.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.BaHeTo0.models.User;
import me.BaHeTo0.models.dto.UserDTO;
import me.BaHeTo0.services.UserService;

@RestController
@RequestMapping( "/users" )
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping( "/all" )
	public List<User> getAllUsers() {
		return userService.getAll();
	}
	
	@GetMapping( "/{id}" )
	public ResponseEntity<User> getUserById(@PathVariable( value = "id" ) Long id) throws NotFoundException {
		return userService.getById(id);
	}
	
	@PostMapping( "/new" )
	public User createNewUser(@Valid @RequestBody UserDTO userDto) {
		
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		
		return userService.createNew(user);
	}

}
