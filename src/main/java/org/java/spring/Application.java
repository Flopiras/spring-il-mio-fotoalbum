package org.java.spring;

import org.java.spring.db.pojo.Category;
import org.java.spring.db.pojo.Photo;
import org.java.spring.db.service.CategoryService;
import org.java.spring.db.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application  implements CommandLineRunner{
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private CategoryService categoryService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//CATEGORIES
		Category c1 = new Category("bianco e nero");
		Category c2 = new Category("photostreet");
		Category c3 = new Category("animali");
		Category c4 = new Category("ritratti");
		Category c5 = new Category("città");
		Category c6 = new Category("paesaggi");
		Category c7 = new Category("fototessere");
		Category c8 = new Category("natale");
		
		categoryService.save(c1);
		categoryService.save(c2);
		categoryService.save(c3);
		categoryService.save(c4);
		categoryService.save(c5);
		categoryService.save(c6);
		categoryService.save(c7);
		categoryService.save(c8);
		
		//PHOTOS
		photoService.save(new Photo("foto1", "descrizione1", "https://picsum.photos/300?random=1", false));
		photoService.save(new Photo("foto2", "descrizione2", "https://picsum.photos/300?random=2", false));
		photoService.save(new Photo("foto3", "descrizione3", "https://picsum.photos/300?random=3", true));
		photoService.save(new Photo("foto4", "descrizione4", "https://picsum.photos/300?random=4", false));
		photoService.save(new Photo("foto5", "descrizione5", "https://picsum.photos/300?random=5", false));
		photoService.save(new Photo("foto6", "descrizione6", "https://picsum.photos/300?random=6", true));
		photoService.save(new Photo("foto7", "descrizione7", "https://picsum.photos/300?random=7", false));
		photoService.save(new Photo("foto8", "descrizione8", "https://picsum.photos/300?random=8", true));
		photoService.save(new Photo("foto9", "descrizione9", "https://picsum.photos/300?random=9", true));
		photoService.save(new Photo("foto10", "descrizione10", "https://picsum.photos/300?random=10", false));
		photoService.save(new Photo("foto11", "descrizione11", "https://picsum.photos/300?random=11", false));
		photoService.save(new Photo("foto12", "descrizione12", "https://picsum.photos/300?random=12", true));
		photoService.save(new Photo("foto13", "descrizione13", "https://picsum.photos/300?random=13", true));
		photoService.save(new Photo("foto14", "descrizione14", "https://picsum.photos/300?random=14", false));
		photoService.save(new Photo("foto15", "descrizione15", "https://picsum.photos/300?random=15", true));
		photoService.save(new Photo("foto16", "descrizione16", "https://picsum.photos/300?random=16", false));
		photoService.save(new Photo("foto17", "descrizione17", "https://picsum.photos/300?random=17", true));
		photoService.save(new Photo("foto18", "descrizione18", "https://picsum.photos/300?random=18", false));
		photoService.save(new Photo("foto19", "descrizione19", "https://picsum.photos/300?random=19", true));
		photoService.save(new Photo("foto20", "descrizione20", "https://picsum.photos/300?random=20", false));
	}

}
