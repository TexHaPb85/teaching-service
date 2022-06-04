package edu.study.teachingmoduleservice.services;

import edu.study.teachingmoduleservice.domain.study.Topic;
import edu.study.teachingmoduleservice.repository.TopicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TopicServiceImpl {
    private static final Logger LOGGER = LoggerFactory.getLogger(TopicServiceImpl.class);
    private final TopicRepository topicRepository;

    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> getAllTopics() {
        try {
            LOGGER.info("getAllTopics method returns all topics");
            return topicRepository.findAll();
        } catch (Exception e) {
            LOGGER.error("exception is thrown in method getAllTopics");
            return Collections.emptyList();
        }
    }

    public void addTopic(Topic topic) {
        try {
            topicRepository.save(topic);
            LOGGER.info("addTopic method, saves topic with topicId: {}", topic.getTopicId());
        } catch (Exception e) {
            LOGGER.error("exception is thrown in method addTopic while saving topic with topicId: {}", topic.getTopicId());
        }
    }

    public void removeTopic(String topicId) {
        try {
            Topic topic = topicRepository.findById(topicId).orElseThrow(NoSuchElementException::new);
            topicRepository.delete(topic);
            LOGGER.info("removeTopic method, removes topic with topicId: {}", topicId);
        } catch (Exception e) {
            LOGGER.error("exception is thrown in method removeTopic while removing topic with topicId: {}", topicId);
        }
    }
}
