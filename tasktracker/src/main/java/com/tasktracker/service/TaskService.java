package com.tasktracker.service;

import com.tasktracker.dto.TaskUpdateDto;
import com.tasktracker.entity.Tasks;

public interface TaskService {

    Tasks updateTask(Long id, TaskUpdateDto taskUpdateDto);

}
