package com.bootproject.user.ctrl;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootproject.user.domain.User;
import com.bootproject.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController()
@RequestMapping()
public class UserController {
	
	@Autowired 
	private UserService usv;
	
	
	@GetMapping("/api/v1/user")
	public Principal user(Principal principal) {
		return principal;
	}

	@GetMapping("/hello")
	@ResponseBody
	public ResponseEntity<?> hello(Principal principal){
		
		return new ResponseEntity<>(principal!= null ? principal : "not logged in", HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> reg(@RequestBody User user){
		BCryptPasswordEncoder bcr = new BCryptPasswordEncoder();
		log.info("{}",user);
		user.setPwd(bcr.encode(user.getPwd()));
		user.setGrade(10);
		int res = usv.register(user);
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}
	
}
