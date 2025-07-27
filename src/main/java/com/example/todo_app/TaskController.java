package com.example.todo_app;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@GetMapping
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}
	
	@PostMapping
	public Task createTask(@RequestBody Task task) {
		return taskRepository.save(task);
	}
	
	@GetMapping("/{id}")
	public Task getTaskById(@PathVariable Long id) {
		Optional<Task> task = taskRepository.findById(id);
		return task.orElse(null);
	}
	
	@DeleteMapping("/{id}")
	public String deleteTask(@PathVariable Long id) {
		taskRepository.deleteById(id);
		return "Task with ID " +id+ " has been deleted.";
	}
}