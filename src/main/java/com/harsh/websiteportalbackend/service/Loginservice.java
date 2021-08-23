package com.harsh.websiteportalbackend.service;

import java.util.List;
import java.util.Optional;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harsh.websiteportalbackend.model.Student;
import com.harsh.websiteportalbackend.repositry.StudentRepo;

@Service
public class Loginservice {
	private final StudentRepo studentrepo;
	private StrongPasswordEncryptor passwordEncryptor; 

	@Autowired
	public Loginservice(StudentRepo studentrepo) {
		this.studentrepo=studentrepo;
	}
	public String signin(long rollno,String password) {
		passwordEncryptor = new StrongPasswordEncryptor();
		System.out.println(rollno);
		Optional<Student> student = studentrepo.findById(rollno);
		if(!student.isPresent()) {
		//	System.out.println("here");
			return "no";
		}
		Student s=student.get();
		if(passwordEncryptor.checkPassword(password, s.getPassword())){
			return "yes";
		}else {
			return "no";
		}
	}
	public String resetpass(long rollno,String pass){
		//System.out.println(pass);
		passwordEncryptor=new StrongPasswordEncryptor();
		String encrypted=passwordEncryptor.encryptPassword(pass);
		Optional<Student> student = studentrepo.findById(rollno);
		
		if(!student.isPresent()) {
			return "no";
		}
		Student s = student.get();
		s.setPassword(encrypted);
		studentrepo.save(s);
		return "done";
	}
}
