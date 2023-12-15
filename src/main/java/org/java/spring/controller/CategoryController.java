package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Category;
import org.java.spring.db.pojo.Photo;
import org.java.spring.db.service.CategoryService;
import org.java.spring.db.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PhotoService photoService;
	
	@GetMapping("/categories")
	public String getCategories(Model model) {
		
		List<Category> categories = categoryService.findAll();
		
		model.addAttribute("categories", categories);
		
		return "categories";
	}
	
	@GetMapping("/categories/create")
	public String createCategory(Model model) {

		model.addAttribute("category", new Category());

		return "category-form";
	}
	
	@PostMapping("/categories/create")
	public String storeCategory(
			Model model,
			@Valid @ModelAttribute Category category,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			
			model.addAttribute("category", category);
			
			return "category-form";
		}
		
		categoryService.save(category);
		
		return "redirect:/categories";
	}
	
	@PostMapping("/categories/delete/{id}")
	
	public String deleteCategory(@PathVariable int id) {
		
		Category category = categoryService.findById(id);
		
		List<Photo> categoryPhoto = category.getPhotos();
		
		categoryPhoto.forEach(c -> {
			
			c.getCategories().remove(category);
			
			photoService.save(c);
		});
		
		categoryService.delete(category);
		
		return "redirect:/categories";
	}

}
