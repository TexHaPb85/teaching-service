package edu.study.teachingmoduleservice.services;

import edu.study.teachingmoduleservice.domain.relation.AccountTaskRelation;
import edu.study.teachingmoduleservice.domain.study.TaskMaterial;
import edu.study.teachingmoduleservice.domain.study.TaskType;
import edu.study.teachingmoduleservice.domain.user.User;
import edu.study.teachingmoduleservice.domain.user.UserAccount;
import edu.study.teachingmoduleservice.repository.AccountTaskRelationRepository;
import edu.study.teachingmoduleservice.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskServiceImpl.class);
    private final TaskRepository taskRepository;

    private final UserServiceImpl userService;
    private final AccountTaskRelationRepository accountTaskRelationRepository;

    public TaskServiceImpl(
            TaskRepository taskRepository,
            UserServiceImpl userService, AccountTaskRelationRepository accountTaskRelationRepository) {
        this.taskRepository = taskRepository;
        this.userService = userService;
        this.accountTaskRelationRepository = accountTaskRelationRepository;
    }

    public TaskMaterial getTaskById (String taskId) {
        return taskRepository.getById(taskId);
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

    public TaskMaterial findTopicScopedTaskForUser(String topicId, UserAccount userAccount) {
        List<TaskMaterial> allTopicScopedTasks = taskRepository.findAll().stream()
                .filter(taskMaterial -> topicId.equals(taskMaterial.getParentTopic().getTopicId()))
                .collect(Collectors.toList());

        TaskMaterial taskWithSuitableComplexity = allTopicScopedTasks.get(0);
        Float complexityRateDiffOfSuitableTask = Math
                .abs(taskWithSuitableComplexity.getComplexityValue() - userAccount.getRateValue());

        for (TaskMaterial task : allTopicScopedTasks) {
            Float complexityRateDiff = Math.abs(task.getComplexityValue() - userAccount.getRateValue());
            if (complexityRateDiff < complexityRateDiffOfSuitableTask) {
                complexityRateDiffOfSuitableTask = complexityRateDiff;
                taskWithSuitableComplexity = task;
            }
        }

        return taskWithSuitableComplexity;
    }

    public Float processAnswer(String answer, TaskMaterial task, User user) {
        Long numberOfExecutedTasks = accountTaskRelationRepository.findAll()
                .stream()
                .filter(accountTaskRelation -> user.getAccount().getUserName().equals(accountTaskRelation.getStudent().getUserName()))
                .count();

        Float markForTheTask = 0f;
        TaskType taskType = task.getTaskType();
        switch (taskType) {
            case QUESTION: {
                if (answer.equals(task.getAnswer())) {
                    markForTheTask = 1.0f;
                }
                break;
            }
            case WRITE_CODE: {
                String codeOutput = compileJavaCode(answer);
                if (codeOutput.equals(answer.split("[}]")[1])) {
                    markForTheTask = 1.0f;
                }
                break;
            }
        }

        Float oldRateValue = user.getAccount().getRateValue();
        Float newRateValue = (oldRateValue * numberOfExecutedTasks + task.getComplexityValue() * markForTheTask)
                                          / (numberOfExecutedTasks +1);
        UserAccount updatedAcc = user.getAccount();
        updatedAcc.setRateValue(newRateValue);
        user.setAccount(updatedAcc);
        //userService.saveUser(user); TODO

        AccountTaskRelation accountTaskRelation = new AccountTaskRelation();
        accountTaskRelation.setTask(task);
        accountTaskRelation.setRelationId(task.getTaskId() + "_" + user.getAccount().getUserName());
        accountTaskRelation.setGradeOfTaskComplexity(0f); //TODO
        accountTaskRelation.setDateOfPassing(LocalDateTime.now());
        accountTaskRelation.setGradeOfStudent(markForTheTask);
        accountTaskRelationRepository.save(accountTaskRelation);

        return markForTheTask;
    }

    public void graduateTaskComplexity(Float grade, String taskId, User user) {

    }

    private String compileJavaCode(String code) {
        // Save source in .java file.
        code =  "package test; " +
                "public class Test {" +
                    "public String test() { " +
                        code +
                    "} " +
                "    @Override" +
                "    public String toString() {" +
                "        return test();" +
                "    }" +
                "}";
        File root = new File("/java"); // On Windows running on C:\, this is C:\java.
        File sourceFile = new File(root, "test/Test.java");
        sourceFile.getParentFile().mkdirs();
        try {
            Files.write(sourceFile.toPath(), code.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Compile source file.
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, sourceFile.getPath());

        // Load and instantiate compiled class.
        URLClassLoader classLoader = null;
        try {
            classLoader = URLClassLoader.newInstance(new URL[] { root.toURI().toURL() });
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        Class<?> cls = null; // Should print "hello".
        try {
            cls = Class.forName("test.Test", true, classLoader);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Object instance = null; // Should print "world".
        try {
            instance = cls.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return  instance.toString();
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
