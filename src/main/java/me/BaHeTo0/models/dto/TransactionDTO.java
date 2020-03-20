package me.BaHeTo0.models.dto;

import java.math.BigDecimal;

public class TransactionDTO {


	private BigDecimal amount;
	private long fromId;
	private long toId;
	
	public TransactionDTO(BigDecimal amount, long from, long to) {
		this.amount = amount;
		this.fromId = from;
		this.toId = to;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public long getFromId() {
		return fromId;
	}
	
	public long getToId() {
		return toId;
	}

}
