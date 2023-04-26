package com.magic.services;

import java.util.List;

import com.magic.entities.BookPublisher;

public interface BookPublisherService {

	List<BookPublisher> getPublisherList();

	BookPublisher getBookPublisherByPublisher(String publisher);

	BookPublisher getBookPublisherById(int pid);

	void updateBookPublisher(BookPublisher bookPublisher, BookPublisher bookPublisher1);

	void saveBookPublisher(BookPublisher bookPublisher);

	void deleteById(int pid);

}
