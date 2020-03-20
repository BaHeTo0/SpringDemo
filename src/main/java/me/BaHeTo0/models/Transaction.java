package me.BaHeTo0.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "transactions" )
public class Transaction {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne
	@JoinColumn( name = "from_id", referencedColumnName = "id")
	private Account from;
	
	@OneToOne
	@JoinColumn( name = "to_id", referencedColumnName = "id")
	private Account to;
	
	@Column( nullable = false )
	private BigDecimal amount;

	public Account getFrom() {
		return from;
	}
	
	public void setFrom(Account from) {
		this.from = from;
	}
	
	public Account getTo() {
		return to;
	}
	
	public void setTo(Account to) {
		this.to = to;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public long getId() {
		return id;
	}
}
