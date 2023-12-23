package com.accolite.studentManagement.service;

import com.accolite.studentManagement.models.Ids;
import com.accolite.studentManagement.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();
    User getUserDetails(int id);
    User saveUser(User u);
    boolean deleteUser(int id);

    boolean addCourse(Ids ids);
}
