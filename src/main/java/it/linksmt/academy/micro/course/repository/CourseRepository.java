package it.linksmt.academy.micro.course.repository;

import it.linksmt.academy.micro.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {



}
