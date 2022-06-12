package edu.study.teachingmoduleservice.domain.study;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.study.teachingmoduleservice.domain.relation.AccountCourseRelation;
import edu.study.teachingmoduleservice.domain.relation.AccountTaskRelation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "task_materials")
public class TaskMaterial implements Serializable {
    @Id
    private String taskId;
    private String question;
    private String answer;
    private Float complexityValue;

    @Enumerated(EnumType.STRING)
    private TaskType taskType;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "paren_topic_id")
    private Topic parentTopic;

    @OneToMany(mappedBy = "task")
    private List<AccountTaskRelation> studentRelationsList;

    @Override
    public String toString() {
        return "TaskMaterial{" +
                "taskId='" + taskId + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", complexityValue=" + complexityValue +
                '}';
    }
}
