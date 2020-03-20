package me.BaHeTo0.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "accounts" )
public class Account {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn( name = "owner_id", nullable = false)
	private User owner;
	
	@Column( nullable = false)
	private BigDecimal balance;
	
	
	public long getId() {
		return this.id;
	}

	public User getOwner() {
		return owner;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}
	
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
