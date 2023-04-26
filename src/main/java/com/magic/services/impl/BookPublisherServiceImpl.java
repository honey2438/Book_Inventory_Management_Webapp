package com.magic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magic.entities.BookCategory;
import com.magic.entities.BookPublisher;
import com.magic.repository.BookPublisherRepo;
import com.magic.services.BookPublisherService;

@Service
public class BookPublisherServiceImpl implements BookPublisherService {
	@Autowired
	BookPublisherRepo bookPublisherRepo;

	public List<BookPublisher> getPublisherList() {
		return bookPublisherRepo.findAll();
	}

	public BookPublisher getBookPublisherById(int pid) {
		return bookPublisherRepo.findById(pid).orElse(null);
	}

	public void saveBookPublisher(BookPublisher bookPublisher) {
		bookPublisherRepo.save(bookPublisher);

	}

	public BookPublisher getBookPublisherByPublisher(String publisher) {
		return bookPublisherRepo.findByPublisher(publisher);
	}

	public void updateBookPublisher(BookPublisher bookPublisher, BookPublisher bookPublisher1) {
		if (!bookPublisher.getEmail().equals(bookPublisher1.getEmail())
				|| !bookPublisher.getPhone().equals(bookPublisher1.getPhone())
				|| !bookPublisher.getPublisher().equals(bookPublisher1.getPublisher())
				|| bookPublisher.getPubid() != bookPublisher1.getPubid()) {
			bookPublisherRepo.save(bookPublisher);
		}

	}

	public void deleteById(int pid) {
		bookPublisherRepo.deleteById(pid);

	}

}
