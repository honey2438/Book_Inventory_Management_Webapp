package com.magic.services;

import java.util.List;

import com.magic.entities.BookCategory;

public interface BookCategoryService {

	List<BookCategory> getCategoryList();

	BookCategory getBookCategoryByCategory(String category);

	void saveBookCategory(BookCategory bookCategory);

	void updateBookCategory(BookCategory bookCategory, BookCategory bookCategory1);

	BookCategory getBookCategoryById(int catid);

	static void deleteById(int cid) {
		// TODO Auto-generated method stub
		
	}

}
