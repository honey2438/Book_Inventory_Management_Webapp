package com.magic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.magic.entities.BookCategory;

import com.magic.services.BookCategoryService;


@Controller
@RequestMapping("book-inventory/category")
public class BookCategoryController {

	@Autowired
	BookCategoryService bookCategoryService;

//	http://localhost:8080/book-inventory/category/categorylist
	
	@RequestMapping("categoryList")
	public String getCategoryListView(Model model) {
		List<BookCategory> clist = bookCategoryService.getCategoryList();
		model.addAttribute("clist", clist);
		return "category/category-list";
	}

	@RequestMapping("add")
	public String getCategoryAddList() {

		return "category/add-category";
	}

	@RequestMapping("save")
	public String getNewBookList(Model model, BookCategory bookCategory) {
		String category = bookCategory.getCategory().toUpperCase();
		BookCategory bookCategory1 = bookCategoryService.getBookCategoryByCategory(category);
		if (bookCategory1 != null) {
			List<BookCategory> clist = bookCategoryService.getCategoryList();
			model.addAttribute("clist", clist);
			return "category/category-list";
		}
		bookCategory.setCategory(category);
		bookCategoryService.saveBookCategory(bookCategory);
		List<BookCategory> clist = bookCategoryService.getCategoryList();
		model.addAttribute("clist", clist);
		return "category/category-list";
	}

	@RequestMapping("edit")
	public String bookSaveView(Model model, @RequestParam int cid) {
		BookCategory cat = bookCategoryService.getBookCategoryById(cid);
		model.addAttribute("cat", cat);
		return "category/edit-category";
	}

	@RequestMapping("update")
	public String bookUpdateView(Model model, BookCategory bookCategory) {
		BookCategory bookCategory1 = bookCategoryService.getBookCategoryById(bookCategory.getCatid());
		bookCategoryService.updateBookCategory(bookCategory, bookCategory1);
		List<BookCategory> clist = bookCategoryService.getCategoryList();
		model.addAttribute("clist", clist);
		return "category/category-list";
	}

	@RequestMapping("remove")
	public String bookDeleteView(Model model, @RequestParam int cid) {
		BookCategory cat = bookCategoryService.getBookCategoryById(cid);
		if (cat != null) {
			BookCategoryService.deleteById(cid);
		}

		List<BookCategory> clist = bookCategoryService.getCategoryList();
		model.addAttribute("clist", clist);
		return "category/category-list";
	}
   
}
