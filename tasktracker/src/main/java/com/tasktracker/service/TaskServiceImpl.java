package com.tasktracker.service;

import com.tasktracker.dto.TaskUpdateDto;
import com.tasktracker.entity.TaskLogs;
import com.tasktracker.entity.Tasks;
import com.tasktracker.repository.TaskLogsRepository;
import com.tasktracker.repository.TasksRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TasksRepository tasksRepository;
    private final TaskLogsRepository taskLogsRepository;

    public TaskServiceImpl(
            TasksRepository tasksRepository,
            TaskLogsRepository taskLogsRepository
    ) {
        this.tasksRepository = tasksRepository;
        this.taskLogsRepository = taskLogsRepository;
    }

    @Transactional
    @Override
    public Tasks updateTask(Long taskId, TaskUpdateDto taskCreationDto) {
        Tasks existingTask = tasksRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + taskId));

        existingTask.setTitle(taskCreationDto.getTitle());
        existingTask.setDescription(taskCreationDto.getDescription());
        existingTask.setDueDate(taskCreationDto.getDueDate());

        Tasks updatedTask = tasksRepository.save(existingTask);

        String changeDescription = String.format(
                "Task updated - Before: [Title: %s, Description: %s, Due Date: %s], " +
                        "After: [Title: %s, Description: %s, Due Date: %s]",
                existingTask.getTitle(), existingTask.getDescription(),
                existingTask.getDueDate(), taskCreationDto.getTitle(),
                taskCreationDto.getDescription(), taskCreationDto.getDueDate()
        );
        TaskLogs taskLog = new TaskLogs(existingTask, changeDescription);
        taskLogsRepository.save(taskLog);


        return updatedTask;
    }
}
