package com.accolite.studentManagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "user_management_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int user_id;

    String user_name;

    @Enumerated(EnumType.STRING)
    User_type user_type;

    String user_contactNumber;

    String user_password;

    boolean deleted;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "enrollments", joinColumns = @JoinColumn(name = "usr_id"), inverseJoinColumns = @JoinColumn(name = "course_id"), uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "course_id"}))
    Set<Course> courses = new HashSet<>();

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public User_type getUser_type() {
        return user_type;
    }

    public void setUser_type(User_type user_type) {
        this.user_type = user_type;
    }

    public String getUser_contactNumber() {
        return user_contactNumber;
    }

    public void setUser_contactNumber(String user_contactNumber) {
        this.user_contactNumber = user_contactNumber;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_type=" + user_type +
                ", user_contactNumber='" + user_contactNumber + '\'' +
                ", user_password='" + user_password + '\'' +
                ", deleted=" + deleted +
                ", courses=" + courses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return user_id == user.user_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id);
    }
}
