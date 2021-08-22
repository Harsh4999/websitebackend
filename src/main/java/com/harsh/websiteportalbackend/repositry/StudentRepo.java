package com.harsh.websiteportalbackend.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harsh.websiteportalbackend.model.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student,Long>{

}
