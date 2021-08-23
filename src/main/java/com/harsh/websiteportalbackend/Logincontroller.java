package com.harsh.websiteportalbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.websiteportalbackend.model.Login;
import com.harsh.websiteportalbackend.service.Loginservice;

@RestController
@RequestMapping("/login")
public class Logincontroller {
	private final Loginservice loginservice;
	@Autowired
	public Logincontroller(Loginservice loginservice) {
		this.loginservice=loginservice;
	}
	@PostMapping("/user")
	public ResponseEntity<?> login(@RequestBody Login login){
		String view=loginservice.signin(login.getRollno(),login.getPassword());
	
		if(view.equals("yes")) {
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	@PostMapping("/forgotpass/{id}")
	public ResponseEntity<?> forgotpass(@PathVariable("id") long rollno,@RequestBody String pass){
		String view=loginservice.resetpass(rollno,pass);
		if(view.equals("done")) {
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
}
