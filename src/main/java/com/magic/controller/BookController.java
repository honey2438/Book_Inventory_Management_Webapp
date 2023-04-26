package com.magic.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.magic.entities.Book;
import com.magic.entities.BookCategory;
import com.magic.entities.BookPublisher;
import com.magic.services.BookServices;

@Controller
@RequestMapping("book-inventory")
public class BookController {
	@Autowired
	BookServices bookServices;

	@RequestMapping("")
	public String getLoginView() {
		return "home/login";
	}
    
	@RequestMapping("home")
	public String getHomeView() {
		return "home/home-page";
	}

	@RequestMapping("bookList")
	public String getBookListView(Model model) {
		List<Book> blist = bookServices.getBookList();
		model.addAttribute("blist", blist);
		return "book/book-list";
	}

	@RequestMapping("add")
	public String bookAddView(Model model) {
		List<BookCategory> clist = bookServices.getCategoryList();
		List<BookPublisher> plist = bookServices.getPublisherList();
		model.addAttribute("plist", plist);
		model.addAttribute("clist", clist);
		return "book/add-book";
	}

	@RequestMapping("save")
	public String getNewBookList(Model model, Book book) {
		String title = book.getTitle().toUpperCase();
		Book book1 = bookServices.getBookByTitle(title);
		if (book1 != null) {
			List<Book> blist = bookServices.getBookList();
			model.addAttribute("blist", blist);
			return "book/book-list";
		}
		book.setTitle(title);
		bookServices.saveBook(book);
		List<Book> blist = bookServices.getBookList();
		model.addAttribute("blist", blist);
		return "book/book-list";
	}

	@RequestMapping("update")
	public String getUpdatedBookList(Model model, Book book) {
		int bid = book.getBookid();
		Book book1 = bookServices.getBookById(bid);
		bookServices.updateBook(book, book1);
		List<Book> blist = bookServices.getBookList();
		model.addAttribute("blist", blist);
		return "book/book-list";
	}

	@RequestMapping("edit")
	public String bookSaveView(Model model, @RequestParam int bid) {
		Book book1 = bookServices.getBookById(bid);
		model.addAttribute("book", book1);
		List<BookCategory> clist = bookServices.getCategoryList();
		List<BookPublisher> plist = bookServices.getPublisherList();
		model.addAttribute("plist", plist);
		model.addAttribute("clist", clist);
		return "book/edit-book";
	}

	@RequestMapping("remove")
	public String bookDeleteView(Model model, @RequestParam int bid) {
		Book book1 = bookServices.getBookById(bid);
		if (book1 == null) {
			List<Book> blist = bookServices.getBookList();
			model.addAttribute("blist", blist);
			return "book/book-list";
		}
		bookServices.deleteBookById(bid);
		List<Book> blist = bookServices.getBookList();
		model.addAttribute("blist", blist);
		return "book/book-list";

	}

	@RequestMapping("search")
	public String getSearchView(Model model) {
		List<BookCategory> clist = bookServices.getCategoryList();
		List<BookPublisher> plist = bookServices.getPublisherList();
		model.addAttribute("plist", plist);
		model.addAttribute("clist", clist);
		return "search/search-books";
	}

	@RequestMapping("search/byid")
	public String getSearchedListById(Model model,@RequestParam int bookid) {
	    Book book=new Book();
	    book.setBookid(bookid);
	    System.out.println(book);
	    List<Book> list=bookServices.searchBookList(book);
	    if(list!=null) {
	    	model.addAttribute("blist",list);
			return "search/book-list";
	    }
	    list=new ArrayList();
	    model.addAttribute("blist",list);
		return "search/book-list";
	}
	@RequestMapping("search/byauthor")
	public String getSearchedListByAuthor(Model model,@RequestParam String author) {
	    Book book=new Book();
	    book.setAuthor(author);
	    List<Book> list=bookServices.searchBookList(book);
	    if(list!=null) {
	    	model.addAttribute("blist",list);
			return "search/book-list";
	    }
	    list=new ArrayList();
	    model.addAttribute("blist",list);
		return "search/book-list";
	}
	@RequestMapping("search/bytitle")
	public String getSearchedListByTitle(Model model,@RequestParam String title) {
	    Book book=new Book();
	    book.setTitle(title);
	    List<Book> list=bookServices.searchBookList(book);
	    if(list!=null) {
	    	model.addAttribute("blist",list);
			return "search/book-list";
	    }
	    list=new ArrayList();
	    model.addAttribute("blist",list);
		return "search/book-list";
	}
	@RequestMapping("search/bycategory")
	public String getSearchedListByCategory(Model model,@RequestParam int catid) {
	    Book book=new Book();
	    book.setCatid(catid);
	    List<Book> list=bookServices.searchBookList(book);
	    if(list!=null) {
	    	model.addAttribute("blist",list);
			return "search/book-list";
	    }
	    list=new ArrayList();
	    model.addAttribute("blist",list);
		return "search/book-list";
	}
	@RequestMapping("search/bypublisher")
	public String getSearchedListByPublisher(Model model,@RequestParam int pubid) {
	    Book book=new Book();
	    book.setPubid(pubid);
	    List<Book> list=bookServices.searchBookList(book);
	    model.addAttribute("blist",list);
		return "search/book-list";
	}
	@RequestMapping("search/editsearch")
	public String bookEditView(Model model, @RequestParam int bid) {
		Book book1 = bookServices.getBookById(bid);
		model.addAttribute("book", book1);
		List<BookCategory> clist = bookServices.getCategoryList();
		List<BookPublisher> plist = bookServices.getPublisherList();
		model.addAttribute("plist", plist);
		model.addAttribute("clist", clist);
		return "search/edit-book";
	}
	
	@RequestMapping("search/searchupdate")
	public String getUpdatedSearchList(Model model, Book book) {
		int bid = book.getBookid();
		Book book1 = bookServices.getBookById(bid);
		bookServices.updateBook(book, book1);
		List<Book> blist = bookServices.getBookList();
		model.addAttribute("blist", blist);
		return "redirect";
	}
	@RequestMapping("search/removesearch")
	public String bookRemoveView(Model model, @RequestParam int bid) {
		Book book1 = bookServices.getBookById(bid);
		if (book1 == null) {
			List<Book> blist = bookServices.getBookList();
			model.addAttribute("blist", blist);
			return "book/search-books";
		}
		
		bookServices.deleteBookById(bid);
		List<Book> blist = bookServices.getBookList();
		model.addAttribute("blist", blist);
		return "search/search-books";
	}

}
