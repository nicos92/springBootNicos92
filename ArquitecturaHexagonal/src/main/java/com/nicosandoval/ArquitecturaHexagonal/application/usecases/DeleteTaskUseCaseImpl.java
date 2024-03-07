package com.nicosandoval.ArquitecturaHexagonal.application.usecases;

import com.nicosandoval.ArquitecturaHexagonal.domain.ports.in.DeleteTaskUseCase;
import com.nicosandoval.ArquitecturaHexagonal.domain.ports.out.TaskRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;
    @Override
    public boolean deleteTask(Long id) {
        return taskRepositoryPort.deleteById(id);
    }
}
