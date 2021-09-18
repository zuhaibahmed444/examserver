package com.exam.service.Impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.exam.helper.UserFoundException;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	//create the user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User local = this.userRepository.findByUsername(user.getUsername());
		if (local != null) {
			System.out.println("User already there !!");
			throw new UserFoundException();
			
			
		}else {
			//create user
			for(UserRole ur:userRoles) 
			{
				roleRepository.save(ur.getRole()); // to save all the roles
			}
			
			user.getUserRoles().addAll(userRoles); // to add all the roles
			local = this.userRepository.save(user);
			
		}
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("zuhaibahmed444@gmail.com");
		message.setTo(local.getEmail());
		message.setText("welcome to Exam portal"+"\nUsername:"+local.getUsername()+"\nEmail id:" +local.getEmail());
		message.setSubject("Signup Success");
		
		mailSender.send(message);
		System.out.println("Mail sent....");

		return local;
		
	}

	
	//getting user by username 
	@Override
	public User getUser(String username) {
		return this.userRepository.findByUsername(username);
	}

	//delete user by id
	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
		
	}
	
	

}
