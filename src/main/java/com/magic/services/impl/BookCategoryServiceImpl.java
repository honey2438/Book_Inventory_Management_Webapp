package com.magic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magic.entities.BookCategory;
import com.magic.repository.BookCategoryRepo;
import com.magic.services.BookCategoryService;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {
	@Autowired
	BookCategoryRepo bookCategoryRepo;

	public List<BookCategory> getCategoryList() {
		return bookCategoryRepo.findAll();
	}

	public BookCategory getBookCategoryByCategory(String category) {
		return bookCategoryRepo.findByCategory(category);
	}

	public void saveBookCategory(BookCategory bookCategory) {
		bookCategoryRepo.save(bookCategory);

	}

	public BookCategory getBookCategoryById(int catid) {
		return bookCategoryRepo.findById(catid).orElse(null);
	}

	public void updateBookCategory(BookCategory bookCategory1, BookCategory bookCategory2) {
		if (!bookCategory1.getCategory().equals(bookCategory2.getCategory())
				|| bookCategory1.getCatid() != bookCategory2.getCatid()
				|| !bookCategory1.getDescription().equals(bookCategory2.getDescription())) {
			bookCategoryRepo.save(bookCategory1);
		}

	}

	public void deleteById(int cid) {
		bookCategoryRepo.deleteById(cid);
	}

}
