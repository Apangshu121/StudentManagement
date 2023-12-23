package com.accolite.studentManagement.serviceImplementation;

import com.accolite.studentManagement.models.Course;
import com.accolite.studentManagement.models.Ids;
import com.accolite.studentManagement.models.User;
import com.accolite.studentManagement.repository.CourseRepository;
import com.accolite.studentManagement.repository.UserRepository;
import com.accolite.studentManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserDetails(int id) {
        Optional<User> userOpt = userRepository.findById(id);

        // using get() function we get the employee if it is present
        if(userOpt.isPresent()) {
            return userOpt.get();
        }

        return null;
    }

    @Override
    public User saveUser(User u) {
        return userRepository.save(u);
    }

    @Override
    public boolean deleteUser(int id) {
        boolean res=false;

        Optional<User> userOpt = userRepository.findById(id);

        if(userOpt.isPresent()) {
            userRepository.deleteById(id);
            res=true;
        }
        return res;
    }

    @Override
    public boolean addCourse(Ids ids) {

        boolean check = false;

        Optional<Course> courseOpt = courseRepository.findById(ids.getCourse_id());
        Optional<User> userOpt = userRepository.findById(ids.getUser_id());

        if(courseOpt.isPresent() && userOpt.isPresent())
        {
            Course course = courseOpt.get();
            User user = userOpt.get();
            user.getCourses().add(course);
            userRepository.save(user);

            check=true;
        }
        return check;
    }
}
