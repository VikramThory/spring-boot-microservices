package com.vikramsingh.accounts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Accounts {

	@Column(name = "customer_id")
	private int customerId;
	@Column(name="account_number")
	@Id
	private long accountNumber;
	@Column(name="account_type")
	private String accountType;
	@Column(name = "branch_address")
	private String branchAddress;
	@Column(name = "create_dt")
	private LocalDate createDt;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public LocalDate getCreateDt() {
		return createDt;
	}

	public void setCreateDt(LocalDate createDt) {
		this.createDt = createDt;
	}

	@Override
	public String toString() {
		return "Accounts{" +
				"customerId=" + customerId +
				", accountNumber=" + accountNumber +
				", accountType='" + accountType + '\'' +
				", branchAddress='" + branchAddress + '\'' +
				", createDt=" + createDt +
				'}';
	}
}
