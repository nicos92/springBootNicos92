package com.nicosandoval.ArquitecturaHexagonal.infrastructure.config;

import com.nicosandoval.ArquitecturaHexagonal.application.services.TaskService;
import com.nicosandoval.ArquitecturaHexagonal.application.usecases.*;
import com.nicosandoval.ArquitecturaHexagonal.domain.ports.in.CreateTaskUseCase;
import com.nicosandoval.ArquitecturaHexagonal.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.nicosandoval.ArquitecturaHexagonal.domain.ports.out.ExternalServicePort;
import com.nicosandoval.ArquitecturaHexagonal.domain.ports.out.TaskRepositoryPort;
import com.nicosandoval.ArquitecturaHexagonal.infrastructure.adapters.ExternalServiceAdapter;
import com.nicosandoval.ArquitecturaHexagonal.infrastructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase){
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase
        );
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter){
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort){
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort(){
        return new ExternalServiceAdapter();
    }
}
