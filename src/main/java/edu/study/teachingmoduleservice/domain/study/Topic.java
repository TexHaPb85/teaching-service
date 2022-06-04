package edu.study.teachingmoduleservice.domain.study;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "topics")
public class Topic implements Serializable {
    @Id
    private String topicId;
    private String description;
    private Float hours;
    private Float complexityValue;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "parent_course_id")
    private Course parentCourse;
    @OneToMany(mappedBy = "parentTopic")
    private List<TheoryMaterial> theoryMaterials;
    @OneToMany(mappedBy = "parentTopic")
    private List<TaskMaterial> taskMaterials;

    @Override
    public String toString() {
        return "Topic{" +
                "topicId='" + topicId + '\'' +
                ", description='" + description + '\'' +
                ", hours=" + hours +
                ", complexityValue=" + complexityValue +
                ", theoryMaterials=" + theoryMaterials +
                ", taskMaterials=" + taskMaterials +
                '}';
    }
}
