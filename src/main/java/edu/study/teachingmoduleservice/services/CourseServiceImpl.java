package edu.study.teachingmoduleservice.services;

import edu.study.teachingmoduleservice.domain.relation.AccountCourseRelation;
import edu.study.teachingmoduleservice.domain.study.Course;
import edu.study.teachingmoduleservice.domain.user.UserAccount;
import edu.study.teachingmoduleservice.repository.AccountCourseRelationRepository;
import edu.study.teachingmoduleservice.repository.CourseRepository;

import java.time.LocalDateTime;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl {
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseServiceImpl.class);
    private final CourseRepository courseRepository;
    private final AccountCourseRelationRepository relationRepository;

    public CourseServiceImpl(CourseRepository courseRepository, AccountCourseRelationRepository relationRepository) {
        this.courseRepository = courseRepository;
        this.relationRepository = relationRepository;
    }

    public List<Course> getAllCourses() {
        try {
            List<Course> allCourses = courseRepository.findAll();
            LOGGER.debug("getAllCourses method returns all courses:" + allCourses);
            return allCourses;
        } catch (Exception e) {
            LOGGER.error("exception is thrown in method getAllCourses: " + e);
            return Collections.emptyList();
        }
    }

    public void registerUserOnCourse(UserAccount student, String courseId) {
        final Float DEFAULT_GRADE = -1f;
        AccountCourseRelation relation = new AccountCourseRelation();
        relation.setRelationId(courseId + "_" + student.getUserName());
        Course course = courseRepository
                .findById(courseId)
                .orElseThrow(() -> new NoSuchElementException("There no course with id: " + courseId));
        relation.setCourse(course);
        relation.setStudent(student);
        relation.setGradeOfStudent(DEFAULT_GRADE);
        relation.setGradeOfCourseComplexity(DEFAULT_GRADE);
        relation.setRegisteredAt(LocalDateTime.now());
        relationRepository.save(relation);
        List<AccountCourseRelation> all = relationRepository.findAll();
        LOGGER.info("User added course with id " + courseId + " all relations: " + all);
    }

    public AccountCourseRelation getAccountCourseRelation(String courseId, String username) {
        AccountCourseRelation relation = relationRepository
                .findById(courseId + "_" + username.split("[@]")[0])
                .orElseThrow(()-> new NoSuchElementException("There no such relation" + courseId + "_" + username));
        LOGGER.debug("selecting relation: " + relation.getRelationId());
        return relation;
    }
    public List<Course> getCoursesByAccountNane(String accountUsername) {
        List<Course> courses = relationRepository.findRelationsByAccountUsername(accountUsername).stream()
                .map(AccountCourseRelation::getCourse)
                .collect(Collectors.toList());
        LOGGER.debug(accountUsername + " is registered for the following courses " + courses);
        return courses;
    }

    public Course getCourseById(String courseId) {
        try {
            Course course = courseRepository.getById(courseId);
            LOGGER.info("getCourseById method returns the course " + course);
            return course;
        } catch (Exception e) {
            LOGGER.error("exception is thrown in method getCourseById: " + e);
            return null;
        }
    }

    public void addCourse(Course course) {
        try {
            courseRepository.save(course);
            LOGGER.info("addCourse method, saves course with courseId: {}", course.getCourseId());
        } catch (Exception e) {
            LOGGER.error("exception is thrown in method addCourse while saving course with courseId: {}", course.getCourseId());
        }
    }

    public void removeCourse(String courseId) {
        try {
            Course course = courseRepository.findById(courseId).orElseThrow(NoSuchElementException::new);
            courseRepository.delete(course);
            LOGGER.info("removeCourse method, removes course with courseId: {}", courseId);
        } catch (Exception e) {
            LOGGER.error("exception is thrown in method removeCourse while removing course with courseId: {}", courseId);

        }
    }
}
