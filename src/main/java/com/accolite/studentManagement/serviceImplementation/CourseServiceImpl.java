package com.accolite.studentManagement.serviceImplementation;

import com.accolite.studentManagement.models.Course;
import com.accolite.studentManagement.repository.CourseRepository;
import com.accolite.studentManagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;


    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseDetails(int id) {
        Optional<Course> courseOpt = courseRepository.findById(id);

        // using get() function we get the employee if it is present
        if(courseOpt.isPresent()) {
            return courseOpt.get();
        }

        return null;
    }

    @Override
    public Course saveCourse(Course c) {
        return courseRepository.save(c);
    }

    // We cannot delete a course if there are still enrollments referencing the course you're trying to delete
    @Override
    public boolean deleteCourse(int id) {
        boolean res=false;

        Optional<Course> c = courseRepository.findById(id);

        if(c.isPresent()) {
            courseRepository.deleteById(id);
            res=true;
        }
        return res;
    }
}
