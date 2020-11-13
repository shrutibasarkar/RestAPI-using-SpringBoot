package com.RestAPI.RestAPIDemo.dao;

import com.RestAPI.RestAPIDemo.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Courses,Long> {
}
