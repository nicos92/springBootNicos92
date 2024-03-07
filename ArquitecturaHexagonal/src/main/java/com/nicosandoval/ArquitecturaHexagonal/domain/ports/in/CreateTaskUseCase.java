package com.nicosandoval.ArquitecturaHexagonal.domain.ports.in;

import com.nicosandoval.ArquitecturaHexagonal.domain.models.Task;

public interface CreateTaskUseCase {

    Task createTask(Task task);
}
