package com.nicosandoval.ArquitecturaHexagonal.domain.ports.out;

import com.nicosandoval.ArquitecturaHexagonal.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPort {
    Task save(Task task);
    Optional<Task> findById(Long id);
    List<Task> findAllTask();
    Optional<Task> updateTask(Task task);
    boolean deleteById(Long id);
}
