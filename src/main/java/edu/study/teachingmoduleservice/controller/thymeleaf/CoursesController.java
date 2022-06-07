package edu.study.teachingmoduleservice.controller.thymeleaf;

import edu.study.teachingmoduleservice.domain.relation.AccountCourseRelation;
import edu.study.teachingmoduleservice.domain.study.Course;
import edu.study.teachingmoduleservice.domain.user.User;
import edu.study.teachingmoduleservice.services.CourseServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CoursesController {

    private final CourseServiceImpl courseService;

    public CoursesController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public String coursesPage(Model model) {
        model.addAttribute("allCoursesList", courseService.getAllCourses());
        return "courses";
    }

    @PostMapping("/courses/add")
    public String addCourse(@AuthenticationPrincipal User user, @RequestParam String courseId) {
        courseService.registerUserOnCourse(user.getAccount(), courseId);
        return "redirect:/home";
    }

    @GetMapping("/courses/{courseId}/student/{username}")
        public String courseProgressPage(@AuthenticationPrincipal User user, @PathVariable String courseId, @PathVariable String username, Model model) {
        AccountCourseRelation accountCourseRelation = courseService.getAccountCourseRelation(courseId, username);
        Course course = accountCourseRelation.getCourse();
        model.addAttribute("user", user);
        model.addAttribute("course", course);
        model.addAttribute("relation", accountCourseRelation);
        model.addAttribute("account", accountCourseRelation.getStudent());
        model.addAttribute("courseTitle", course.getCourseId().replace("_", " "));
        return "course-passing";
    }
}

