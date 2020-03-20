package me.BaHeTo0.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import me.BaHeTo0.models.Account;
import me.BaHeTo0.models.Transaction;
import me.BaHeTo0.repositories.AccountRepository;
import me.BaHeTo0.repositories.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private AccountRepository accountRepository;
	
	public List<Transaction> getAll() {
		return transactionRepository.findAll();
	}
	
	public ResponseEntity<Transaction> getById(Long id) throws NotFoundException {
		Transaction transaction = transactionRepository.findById(id)
				.orElseThrow(() -> new NotFoundException());
		return ResponseEntity.ok().body(transaction);
	}
	
	public Transaction pay(long fromId, long toId, BigDecimal amount) throws NotFoundException, RuntimeException{
		
		Account from = accountRepository.findById(fromId)
				.orElseThrow(() -> new NotFoundException());
		
		Account to = accountRepository.findById(toId)
				.orElseThrow(() -> new NotFoundException());
		
		if(from.getBalance().compareTo(amount) < 0) {
			throw new RuntimeException("Not enough money!");
		}
		
		from.setBalance(from.getBalance().subtract(amount));
		to.setBalance(to.getBalance().add(amount));
		
		Transaction transaction = new Transaction();
		transaction.setFrom(from);
		transaction.setTo(to);
		transaction.setAmount(amount);
		
		return transactionRepository.save(transaction);
	}
	
	
}
