package com.nicosandoval.ArquitecturaHexagonal.application.usecases;

import com.nicosandoval.ArquitecturaHexagonal.domain.models.Task;
import com.nicosandoval.ArquitecturaHexagonal.domain.ports.in.CreateTaskUseCase;
import com.nicosandoval.ArquitecturaHexagonal.domain.ports.out.TaskRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;
    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }
}
