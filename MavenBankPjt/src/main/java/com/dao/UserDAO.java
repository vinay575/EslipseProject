package com.dao;

import java.util.Collections;
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
	    Transaction transaction = null;
	    
	    try {
	        transaction = session.beginTransaction();
	        String hql = "FROM StatementDTO WHERE from_Account_Id = :accountID OR to_Account_Id = :accountID";
	        Query<StatementDTO> query = session.createQuery(hql, StatementDTO.class);
	        query.setParameter("accountID", accountID);
	        List<StatementDTO> statementList = query.getResultList();
	        transaction.commit();
	        return statementList;
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return Collections.emptyList();
	}
	
	
	
	public int getAccountIdByAccountNumber(String accountNumber) {
	    
		Session session=SessionFactoryProvider.getSessionFactory();
		transaction=session.beginTransaction();
	   
	    String hql = "SELECT b.id FROM BankDTO b WHERE b.bankAccountNo = :accountNumber";
	    
	    
	    Query<Integer> query = session.createQuery(hql, Integer.class);
	    query.setParameter("accountNumber", accountNumber);
	    
	   
	    Integer accountId = query.uniqueResult();
	    return accountId != null ? accountId : -1; // Return -1 if account ID is not found
	}
	
	
	public boolean updateBalance(int accountId, double newBalance) {
    	Session session=SessionFactoryProvider.getSessionFactory();
    	transaction=session.beginTransaction();

        try {
            
            String hql = "UPDATE BankDTO b SET b.currentBalance = :newBalance WHERE b.accountID = :accountId";
            int updatedRows = session.createQuery(hql)
                                    .setParameter("newBalance", newBalance)
                                    .setParameter("accountId", accountId)
                                    .executeUpdate();

            transaction.commit();
    		session.close();
            return updatedRows > 0;
            
        } catch (Exception e) {
        	e.printStackTrace();
            return false;
        }	
    }
}