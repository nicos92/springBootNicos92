package com.nicosandoval.ArquitecturaHexagonal.infrastructure.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nicosandoval.ArquitecturaHexagonal.domain.models.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class TaskEntiy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private LocalDateTime creationDate;

    private boolean completed;

    public static TaskEntiy fromDomainModel(Task task){
        return new TaskEntiy(task.getId(), task.getTitle(), task.getDescription(), task.getCreationDate(), task.isCompleted());
    }

    public Task toDomainModel(){
        return new Task(id, title, description, creationDate, completed);
    }
}
