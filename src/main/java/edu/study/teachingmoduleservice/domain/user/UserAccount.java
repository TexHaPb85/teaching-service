package edu.study.teachingmoduleservice.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.study.teachingmoduleservice.domain.relation.AccountCourseRelation;
import edu.study.teachingmoduleservice.domain.relation.AccountTaskRelation;
import edu.study.teachingmoduleservice.domain.relation.AccountTheoryMaterialRelation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_accounts")
public class UserAccount {
    @Id
    private String userName;
    private Float rateValue;

    @OneToOne(mappedBy = "account")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "student")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<AccountCourseRelation> courseRelationsList;

    @OneToMany(mappedBy = "student")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<AccountTheoryMaterialRelation> theoryMaterialRelationList;

    @OneToMany(mappedBy = "student")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<AccountTaskRelation> accountTaskRelationsList;

    @Override
    public String toString() {
        return "UserAccount{" +
                "userName='" + userName + '\'' +
                ", rateValue=" + rateValue +
                ", courseRelationsList=" + courseRelationsList +
                '}';
    }
}
