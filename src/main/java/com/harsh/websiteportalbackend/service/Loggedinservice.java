package com.harsh.websiteportalbackend.service;

import java.util.Optional;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harsh.websiteportalbackend.Exceptions.UserNotFoundException;
import com.harsh.websiteportalbackend.model.Student;
import com.harsh.websiteportalbackend.repositry.StudentRepo;

@Service
public class Loggedinservice {
	private final StudentRepo studentrepo;
	private StrongPasswordEncryptor passwordEncryptor; 
	@Autowired
	public Loggedinservice(StudentRepo studentrepo) {
		super();
		this.studentrepo = studentrepo;
	}
	public Student getdetials(long rollno){
		return studentrepo.findById(rollno).orElseThrow(()->new UserNotFoundException("User by "+rollno+" was not found"));
	}
	public Student updatedetails(Student student) {
		Optional<Student> student1=studentrepo.findById(student.getRollNo());
		Student s=student1.get();
		s.setUsername(student.getUsername());
		s.setName(student.getName());
		passwordEncryptor = new StrongPasswordEncryptor(); 
		String encryptpass = passwordEncryptor.encryptPassword(student.getPassword());
		s.setPassword(encryptpass);
		return studentrepo.save(s);
	}
	
}
