package me.BaHeTo0.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.BaHeTo0.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
