package com.nicosandoval.ArquitecturaHexagonal.application.usecases;

import com.nicosandoval.ArquitecturaHexagonal.domain.models.Task;
import com.nicosandoval.ArquitecturaHexagonal.domain.ports.in.UpdateTaskUsecase;
import com.nicosandoval.ArquitecturaHexagonal.domain.ports.out.TaskRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class UpdateTaskUseCaseImpl implements UpdateTaskUsecase {
    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Optional<Task> updateTask(Long id, Task task) {
        return taskRepositoryPort.updateTask(task);
    }
}
