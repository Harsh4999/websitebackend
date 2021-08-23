package com.harsh.websiteportalbackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.websiteportalbackend.model.Student;
import com.harsh.websiteportalbackend.service.Studentservice;

@RestController
@RequestMapping("/student")
public class Studentcontroller {
	
	private final Studentservice studentservice;
	@Autowired
	public Studentcontroller(Studentservice studentservice) {
		this.studentservice = studentservice;
	}
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAll(){
		return new ResponseEntity<>(studentservice.findall(),HttpStatus.OK);
	}
	@GetMapping("/get/{rollno}")
	public ResponseEntity<Student> getOne(@PathVariable("rollno") long rollno){
		return new ResponseEntity<>(studentservice.find(rollno),HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Student> add(@RequestBody Student student){

		return new ResponseEntity<>(studentservice.addStud(student),HttpStatus.CREATED);
	}
	@PutMapping("/update")
	public ResponseEntity<Student> update(@RequestBody Student student){
		return new ResponseEntity<>(studentservice.updateStud(student),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{rollno}")
	public ResponseEntity<?> delete(@PathVariable("rollno") long rollno){
		studentservice.deleteStud(rollno);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
