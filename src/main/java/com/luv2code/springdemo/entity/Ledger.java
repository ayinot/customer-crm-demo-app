package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ledger")
public class Ledger {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="merchant_id")
	private String merhcantId;
	
	@Column(name="amount")
	private long amount; 
	
	@Column(name="status")
	private String status;
	
	@Column(name="date")
	private String date;
	
	@Column(name="curreny")
	private String curreny;
	
	public Ledger() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMerhcantId() {
		return merhcantId;
	}

	public void setMerhcantId(String merhcantId) {
		this.merhcantId = merhcantId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCurreny() {
		return curreny;
	}

	public void setCurreny(String curreny) {
		this.curreny = curreny;
	}

	@Override
	public String toString() {
		return "Ledger [id=" + id + ", merhcantId=" + merhcantId + ", amount=" + amount + ", status=" + status
				+ ", date=" + date + ", curreny=" + curreny + "]";
	}
	

}