package com.tasktracker.controller;

import com.tasktracker.dto.TaskUpdateDto;
import com.tasktracker.entity.Tasks;
import com.tasktracker.repository.TasksRepository;
import com.tasktracker.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TasksController {

    private final TasksRepository tasksRepository;

    private final TaskService taskService;

    public TasksController(TasksRepository tasksRepository, TaskService taskService) {
        this.tasksRepository = tasksRepository;
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity<Tasks> createTask(@RequestBody TaskUpdateDto taskCreationDto) {
        Tasks task = new Tasks(
                taskCreationDto.getTitle(),
                taskCreationDto.getDescription(),
                taskCreationDto.getDueDate()
        );
        Tasks savedTask = tasksRepository.save(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Tasks>> getAllTasks() {
        List<Tasks> tasks = tasksRepository.findAll();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Tasks> updateTask(
            @PathVariable Long id,
            @RequestBody @Valid TaskUpdateDto taskUpdateDto
    ) {
        Tasks updatedTask = taskService.updateTask(id, taskUpdateDto);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

}


