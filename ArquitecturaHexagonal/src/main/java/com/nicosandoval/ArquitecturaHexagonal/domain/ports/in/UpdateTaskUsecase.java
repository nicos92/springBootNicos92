package com.nicosandoval.ArquitecturaHexagonal.domain.ports.in;

import com.nicosandoval.ArquitecturaHexagonal.domain.models.Task;

import java.util.Optional;

public interface UpdateTaskUsecase {
    Optional<Task> updateTask(Long id, Task task);
}
