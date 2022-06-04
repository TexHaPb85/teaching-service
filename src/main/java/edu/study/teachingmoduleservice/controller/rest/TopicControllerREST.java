package edu.study.teachingmoduleservice.controller.rest;

import edu.study.teachingmoduleservice.domain.study.Topic;
import edu.study.teachingmoduleservice.services.TopicServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest/topics")
public class TopicControllerREST {
    private final TopicServiceImpl topicService;

    public TopicControllerREST(TopicServiceImpl topicService) {
        this.topicService = topicService;
    }
    @GetMapping
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }
}
