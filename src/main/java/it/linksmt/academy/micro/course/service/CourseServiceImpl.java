package it.linksmt.academy.micro.course.service;

import it.linksmt.academy.micro.course.exception.CourseNotFoundException;
import it.linksmt.academy.micro.course.model.Course;
import it.linksmt.academy.micro.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourse(Long id) {
        return courseRepository.findById(id).orElseThrow( () -> new CourseNotFoundException("Not Found id "+id));
    }

    @Override
    public Course insert(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(Course course) {

        return courseRepository.findById(course.getId())
                .map( s -> {
                    s.setDescription(course.getDescription());
                    return courseRepository.save(s);
                })
                .orElseThrow(() -> new CourseNotFoundException("Not found ID: "+course.getId()));
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }
}
