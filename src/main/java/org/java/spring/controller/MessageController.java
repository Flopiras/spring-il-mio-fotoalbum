package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Message;
import org.java.spring.db.pojo.Photo;
import org.java.spring.db.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/messages")
	public String getIndex(Model model) {
		
		List<Message> messages = messageService.findAll();
		
		model.addAttribute("messages", messages);
		
		return "messages";
	}
	
	@GetMapping("/messages/{id}")
	public String messageDetail(Model model, @PathVariable int id) {
		
		Message message = messageService.findById(id);
		
		model.addAttribute("message", message);
		
		return "message";
	}
	
	@PostMapping("messages/delete/{id}")
	public String deletePhoto(@PathVariable int id) {
		
		Message message = messageService.findById(id);
		
		messageService.delete(message);
		
		return "redirect:/messages";
	}

}
