package me.BaHeTo0.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import me.BaHeTo0.models.Account;
import me.BaHeTo0.models.User;
import me.BaHeTo0.repositories.AccountRepository;
import me.BaHeTo0.repositories.UserRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private UserRepository userRepository;
	
	public List<Account> getAll() {
		return accountRepository.findAll();
	}
	
	public ResponseEntity<Account> getById(Long id) throws NotFoundException {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new NotFoundException());
		return ResponseEntity.ok().body(account);
	}
	
	public List<Account> getAllByOwnerId(Long id) throws NotFoundException{
		
		User owner = userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException());
		
		return accountRepository.findByOwner(owner);
	}
	
	public Account createNew(Long ownerId) throws NotFoundException {
		
		Account account = new Account();
		User owner = userRepository.findById(ownerId)
				.orElseThrow(() -> new NotFoundException());
		
		account.setOwner(owner);
		account.setBalance(BigDecimal.valueOf(0.0));
		
		return accountRepository.save(account);
	}

}
