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

import me.BaHeTo0.models.Account;
import me.BaHeTo0.models.Transaction;
import me.BaHeTo0.models.dto.TransactionDTO;
import me.BaHeTo0.services.AccountService;
import me.BaHeTo0.services.TransactionService;

@RestController
@RequestMapping( "/accounts" )
public class AccountController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private TransactionService transactionService;
	
	
	@GetMapping( "/all" )
	public List<Account> getAllAccounts() {
		return accountService.getAll();
	}
	
	@GetMapping( "/{id}" )
	public ResponseEntity<Account> getAccountById(@PathVariable( value = "id" ) Long id) throws NotFoundException {
		return accountService.getById(id);
	}
	@GetMapping( "/all/{id}" )
	public List<Account> getAllUserAccounts(@PathVariable( value = "id") Long id) throws NotFoundException {
		return accountService.getAllByOwnerId(id);
	}
	
	@PostMapping( "/new/{id}" )
	public Account createNewAccount(@PathVariable( value = "id" ) Long id) throws NotFoundException {
		return accountService.createNew(id);
	}
	
	@PostMapping( "/pay" )
	public Transaction pay(@Valid @RequestBody TransactionDTO transactionDto) throws NotFoundException {
		return transactionService.pay(transactionDto.getFromId(), transactionDto.getToId(), transactionDto.getAmount());
	}
}
