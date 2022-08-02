package com.tasks.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.model.UserTasks;
import com.tasks.services.UserTasksService;

@RestController
public class UserTasksController {

	@Autowired
	UserTasksService userTaskService;
	
	@GetMapping("/tasks")
	public List<UserTasks> fetchTasks() {
		List<UserTasks> taskList = null;
		try {
			taskList = userTaskService.findAll();
		}catch(Exception e) {
			System.out.println("Exception:=" + e);
		}
		return taskList;
	}
	
	@GetMapping("/tasks/{userId}")
	public List<UserTasks> fetchTasksbyUser(@PathVariable("userId") Integer userId) {
		List<UserTasks> taskList = null;
		try {
			taskList = userTaskService.findTasksByUser(userId);
		}catch(Exception e) {
			System.out.println("Exception:=" + e);
		}
		return taskList;
	}
	
	@PostMapping("/tasks")
	public UserTasks addTask( @RequestBody Map<String,Object> body) {
		return userTaskService.insertTask(body);
	}
	
	@PatchMapping("/tasks/{taskId}")
	public void updateTaskStatus(@PathVariable("taskId") Integer taskId, @RequestParam("taskDone") Integer taskDone) {
	   userTaskService.updateTaskStatus(taskId, taskDone);
	}
	
	@DeleteMapping("/tasks/{taskId}")
	public void deleteTask(@PathVariable("taskId") Integer taskId) {
		userTaskService.deleteTask(taskId);
	}
}
