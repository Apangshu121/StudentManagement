package com.accolite.studentManagement.controller;

import com.accolite.studentManagement.models.Course;
import com.accolite.studentManagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class courseController {

    @Autowired
    CourseService courseService;

    @GetMapping("{id}")
    public Course getCourseDetails(@PathVariable int id)
    {
        return courseService.getCourseDetails(id);
    }

    @PostMapping("/save")
    public Course saveCourse(@RequestBody Course course)
    {
        return courseService.saveCourse(course);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteCourse(@PathVariable int id)
    {
        return courseService.deleteCourse(id);
    }

    @GetMapping("/")
    public List<Course> getAll()
    {
        return courseService.getAllCourses();
    }

}
