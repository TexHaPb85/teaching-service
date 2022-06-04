package edu.study.teachingmoduleservice.controller.thymeleaf;

import edu.study.teachingmoduleservice.domain.user.User;
import edu.study.teachingmoduleservice.services.CourseServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HomeController {

    private final CourseServiceImpl courseService;

    public HomeController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/home")
    public String homePage(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        model.addAttribute("account", user.getAccount());
        model.addAttribute("userCourses", courseService.getCoursesByAccountNane(user.getAccount().getUserName()));
        return "home";
    }

    @GetMapping("/courses/open")
    public String openUsersCourse(@AuthenticationPrincipal User user, @RequestParam String courseId) {
        return "redirect:/courses/" + courseId + "/sudent/" + user.getAccount().getUserName();
    }
}
