package com.example.jpauserrole;

import com.example.jpauserrole.entities.Role;
import com.example.jpauserrole.entities.User;
import com.example.jpauserrole.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class JpaUserRoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaUserRoleApplication.class, args);
	}

	@Bean
	CommandLineRunner start(UserService userService) {
		return args -> {
			System.out.println( " .d8888b.           888     888\nd88    88b          888     888      2023\n888    888          888     888\n888    888 888  888 888     888 88888b.  .d88888\n888    888  88..88  888     888 888 \"88b 880\n888    888   X88X   888     888 888  888 '88888b.\nY88    88P  d8''8b  '88.   .88' 888  888      888\n 'Y8888P'  888  888   '88888'   888  888  88888P\n");

			User u1 = new User();
			u1.setUserName("user1");
			u1.setPassWord("0000");
			userService.addNewUser(u1);

			User u2 = new User();
			u2.setUserName("user2");
			u2.setPassWord("0000");
			userService.addNewUser(u2);

			Stream.of("STUDENT", "USER", "ADMIN")
					.forEach(s -> {
						Role r = new Role();
						r.setRoleName(s);
						userService.addNewRole(r);
					});

			userService.addRoleToUser("user1", "STUDENT");
			userService.addRoleToUser("user1", "USER");
			userService.addRoleToUser("user2", "USER");
			userService.addRoleToUser("user2", "ADMIN");

			try {
				User user = userService.authenticate("user1", "0000");
				System.out.println("Id: " + user.getUserId() + ", Name: " + user.getUserName());
				System.out.println("Roles: ");
				user.getRoles().forEach(role -> {
					System.out.println(" - " + role.toString());
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	}

}
