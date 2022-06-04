package edu.study.teachingmoduleservice.repository;

import edu.study.teachingmoduleservice.domain.user.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
}