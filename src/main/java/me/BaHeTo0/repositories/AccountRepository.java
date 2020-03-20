package me.BaHeTo0.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import me.BaHeTo0.models.Account;
import me.BaHeTo0.models.User;

public interface AccountRepository extends JpaRepository<Account, Long>{

	public List<Account> findByOwner(User owner);
	
}
