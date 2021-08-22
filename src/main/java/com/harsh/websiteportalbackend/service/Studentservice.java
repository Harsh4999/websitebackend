package com.harsh.websiteportalbackend.service;

import java.util.List;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harsh.websiteportalbackend.Exceptions.UserNotFoundException;
import com.harsh.websiteportalbackend.model.Student;
import com.harsh.websiteportalbackend.repositry.StudentRepo;

@Service
public class Studentservice {
	private final StudentRepo studentrepo;
	private StrongPasswordEncryptor passwordEncryptor; 
	@Autowired
	public Studentservice(StudentRepo studentrepo) {
		this.studentrepo=studentrepo;
	}
	public List<Student> findall(){
		return studentrepo.findAll();
	}
	public Student find(long rollno) {
		return studentrepo.findById(rollno).orElseThrow(()->new UserNotFoundException("User by "+rollno+" was not found"));
	}
	
	public Student addStud(Student student) {
		passwordEncryptor = new StrongPasswordEncryptor(); 
		String encryptpass = passwordEncryptor.encryptPassword(student.getPassword());
		student.setPassword(encryptpass);
		int total=student.getEnglish()+student.getMaths()+student.getScience();
		student.setTotal(total);
		return studentrepo.save(student);
	}
	public Student updateStud(Student student) {
		//edge case
		int total=student.getEnglish()+student.getMaths()+student.getScience();
		student.setTotal(total);
		return studentrepo.save(student);
	}
	public void deleteStud(long rollno) {
		studentrepo.deleteById(rollno);
	}
}
