package edu.study.teachingmoduleservice.controller.thymeleaf;

import edu.study.teachingmoduleservice.domain.relation.AccountTaskRelation;
import edu.study.teachingmoduleservice.domain.study.TaskMaterial;
import edu.study.teachingmoduleservice.domain.user.User;
import edu.study.teachingmoduleservice.dto.FeedbackDto;
import edu.study.teachingmoduleservice.services.TaskServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FeedbackController {

    private final TaskServiceImpl taskService;

    public FeedbackController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/courses/task-feedback/{accountTaskRelationId}")
    public String showResult(
            Model model,
            @AuthenticationPrincipal User user,
            @PathVariable String accountTaskRelationId) {

        AccountTaskRelation relation = taskService.findRelationById(accountTaskRelationId);
        model.addAttribute("task", relation.getTask());
        model.addAttribute("account", user.getAccount());
        model.addAttribute("feedback", new FeedbackDto());
        model.addAttribute("mark", relation.getGradeOfStudent());

        return "task-passing-result";
    }
    @PostMapping("/courses/task-feedback/{taskId}")
    public String answerTasks(
            @AuthenticationPrincipal User user,
            @ModelAttribute("answer") FeedbackDto feedbackDto,
            @PathVariable String taskId) {

        taskService.graduateTaskComplexity(feedbackDto.getGradeOfComplexity(), taskId, user);
        return "redirect:/home";
    }
}
