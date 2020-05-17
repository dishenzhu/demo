package com.fdm.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fdm.model.Transaction;
import com.fdm.model.User;



@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

	List<Transaction> findByBuyer(User buyer);
	List<Transaction> findByBuyer_Username(String username);



}
