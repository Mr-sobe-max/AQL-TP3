package org.example.com.PARTIE2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> findTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }
}