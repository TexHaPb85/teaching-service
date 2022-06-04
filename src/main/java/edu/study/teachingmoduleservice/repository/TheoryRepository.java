package edu.study.teachingmoduleservice.repository;

import edu.study.teachingmoduleservice.domain.study.TheoryMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheoryRepository extends JpaRepository<TheoryMaterial, String> {
}
