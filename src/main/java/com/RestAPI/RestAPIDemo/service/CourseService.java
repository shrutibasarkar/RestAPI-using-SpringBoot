package com.RestAPI.RestAPIDemo.service;

import com.RestAPI.RestAPIDemo.entities.Courses;

import java.util.List;

public interface CourseService {

    public List<Courses> getListOfCourses();

    public Courses getCourseByID(Long courseId);

    public Courses addCourse(Courses course);

    public Courses updateCourse(Courses course);

    public void deletCourse(Long courseId);
}
