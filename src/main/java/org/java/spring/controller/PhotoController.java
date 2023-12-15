package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Photo;
import org.java.spring.db.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PhotoController {
	
	@Autowired
	PhotoService photoService;
	
	@GetMapping("/")
	public String getIndex(Model model, @RequestParam(required = false) String q) {
		
		List<Photo> photos = q == null 
							 ? photoService.findAll()
							 : photoService.findByName(q);
		
		model.addAttribute("photos", photos);
		
		model.addAttribute("q", q == null ? "" : q);
		
		return "photos";
	}

}
