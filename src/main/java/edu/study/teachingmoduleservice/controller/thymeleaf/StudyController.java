package edu.study.teachingmoduleservice.controller.thymeleaf;

import edu.study.teachingmoduleservice.domain.study.TaskMaterial;
import edu.study.teachingmoduleservice.domain.study.TaskType;
import edu.study.teachingmoduleservice.domain.study.TheoryMaterial;
import edu.study.teachingmoduleservice.domain.study.Topic;
import edu.study.teachingmoduleservice.domain.user.User;
import edu.study.teachingmoduleservice.dto.AnswerDto;
import edu.study.teachingmoduleservice.dto.FeedbackDto;
import edu.study.teachingmoduleservice.services.TaskServiceImpl;
import edu.study.teachingmoduleservice.services.TheoryServiceImpl;
import edu.study.teachingmoduleservice.services.TopicServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudyController {

    private final TheoryServiceImpl theoryService;
    private final TopicServiceImpl topicService;
    private final TaskServiceImpl taskService;

    public StudyController(TheoryServiceImpl theoryService, TopicServiceImpl topicService, TaskServiceImpl taskService) {
        this.theoryService = theoryService;
        this.topicService = topicService;
        this.taskService = taskService;
    }

    @GetMapping("/courses/topic/{topicId}")
    public String openSelectedTopic(Model model, @AuthenticationPrincipal User user, @PathVariable String topicId) {
        Topic topic = topicService.getTopicById(topicId);
        model.addAttribute("topic", topic);
        model.addAttribute("account", user.getAccount());

        return "topic-passing";
    }

    @GetMapping("/courses/topic/{topicId}/theory-passing")
    public String openTheoryOfTopic(Model model, @AuthenticationPrincipal User user, @PathVariable String topicId) {
        TheoryMaterial theoryById = theoryService.getTheoryByTopic(topicId, user.getAccount());
        model.addAttribute("theory", theoryById);
        model.addAttribute("account", user.getAccount());
        model.addAttribute("feedback", new FeedbackDto());
        
        return "theory-passing";
    }

    @GetMapping("/courses/topic/{topicId}/task-passing")
    public String openTaskOfTopic(Model model, @AuthenticationPrincipal User user, @PathVariable String topicId) {
        TaskMaterial task = taskService.findTopicScopedTaskForUser(topicId, user.getAccount());
        model.addAttribute("task", task);
        model.addAttribute("account", user.getAccount());
        AnswerDto answerDto = new AnswerDto();
        if(task.getTaskType().equals(TaskType.WRITE_CODE)) {
            answerDto.setAnswerStr(task.getQuestion().split("[{}]")[1]);
        }
        model.addAttribute("answer", answerDto);
        model.addAttribute("topicId", topicId);
        model.addAttribute("feedback", new FeedbackDto());

        return "task-passing";
    }

    @PostMapping("/courses/topic/{topicId}/task-passing/{taskId}")
    public void answerTasks(
            Model model,
            @AuthenticationPrincipal User user,
            @ModelAttribute("answer") AnswerDto answer,
            @PathVariable String topicId,
            @PathVariable String taskId) {

        TaskMaterial task = taskService.getTaskById(taskId);
//        Float aFloat = taskService.processAnswer(answer.getAnswerStr(), task, user);
//        System.out.println(aFloat);
    }
}
