package com.RestAPI.RestAPIDemo.Controller;
import com.RestAPI.RestAPIDemo.entities.Courses;
import com.RestAPI.RestAPIDemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class courseController {
    @Autowired
    private CourseService courseservice;

    @GetMapping("/home")
    public String home(){
        return "Welcome to RestAPI Demo";
    }
    @GetMapping("/courses")
    public List<Courses> getCourses(){
        return this.courseservice.getListOfCourses();
    }
    @GetMapping("/courses/{courseId}")
    public Courses getSingleCourse(@PathVariable String courseId){
        return this.courseservice.getCourseByID(Long.parseLong(courseId));
    }
    @PostMapping("/courses")
    public Courses addCourse(@RequestBody Courses course){
        return this.courseservice.addCourse(course);
    }
    @PutMapping("/courses")
    public Courses updateCourse(@RequestBody Courses course){
        return this.courseservice.updateCourse(course);
    }
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try {
            this.courseservice.deletCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
