package me.BaHeTo0.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name = "users")
public class User {
	

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private long id;
	
	@Column( nullable = false )
	private String username;
	
	@Column( nullable = false )
	private String password;
	
	@JsonIgnore
	@OneToMany( mappedBy = "owner" )
	private List<Account> accounts;
	
	public long getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}
