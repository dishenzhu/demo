package com.fdm.dao;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fdm.model.Transaction;



@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

	Optional<Transaction> findByDate(Date date);



}
