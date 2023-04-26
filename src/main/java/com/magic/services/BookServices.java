package com.magic.services;

import java.util.List;

import com.magic.entities.Book;
import com.magic.entities.BookCategory;
import com.magic.entities.BookPublisher;

public interface BookServices {
	public List<Book> getBookList();

	public List<BookCategory> getCategoryList();

	public List<BookPublisher> getPublisherList();

	public Book getBookByTitle(String title);

	public void saveBook(Book book);
	public Book getBookById(int bid);

	public void deleteBookById(int bid);

	public void updateBook(Book book, Book book1);

	public List<Book> searchBookList(Book book);


}
