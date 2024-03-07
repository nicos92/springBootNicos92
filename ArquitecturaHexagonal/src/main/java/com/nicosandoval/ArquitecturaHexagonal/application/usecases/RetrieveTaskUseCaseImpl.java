package com.nicosandoval.ArquitecturaHexagonal.application.usecases;

import com.nicosandoval.ArquitecturaHexagonal.domain.models.Task;
import com.nicosandoval.ArquitecturaHexagonal.domain.ports.in.RetrieveTaskUseCase;
import com.nicosandoval.ArquitecturaHexagonal.domain.ports.out.ExternalServicePort;
import com.nicosandoval.ArquitecturaHexagonal.domain.ports.out.TaskRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;
    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepositoryPort.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepositoryPort.findAllTask();
    }
}
