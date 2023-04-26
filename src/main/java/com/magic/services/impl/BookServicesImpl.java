package com.magic.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magic.entities.Book;
import com.magic.entities.BookCategory;
import com.magic.entities.BookPublisher;
import com.magic.repository.BookRepo;
import com.magic.repository.BookCategoryRepo;
import com.magic.repository.BookPublisherRepo;
import com.magic.services.BookServices;

@Service
public class BookServicesImpl implements BookServices {
	@Autowired
	BookRepo bookRepo;
	@Autowired
	BookCategoryRepo bookCategoryRepo;
	@Autowired
	BookPublisherRepo bookPublisherRepo;

	public List<Book> getBookList() {
		return bookRepo.findAll();
	}

	public List<BookCategory> getCategoryList() {
		return bookCategoryRepo.findAll();

	}

	public List<BookPublisher> getPublisherList() {
		return bookPublisherRepo.findAll();
	}

	public Book getBookByTitle(String title) {

		if (bookRepo.findByTitle(title) == null)
			return null;
		return bookRepo.findByTitle(title);
	}

	public void saveBook(Book book) {
		bookRepo.save(book);
	}

	public void updateBook(Book book, Book book1) {

		if (!book.getAuthor().equals(book1.getAuthor()) || book.getCatid() != book1.getCatid()
				|| book1.getCopies() != book.getCopies() || book.getPrice() != book1.getPrice()
				|| book1.getTitle() != book.getTitle() || book1.getPubid() != book.getPubid()) {
			bookRepo.save(book);
		}

	}

	public Book getBookById(int bid) {
		return bookRepo.findById(bid).orElse(null);
	}

	public void deleteBookById(int bid) {
		bookRepo.deleteById(bid);

	}


	@Override
	public List<Book> searchBookList(Book book) {
		if (book.getBookid() != 0) {
			List<Book> list = new ArrayList<Book>();
			Book book1=bookRepo.findById(book.getBookid()).orElse(null);
			if(book1!=null)
			list.add(book1);
			return list;
		} else if (book.getAuthor() != null) {
			return bookRepo.findByAuthor(book.getAuthor());
		} else if (book.getTitle() != null) {
			return bookRepo.findBooksByTitle(book.getTitle());
		} else if (book.getCatid() != 0) {

			return bookRepo.findByCategory(book.getCatid());

		} else if (book.getPubid() != 0) {

			return bookRepo.findByPublisher(book.getPubid());

		}
		return null;
	}

}
