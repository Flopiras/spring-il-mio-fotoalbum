package org.java.spring.db.pojo;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	@Length(min = 3, max = 80, message = "Il titolo del messaggio non può essere più lungo di 80 caratteri")
	private String title;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	@Length(min = 3, message = "La descrizione non può essere più corta di 3 caratteri")
	private String content;
	
	//constructor
	public Message() { }
	public Message(String title, String content) {
		
		setTitle(title);
		setContent(content);
	}
	
	//getters and setters
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	//overrides
	@Override
	public String toString() {

		return "[" + getTitle() + "] \n"
				+ getContent();
	}

}
