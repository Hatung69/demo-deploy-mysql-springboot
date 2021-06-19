package com.deploy.repo;

import org.springframework.data.repository.CrudRepository;

import com.deploy.enities.Course;

public interface CourseRepo extends CrudRepository<Course, Integer> {

}
