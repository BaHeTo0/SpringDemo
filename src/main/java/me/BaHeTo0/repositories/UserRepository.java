package me.BaHeTo0.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.BaHeTo0.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
