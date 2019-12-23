package ru.tropin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tropin.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
