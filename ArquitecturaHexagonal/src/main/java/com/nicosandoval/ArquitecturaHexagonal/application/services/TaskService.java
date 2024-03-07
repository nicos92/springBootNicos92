package com.nicosandoval.ArquitecturaHexagonal.application.services;

import com.nicosandoval.ArquitecturaHexagonal.domain.models.AdditionalTaskInfo;
import com.nicosandoval.ArquitecturaHexagonal.domain.models.Task;
import com.nicosandoval.ArquitecturaHexagonal.domain.ports.in.*;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
public class TaskService implements CreateTaskUseCase, RetrieveTaskUseCase, UpdateTaskUsecase, DeleteTaskUseCase, GetAdditionalTaskInfoUseCase {

    private final CreateTaskUseCase createTaskUseCase;
    private final RetrieveTaskUseCase retrieveTaskUseCase;
    private final UpdateTaskUsecase updateTaskUsecase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;
    @Override
    public Task createTask(Task task) {
        return createTaskUseCase.createTask(task);
    }

    @Override
    public boolean deleteTask(Long id) {
        return deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(id);
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return retrieveTaskUseCase.getTaskById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return retrieveTaskUseCase.getAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task task) {
        return updateTaskUsecase.updateTask(id, task);
    }
}
