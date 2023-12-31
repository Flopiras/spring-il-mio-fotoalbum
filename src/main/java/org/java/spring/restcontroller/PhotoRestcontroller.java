package org.java.spring.restcontroller;

import java.util.List;

import org.java.spring.db.pojo.Photo;
import org.java.spring.db.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/photos")
public class PhotoRestcontroller {
	
	@Autowired
	private PhotoService photoService;
	
	@GetMapping
	public ResponseEntity<List<Photo>> getIndex() {
		
		List<Photo> photos = photoService.findAllByVisible();
		
//		List<Photo> photos = q == null ? photoService.findAllByVisible() : photoService.findByTitle(q);
		
		return new ResponseEntity<>(photos, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Photo> getPhoto(@PathVariable int id) {
		
		Photo photo = photoService.findById(id);
		
		if(photo == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(photo, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Photo> create(@RequestBody Photo photo) {
		
		photoService.save(photo);
		
		return new ResponseEntity<>(photo, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Photo> update(@PathVariable int id, @RequestBody Photo newPhoto) {
		
		Photo photo = photoService.findById(id);
		
		photo.setTitle(newPhoto.getTitle());
		photo.setDescription(newPhoto.getDescription());
		photo.setVisible(newPhoto.getVisible());
		photo.setUrl(newPhoto.getUrl());
		
		photoService.save(photo);
		
		return new ResponseEntity<>(photo, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Photo> delete(@PathVariable int id) {
		
		Photo photo = photoService.findById(id);
		
		photoService.delete(photo);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
