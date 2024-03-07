package com.nicosandoval.ArquitecturaHexagonal.infrastructure.repositories;

import com.nicosandoval.ArquitecturaHexagonal.domain.models.Task;
import com.nicosandoval.ArquitecturaHexagonal.domain.ports.out.TaskRepositoryPort;
import com.nicosandoval.ArquitecturaHexagonal.infrastructure.entities.TaskEntiy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {

    private final JpaTaskRepository jpaTaskRepository;
    @Override
    public Task save(Task task) {
        TaskEntiy taskEntiy = TaskEntiy.fromDomainModel(task);
        TaskEntiy savedTaskEntity = jpaTaskRepository.save(taskEntiy);
        return savedTaskEntity.toDomainModel();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaTaskRepository.findById(id).map(TaskEntiy::toDomainModel);
    }

    @Override
    public List<Task> findAllTask() {
        return jpaTaskRepository.findAll().stream().map(TaskEntiy::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public Optional<Task> updateTask(Task task) {
        if (jpaTaskRepository.existsById(task.getId())){
            TaskEntiy taskEntiy = TaskEntiy.fromDomainModel(task);
            TaskEntiy updateTaskEntity = jpaTaskRepository.save(taskEntiy);
            return Optional.of(updateTaskEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaTaskRepository.existsById(id)){
            jpaTaskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
