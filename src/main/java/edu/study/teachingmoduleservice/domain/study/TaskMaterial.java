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
    @JsonIgnore
    private List<AccountTaskRelation> studentRelationsList;

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setComplexityValue(Float complexityValue) {
        this.complexityValue = complexityValue;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public void setParentTopic(Topic parentTopic) {
        this.parentTopic = parentTopic;
    }

    public void setStudentRelationsList(List<AccountTaskRelation> studentRelationsList) {
        this.studentRelationsList = studentRelationsList;
    }

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
