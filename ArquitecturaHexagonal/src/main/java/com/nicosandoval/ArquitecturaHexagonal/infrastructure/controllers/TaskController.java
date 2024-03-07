package com.nicosandoval.ArquitecturaHexagonal.infrastructure.controllers;

import com.nicosandoval.ArquitecturaHexagonal.application.services.TaskService;
import com.nicosandoval.ArquitecturaHexagonal.domain.models.AdditionalTaskInfo;
import com.nicosandoval.ArquitecturaHexagonal.domain.models.Task;
import com.nicosandoval.ArquitecturaHexagonal.infrastructure.entities.TaskEntiy;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task createdTask = taskService.createTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId){
        return taskService.getTaskById(taskId)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task updateTask){
        return taskService.updateTask(taskId,updateTask)
                .map( task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId){
        if (taskService.deleteTask(taskId)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{taskId}/additionalInfo")
    public ResponseEntity<AdditionalTaskInfo> getAdditionalTaskInfo(@PathVariable Long taskId){
        AdditionalTaskInfo additionalTaskInfo = taskService.getAdditionalTaskInfo(taskId);
        return new ResponseEntity<>(additionalTaskInfo, HttpStatus.OK);
    }

}
