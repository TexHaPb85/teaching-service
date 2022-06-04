package edu.study.teachingmoduleservice.domain.study;

import edu.study.teachingmoduleservice.domain.relation.AccountCourseRelation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "courses")
public class Course implements Serializable {
    @Id
    private String courseId;
    private String description;
    private Float hours;
    private Float complexityValue;

    @OneToMany(mappedBy = "parentCourse")
    private List<Topic> topics;

    @OneToMany(mappedBy = "course")
    private List<AccountCourseRelation> studentRelationsList;
}
