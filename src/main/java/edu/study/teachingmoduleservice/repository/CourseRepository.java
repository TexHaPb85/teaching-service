package edu.study.teachingmoduleservice.repository;

import edu.study.teachingmoduleservice.domain.study.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, String> {
}
