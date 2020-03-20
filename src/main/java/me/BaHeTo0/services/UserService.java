package me.BaHeTo0.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import me.BaHeTo0.models.User;
import me.BaHeTo0.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	public ResponseEntity<User> getById(Long id) throws NotFoundException {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException());
		return ResponseEntity.ok().body(user);
	}
	
	public User createNew(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
}
