package edu.study.teachingmoduleservice.controller.thymeleaf;

import edu.study.teachingmoduleservice.domain.study.TaskMaterial;
import edu.study.teachingmoduleservice.domain.user.User;
import edu.study.teachingmoduleservice.dto.AnswerDto;
import edu.study.teachingmoduleservice.dto.FeedbackDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FeedbackController {
    @PostMapping("/courses/task-feedback/{taskId}")
    public String answerTasks(
            @AuthenticationPrincipal User user,
            @ModelAttribute("answer") FeedbackDto feedbackDto,
            @PathVariable String taskId) {


        System.out.println(feedbackDto + taskId);
        return "redirect:/home";
    }
}
