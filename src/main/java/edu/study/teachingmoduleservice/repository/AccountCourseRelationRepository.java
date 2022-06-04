package edu.study.teachingmoduleservice.repository;

import edu.study.teachingmoduleservice.domain.relation.AccountCourseRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountCourseRelationRepository extends JpaRepository<AccountCourseRelation, String> {
    @Query("SELECT r FROM AccountCourseRelation r WHERE r.student.userName = :accountUsername")
    List<AccountCourseRelation> findRelationsByAccountUsername(@Param("accountUsername") String accountUsername);
}