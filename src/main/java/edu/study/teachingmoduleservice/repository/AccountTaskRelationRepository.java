package edu.study.teachingmoduleservice.repository;

import edu.study.teachingmoduleservice.domain.relation.AccountCourseRelation;
import edu.study.teachingmoduleservice.domain.relation.AccountTaskRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountTaskRelationRepository extends JpaRepository<AccountTaskRelation, String> {

}
