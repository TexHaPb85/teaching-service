package edu.study.teachingmoduleservice.controller.rest;

import edu.study.teachingmoduleservice.domain.study.Course;
import edu.study.teachingmoduleservice.services.CourseServiceImpl;
import edu.study.teachingmoduleservice.services.TaskServiceImpl;
import edu.study.teachingmoduleservice.services.TheoryServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest/courses")
public class CourseControllerREST {

    private final CourseServiceImpl courseService;
    private final TaskServiceImpl taskService;
    private final TheoryServiceImpl theoryService;

    public CourseControllerREST(CourseServiceImpl courseService, TaskServiceImpl taskService, TheoryServiceImpl theoryService) {
        this.courseService = courseService;
        this.taskService = taskService;
        this.theoryService = theoryService;
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("{courseId}")
    public Course getCourseById(@PathVariable String courseId){
        return courseService.getCourseById(courseId);
    }


}
