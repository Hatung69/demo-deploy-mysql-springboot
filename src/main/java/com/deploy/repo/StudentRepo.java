package com.deploy.repo;

import org.springframework.data.repository.CrudRepository;

import com.deploy.enities.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> {

}
