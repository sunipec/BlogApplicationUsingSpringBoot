package com.springBoot.BlogApplication.springbootblogApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.BlogApplication.springbootblogApplication.Entity.Student;

public interface StudentRespository extends JpaRepository<Student, Integer>{

}
