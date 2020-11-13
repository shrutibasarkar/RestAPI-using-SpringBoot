package com.RestAPI.RestAPIDemo.service;

import com.RestAPI.RestAPIDemo.entities.Courses;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    List<Courses> courselist;

    public CourseServiceImpl() {
        courselist = new ArrayList<>();
        courselist.add(new Courses(123,"Spring boot", "spring boot RestAPI"));
        courselist.add(new Courses(124,"Spring boot two", "spring boot RestAPI two"));
    }

    @Override
    public List<Courses> getListOfCourses() {
        return courselist;
    }

    @Override
    public Courses getCourseByID(Long courseId) {
        Courses c = null;
        for( Courses course: courselist){
            if (course.getCourseId() == courseId){
                c=course;
                break;
            }
        }

        return c;
    }

    @Override
    public Courses addCourse(Courses course) {
        courselist.add(course);
        return  course;
    }

    @Override
    public Courses updateCourse(Courses course) {
        courselist.forEach(item -> {
            if (item.getCourseId()==course.getCourseId()){
                item.setCourseName(course.getCourseName());
                item.setDescription((course.getDescription()));
            }
        });
        return course;
    }

    @Override
    public void deletCourse(Long courseId) {
        courselist = this.courselist.stream().filter(e->e.getCourseId()!=courseId).collect(Collectors.toList());

    }
}
