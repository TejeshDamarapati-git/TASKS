package com.mayuratech.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="bankcustomerdetails")
public class BankCustomer {
			
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private int id;
			
			@Column(name = "accountNumber" )
			private Long accountNumber;
			
			@Column(name = "balance")
			private double balance;

			public BankCustomer(int id, Long accountNumber, double balance) {
				this.id = id;
				this.accountNumber = accountNumber;
				this.balance = balance;
			}

			public BankCustomer() {
			}
			
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public Long getAccountNumber() {
				return accountNumber;
			}
			public void setAccountNumber(Long accountNumber) {
				this.accountNumber = accountNumber;
			}
			public double getBalance() {
				return balance;
			}
			public void setBalance(double balance) {
				this.balance = balance;
			}
			@Override
			public String toString() {
				return "BankCustomer [id=" + id + ", accountNumber=" + accountNumber + ", balance=" + balance + "]";
			}
		}
