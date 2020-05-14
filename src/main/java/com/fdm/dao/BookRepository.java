package com.fdm.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fdm.model.Book;


@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	Optional<Book> findByName(String name);



}
