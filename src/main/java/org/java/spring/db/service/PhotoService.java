package org.java.spring.db.service;

import java.util.List;

import org.java.spring.db.pojo.Photo;
import org.java.spring.db.repo.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {
	
	@Autowired
	PhotoRepository photoRepository;
	
	public List<Photo> findAll() {
		
		return photoRepository.findAll();
	}
	
	public Photo findById(int id) {
		
		return photoRepository.findById(id).get();
	}
	
	public List<Photo> findByName(String query) {
		
		return photoRepository.findByNameIgnoreCase(query);
	}
	
	public void save(Photo photo) {
		
		photoRepository.save(photo);
	}
	
	public void delete(Photo photo) {
		
		photoRepository.delete(photo);
	}
	
	public void deleteById(int id) {
		
		photoRepository.deleteById(id);
	}

}
