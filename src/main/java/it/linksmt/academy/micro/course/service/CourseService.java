package it.linksmt.academy.micro.course.service;

import it.linksmt.academy.micro.course.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAll();

    Course getCourse(Long id);

    Course insert(Course course);

    Course update(Course course);

    void delete(Long id);
}
