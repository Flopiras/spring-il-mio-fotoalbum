package org.java.spring.db.pojo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	@Length(min = 3, max = 80, message = "Il titolo della foto non può essere più lungo di 80 caratteri")
	private String title;
	
	@Column(columnDefinition = "TEXT")
	@Length(min = 3, message = "La descrizione deve avere almeno 3 caratteri")
	private String description;
	
	@Column
	@URL
	private String url;
	
	@Column
	private Boolean visible;
	
	//relations
	@ManyToMany
	private List<Category> categories;
	
	//constructrs
	public Photo() { }
	public Photo(String title, String description, String url, Boolean visible, Category...categories) {
		
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
	}
	
	//getters and setters
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	@JsonIgnore
	public void setCategories(Category...categories) {	
		setCategories(Arrays.asList(categories));
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	
	//overrides
	@Override
	public String toString() {
		return "PHOTO [" 
				+ getId() + "] - "
				+ getTitle() + "\n"
				+ getDescription() + "\n"
				+ getUrl();
	}
}
