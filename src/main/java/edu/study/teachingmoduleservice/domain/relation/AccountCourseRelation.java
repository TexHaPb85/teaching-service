package edu.study.teachingmoduleservice.domain.relation;

import edu.study.teachingmoduleservice.domain.study.Course;
import edu.study.teachingmoduleservice.domain.user.UserAccount;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "account_course_relations")
public class AccountCourseRelation {
    // TODO create composite key for relationId
    @Id
    private String relationId;

    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private UserAccount student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private Float gradeOfStudent;
    private Float gradeOfCourseComplexity;
    private LocalDateTime registeredAt;

    @Override
    public String toString() {
        return "AccountCourseRelation{" +
                "relationId='" + relationId + '\'' +
                ", gradeOfStudent=" + gradeOfStudent +
                ", gradeOfCourseComplexity=" + gradeOfCourseComplexity +
                ", registeredAt=" + registeredAt +
                '}';
    }
}
