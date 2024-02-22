package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.controller.SessionFactoryProvider;
import com.entity.BankDTO;
import com.entity.StatementDTO;
import com.entity.UserDTO;

public class UserDAO {
	Transaction transaction = null;

	public boolean saveUserDetails(UserDTO user) {

		try {
			Session session = SessionFactoryProvider.getSessionFactory();
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();

		}
		return false;

	}

	public UserDTO showUserDetails(String username, String password) {
		Session session = SessionFactoryProvider.getSessionFactory();
		transaction = session.beginTransaction();
		Query<UserDTO> query = session.createQuery("FROM UserDTO WHERE name = :username AND password = :password",
				UserDTO.class);
		query.setParameter("username", username);
		query.setParameter("password", password);

		return query.uniqueResult();

	}

	public boolean saveBankDetails(BankDTO bank) {
		try {
			Session session = SessionFactoryProvider.getSessionFactory();
			transaction = session.beginTransaction();
			session.save(bank);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	public List<BankDTO> getBankDetailsByUserId(int user_Id) {
		Session session = SessionFactoryProvider.getSessionFactory();
		transaction = session.beginTransaction();

		// Write your native SQL query to fetch bank details based on user_id
		String sqlQuery = "select *from bank_account where user_Id= :userId";

		// Create a native query
		NativeQuery<BankDTO> query = session.createNativeQuery(sqlQuery, BankDTO.class);
		query.setParameter("userId", user_Id);

		// Execute query and return results
		return query.getResultList();
	}

	public UserDTO getUserById(int user_Id) {
		Session session = null;
		try {
			session = SessionFactoryProvider.getSessionFactory();
			return session.get(UserDTO.class, user_Id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	public boolean updateBalance(BankDTO bank) {
	    try {
	        Session session = SessionFactoryProvider.getSessionFactory();
	        transaction = session.beginTransaction();

	        session.update(bank);
	        transaction.commit();
	        session.close();
	        return true;
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    }
	    return false;
	}
	
	
	public BankDTO getBankById(int accountId) {
	    Session session = null;
	    try {
	        session = SessionFactoryProvider.getSessionFactory();
	        return session.get(BankDTO.class, accountId);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return null;
	}
	
	
	public double getCurrentBalance(int accountId) {
		Session session=SessionFactoryProvider.getSessionFactory();
		transaction=session.beginTransaction();
	    
	    // Write your Hibernate query to retrieve the current balance
	    String hql = "SELECT b.currentBalance FROM BankDTO b WHERE b.accountID = :accountId";
	    
	    // Create a Hibernate query object
	    Query<Double> query = session.createQuery(hql, Double.class);
	    query.setParameter("accountId", accountId);
	    
	    // Execute the query and return the result
	    return query.uniqueResult();
	}


	public boolean logTransaction(StatementDTO txns) {
		try {
			Session session = SessionFactoryProvider.getSessionFactory();
			transaction = session.beginTransaction();
			session.save(txns);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}
	
	public List<StatementDTO> getStatementsByAccountID(int accountID) {
	    Session session = SessionFactoryProvider.getSessionFactory();
	    transaction = session.beginTransaction();

	    // Write your HQL query to fetch statements based on the account ID
	    String hql = "FROM StatementDTO WHERE fromAccountNumber = :accountID OR toAccountNumber = :accountID";

	    // Create a Hibernate query object
	    Query<StatementDTO> query = session.createQuery(hql, StatementDTO.class);
	    query.setParameter("accountID", accountID);

	    // Execute query and return results
	    return query.getResultList();
	}


}