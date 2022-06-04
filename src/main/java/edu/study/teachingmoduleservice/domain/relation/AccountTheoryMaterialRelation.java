package edu.study.teachingmoduleservice.domain.relation;

import edu.study.teachingmoduleservice.domain.study.TaskMaterial;
import edu.study.teachingmoduleservice.domain.study.TheoryMaterial;
import edu.study.teachingmoduleservice.domain.user.UserAccount;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "account_theory_material_relations")
public class AccountTheoryMaterialRelation {
    // TODO create composite key for relationId
    @Id
    private String relationId;

    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private UserAccount student;

    @ManyToOne
    @JoinColumn(name = "theory_material_id")
    private TheoryMaterial theoryMaterial;

    private Float gradeOfTaskComplexity;
}
