package edu.study.teachingmoduleservice.domain.study;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.study.teachingmoduleservice.domain.relation.AccountTaskRelation;
import edu.study.teachingmoduleservice.domain.relation.AccountTheoryMaterialRelation;
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
@Table(name = "theory_materials")
public class TheoryMaterial implements Serializable {
    @Id
    private String theoryId;
    private String title;
    private String textOfTheoryHTML;
    private Float complexityValue;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "paren_topic_id")
    private Topic parentTopic;

    @OneToMany(mappedBy = "theoryMaterial")
    private List<AccountTheoryMaterialRelation> studentRelationsList;

    @Override
    public String toString() {
        return "TheoryMaterial{" +
                "theoryId='" + theoryId + '\'' +
                ", title='" + title + '\'' +
                ", textOfTheoryHTML='" + textOfTheoryHTML + '\'' +
                ", complexityValue=" + complexityValue +
                '}';
    }
}
