package com.nicosandoval.ArquitecturaHexagonal.infrastructure.repositories;

import com.nicosandoval.ArquitecturaHexagonal.infrastructure.entities.TaskEntiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTaskRepository extends JpaRepository<TaskEntiy,Long> {
}
