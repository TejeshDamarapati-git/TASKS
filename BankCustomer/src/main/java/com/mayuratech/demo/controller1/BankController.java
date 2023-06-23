package com.mayuratech.demo.controller1;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mayuratech.demo.entity.BankCustomer;
import com.mayuratech.demo.serviceDao.BankService;

import jakarta.persistence.NoResultException;

public class BankController {
	
 
	public void addCustomer(BankCustomer bankcustomer) {
		Transaction transaction=null;
		try(Session session= BankService.getSessionFactory().openSession()) {
				 transaction=session.beginTransaction();
				session.save(bankcustomer);
		        transaction.commit();
		        session.close();
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
		}
	}
	
	public BankCustomer getCustomerByAccountNumber(long accountNumber) {
		BankCustomer bankcustomer=null;
        try (Session session = BankService.getSessionFactory().openSession()) {
        	Query<BankCustomer> createQuery = session.createQuery("FROM BankCustomer WHERE accountNumber = :accountNumber", BankCustomer.class);
        	createQuery.setParameter("accountNumber", accountNumber);
//                    .getSingleResult();
        	bankcustomer=createQuery.uniqueResult();
        } catch (NoResultException e) {
            System.out.println("Customer not found for account number: " + accountNumber);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
      return bankcustomer;
    }
	
	public BankCustomer getcustomerdetails(BankCustomer bankcustomer) {
        try (Session session = BankService.getSessionFactory().openSession()) {
            return session.get(BankCustomer.class, session);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public void deleteAccount(BankCustomer bankcustomer) {
		Transaction transaction=null;
		try(Session session= BankService.getSessionFactory().openSession()){
				transaction=session.beginTransaction();
				bankcustomer= session.get(BankCustomer.class, session);
				session.delete(bankcustomer);
		        transaction.commit();
		        session.close();
		} catch (Exception e) {
			if(transaction!=null) {
//				transaction.rollback();
			}
		}
	}
	
	public static void updateBankBalance(BankCustomer bankcustomer, double amount) {
		Transaction transaction=null;
		try(Session session= BankService.getSessionFactory().openSession()) {
				 transaction=session.beginTransaction();
				 bankcustomer.setBalance(bankcustomer.getBalance() + amount);
				session.saveOrUpdate(bankcustomer);
		        transaction.commit();
		        session.close();
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
//Create a bank account details service application using Hibernate. Perform CRUD operations like
//Add new customer details, 
//Get customer details, 
//Get customer detail based on account number, 
//Delete specific account if the balance is less than 100 & 
//Update the account balance whenever the user withdraws the amount or deposit the amount.
