package com.harsh.websiteportalbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.websiteportalbackend.model.Student;
import com.harsh.websiteportalbackend.service.Loggedinservice;

@RestController
@RequestMapping("/user")
public class Loggedincontroller {
	private final Loggedinservice loggedinservice;
	@Autowired
	public Loggedincontroller(Loggedinservice loggedinservice) {
		super();
		this.loggedinservice = loggedinservice;
	}

	@GetMapping("/{rollno}")
	public ResponseEntity<Student> getDetails(@PathVariable("rollno") long rollno){
		Student s=loggedinservice.getdetials(rollno);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	@PostMapping("/update")
	public ResponseEntity<Student> updateDetails(@RequestBody Student student){
		return new ResponseEntity<>(loggedinservice.updatedetails(student),HttpStatus.OK);
	}
}
