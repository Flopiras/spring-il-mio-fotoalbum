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
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;


@Controller
public class PhotoController {
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public String getIndex(Model model, @RequestParam(required = false) String q) {
		
		List<Photo> photos = q == null 
							 ? photoService.findAll()
							 : photoService.findByTitle(q);
		
		model.addAttribute("photos", photos);
		
		model.addAttribute("q", q == null ? "" : q);
		
		return "photos";
	}
	
	@GetMapping("/photos/{id}")
	public String photoDetail(Model model, @PathVariable int id) {
		
		Photo photo = photoService.findById(id);
		
		model.addAttribute("photo", photo);
		
		return "photo";
	}
	
	@GetMapping("photos/create")
	public String createPhoto(Model model) {
		
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		
		Photo photo = new Photo();
		model.addAttribute("photo", photo);
		
		return "photo-form";
	}
	
	@PostMapping("photos/create")
	public String storePhoto(Model model, @Valid @ModelAttribute Photo photo, BindingResult bindingResult) {
		
		return savePhoto(model, photo, bindingResult);
	}
	 
	//methods
	private String savePhoto(Model model, @Valid @ModelAttribute Photo photo, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			
			System.out.println(bindingResult);
			model.addAttribute("photo", photo);
			
			return "photo-form";
		}
		
		try {
			
			photoService.save(photo);
			
		} catch (Exception e) {
			
			model.addAttribute("photo", photo);
			
			return "photo-form";
		}
		
		return "redirect:/";
	}

}
