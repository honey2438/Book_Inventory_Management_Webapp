package com.magic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.magic.entities.BookPublisher;
import com.magic.services.BookPublisherService;


@Controller
@RequestMapping("book-inventory/publisher")
public class BookPublisherController {
	@Autowired
	BookPublisherService bookPublisherService;

	@RequestMapping("publisherList")
	public String getPublisherListView(Model model) {
		List<BookPublisher> plist = bookPublisherService.getPublisherList();
		model.addAttribute("plist", plist);
		return "publisher/publisher-list";
	}

	@RequestMapping("add")
	public String getCategoryAddList() {
		return "publisher/add-publisher";
	}

	@RequestMapping("save")
	public String getNewBookList(Model model, BookPublisher bookPublisher) {
		String publisher = bookPublisher.getPublisher().toUpperCase();
		BookPublisher bookPublisher1 = bookPublisherService.getBookPublisherByPublisher(publisher);
		if (bookPublisher1 != null) {
			List<BookPublisher> plist = bookPublisherService.getPublisherList();
			model.addAttribute("plist", plist);
			return "publisher/publisher-list";
		}
		bookPublisher.setPublisher(publisher);
	bookPublisherService.saveBookPublisher(bookPublisher);
		List<BookPublisher> plist = bookPublisherService.getPublisherList();
		model.addAttribute("plist", plist);
		return "publisher/publisher-list";
	}

	@RequestMapping("edit")
	public String bookSaveView(Model model, @RequestParam int pid) {
		BookPublisher pub = bookPublisherService.getBookPublisherById(pid);
		model.addAttribute("pub", pub);
		return "publisher/edit-publisher";
	}

	@RequestMapping("update")
	public String bookUpdateView(Model model, BookPublisher bookPublisher) {
		BookPublisher bookPublisher1 = bookPublisherService.getBookPublisherById(bookPublisher.getPubid());
		bookPublisherService.updateBookPublisher(bookPublisher, bookPublisher1);
		List<BookPublisher> plist = bookPublisherService.getPublisherList();
		model.addAttribute("plist", plist);
		return "publisher/publisher-list";
	}

	@RequestMapping("remove")
	public String bookDeleteView(Model model, @RequestParam int pid) {
		BookPublisher pat = bookPublisherService.getBookPublisherById(pid);
		if (pat != null) {
			bookPublisherService.deleteById(pid);
		}

		List<BookPublisher> plist = bookPublisherService.getPublisherList();
		model.addAttribute("plist", plist);
		return "publisher/publisher-list";
	}
}
