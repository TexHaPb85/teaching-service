package edu.study.teachingmoduleservice.repository;

import edu.study.teachingmoduleservice.domain.study.TaskMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskMaterial, String> {
//    List<TaskMaterial> findTaskMaterialsByTopic(String topicId);
}
