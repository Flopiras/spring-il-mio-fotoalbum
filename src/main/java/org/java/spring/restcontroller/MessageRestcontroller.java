package org.java.spring.restcontroller;

import java.util.List;

import org.java.spring.db.pojo.Message;
import org.java.spring.db.pojo.Photo;
import org.java.spring.db.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/messages")
public class MessageRestcontroller {

	@Autowired
	private MessageService messageService;
	
	@GetMapping
	public ResponseEntity<List<Message>> getIndex() {
		
		List<Message> messages = messageService.findAll();
		
		return new ResponseEntity<>(messages, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Message> create(@RequestBody Message message) {
		
		messageService.save(message);
		
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	
}
