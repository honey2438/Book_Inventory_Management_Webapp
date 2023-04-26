package com.magic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.magic.entities.BookCategory;

public interface BookCategoryRepo extends JpaRepository<BookCategory, Integer> {
	@Query("from BookCategory where category=:arg")
	BookCategory findByCategory(@Param("arg") String category);

}
