package edu.study.teachingmoduleservice.repository;


import edu.study.teachingmoduleservice.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}