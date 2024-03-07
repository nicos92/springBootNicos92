package com.nicosandoval.ArquitecturaHexagonal.domain.ports.in;

import com.nicosandoval.ArquitecturaHexagonal.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {
    Optional<Task> getTaskById(Long id);
    List<Task> getAllTasks();
}
