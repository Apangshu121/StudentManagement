package com.accolite.studentManagement.service;

import com.accolite.studentManagement.models.Course;
import com.accolite.studentManagement.models.Ids;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseDetails(int id);
    Course saveCourse(Course c);
    boolean deleteCourse(int id);
}
