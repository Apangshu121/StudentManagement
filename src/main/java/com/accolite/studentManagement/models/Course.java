package com.accolite.studentManagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "course_management_table")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int course_id;

    String course_name;

    int course_duration;

    boolean deleted;

    @JsonIgnore
    @ManyToMany(mappedBy = "courses")
    Set<User> users = new HashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCourse_duration() {
        return course_duration;
    }

    public void setCourse_duration(int course_duration) {
        this.course_duration = course_duration;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", course_name='" + course_name + '\'' +
                ", course_duration=" + course_duration +
                ", deleted=" + deleted +
                ", users=" + users +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return course_id == course.course_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course_id);
    }
}
