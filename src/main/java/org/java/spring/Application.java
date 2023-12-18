package org.java.spring;

import org.java.spring.auth.conf.AuthConf;
import org.java.spring.auth.db.pojo.Role;
import org.java.spring.auth.db.pojo.User;
import org.java.spring.auth.db.serv.RoleService;
import org.java.spring.auth.db.serv.UserService;
import org.java.spring.db.pojo.Category;
import org.java.spring.db.pojo.Message;
import org.java.spring.db.pojo.Photo;
import org.java.spring.db.service.CategoryService;
import org.java.spring.db.service.MessageService;
import org.java.spring.db.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private PhotoService photoService;

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageService messageService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// CATEGORIES
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

		// PHOTOS
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

		//MESSAGES
		Message m1 = new Message("messaggio1", "contenuto del messaggio 1");
		Message m2 = new Message("messaggio2", "contenuto del messaggio 2");
		Message m3 = new Message("messaggio3", "contenuto del messaggio 3");
		Message m4 = new Message("messaggio4", "contenuto del messaggio 4");
		Message m5 = new Message("messaggio5", "contenuto del messaggio 5");
		
		messageService.save(m1);
		messageService.save(m2);
		messageService.save(m3);
		messageService.save(m4);
		messageService.save(m5);
		
		
		// ROLES
		Role roleUser = new Role("USER");
		Role roleAdmin = new Role("ADMIN");
		Role roleGod = new Role("GOD");

		roleService.save(roleUser);
		roleService.save(roleAdmin);
		roleService.save(roleGod);

		String psw = AuthConf.passwordEncoder().encode("password");

		User florianaUser = new User("florianaUser", psw, roleUser);
		User florianaAdmin = new User("florianaAdmin", psw, roleAdmin);
		User florianaGod = new User("florianaGod", psw, roleGod);

		userService.save(florianaUser);
		userService.save(florianaAdmin);
		userService.save(florianaGod);
	}

}
