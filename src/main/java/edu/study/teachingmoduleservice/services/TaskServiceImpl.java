package edu.study.teachingmoduleservice.services;

import edu.study.teachingmoduleservice.domain.study.TaskMaterial;
import edu.study.teachingmoduleservice.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskServiceImpl {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskServiceImpl.class);
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskMaterial> getTasksByTopicID(String topicID) {
        try {
            LOGGER.info("getAllTasks method returns all tasks");
            return taskRepository.findAll();
        } catch (Exception e){
            LOGGER.error("exception is thrown in method getAllTasks");
            return Collections.emptyList();
        }
    }

    public void addTask(TaskMaterial taskMaterial) {
        try {
            taskRepository.save(taskMaterial);
            LOGGER.info("addTask method, saves task with taskId: {}", taskMaterial.getTaskId());
        } catch (Exception e) {
            LOGGER.error("exception is thrown in method addTask while saving task with taskId: {}", taskMaterial.getTaskId());
        }
    }

    public void removeTask(String taskId) {
        try {
            TaskMaterial taskMaterial = taskRepository.findById(taskId).orElseThrow(NoSuchElementException::new);
            taskRepository.delete(taskMaterial);
            LOGGER.info("removeTask method, removes task with taskId: {}", taskId);
        } catch (Exception e) {
            LOGGER.error("exception is thrown in method removeTask while removing task with taskId: {}", taskId);
        }
    }

}
