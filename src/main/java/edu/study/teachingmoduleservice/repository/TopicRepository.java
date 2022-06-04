package edu.study.teachingmoduleservice.repository;

import edu.study.teachingmoduleservice.domain.study.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, String> {
}
