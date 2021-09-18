package com.exam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {
	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//	
	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting code");
		
//		User user = new User();
//		user.setFirstName("Zuhaib");
//		user.setLastName("Ahmed");
//		user.setUsername("zuhaibahmed444");
//		user.setPassword(this.bCryptPasswordEncoder.encode("zuhaib18"));
//		user.setEmail("zuhaibahmed444@gmail.com");
//		user.setProfile("default.png");
//		
//		Role role1 = new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//		
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		
//		userRoleSet.add(userRole);
//		
//		User user1 = (User) this.userService.createUser(user, userRoleSet);
//		
//		System.out.println(user1.getUsername());
//		
		
		
	}

}
