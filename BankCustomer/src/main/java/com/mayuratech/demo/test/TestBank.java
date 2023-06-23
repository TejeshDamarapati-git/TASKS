package com.mayuratech.demo.test;

import com.mayuratech.demo.controller1.BankController;
import com.mayuratech.demo.entity.BankCustomer;
public class TestBank {

	public static void main(String[] args) {
		
				BankCustomer bankcustomer1=new BankCustomer();
//				bankcustomer1.setAccountNumber(12315681l);
//				bankcustomer1.setBalance(1000.0);
//				bankcustomer1.setId(101);
		
				BankCustomer bankcustomer = new BankCustomer();
//				bankcustomer.setAccountNumber(50012600031l);
//				bankcustomer.setBalance(2000);
//				bankcustomer.setId(206);

		        // Add the customer
		        BankController bankcontroller = new BankController();
//		        bankcontroller.addCustomer(bankcustomer);
//		        bankcontroller.addCustomer(bankcustomer1);

		        //Retrieve the customer by account number
		        BankCustomer getaccountNum = bankcontroller.getCustomerByAccountNumber(12300031);
		        System.out.println("get Customer by Account Number: " + getaccountNum);

		        // Delete the customer if the balance is less than 100
		        if (bankcustomer.getBalance() < 100) {
		        	bankcontroller.deleteAccount(bankcustomer);
		            System.out.println("Customer deleted: " + bankcustomer);
		        }

		        // Update the account balance when withdrawing or depositing amount
		        double withdrawalAmount = 200.0;
		        getaccountNum.setBalance(getaccountNum.getBalance() - withdrawalAmount);
		        BankController.updateBankBalance(getaccountNum, -withdrawalAmount);
		        System.out.println("Withdrawal amount of " + withdrawalAmount + " deducted from the account.");

//		        double depositAmount = 1000.0;
//		        getaccountNum.setBalance(getaccountNum.getBalance() + depositAmount);
//		        BankController.updateBankBalance(getaccountNum, depositAmount);
//		        System.out.println("Deposit amount of " + depositAmount + " added to the account.");

		        // Display the updated customer details
		        System.out.println("Updated Customer: " + getaccountNum);
		        }
	}


