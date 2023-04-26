package com.magic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.magic.entities.BookPublisher;

public interface BookPublisherRepo extends JpaRepository<BookPublisher, Integer> {
	@Query("from BookPublisher where publisher=:arg")
	BookPublisher findByPublisher(@Param("arg") String publisher);

}
