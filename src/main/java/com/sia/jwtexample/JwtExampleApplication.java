package com.sia.jwtexample;

import com.sia.jwtexample.Service.UserService;
import com.sia.jwtexample.domain.Role;
import com.sia.jwtexample.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwtExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtExampleApplication.class, args);
	}


	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner runner(UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Schiau Miau", "Hau", "parola", new ArrayList<>()));
			userService.saveUser(new User(null, "Nicusor de la Braila", "Nicu", "parola", new ArrayList<>()));
			userService.saveUser(new User(null, "Emiliu Bocus", "Emiliu", "parola", new ArrayList<>()));
			userService.saveUser(new User(null, "Hap Jap", "Happ", "parola", new ArrayList<>()));

			userService.addRole("Hau", "ROLE_USER");
			userService.addRole("Nicu", "ROLE_ADMIN");
			userService.addRole("Emiliu", "ROLE_MANAGER");
			userService.addRole("Happ", "ROLE_SUPER_ADMIN");
			userService.addRole("Nicu", "ROLE_MANAGER");


		};
	}
}
