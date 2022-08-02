package com.tasks.services;

import java.util.List;
import java.util.Map;

import com.tasks.model.UserTasks;

public interface UserTasksService {
	
	List<UserTasks> findAll();
	
	List<UserTasks> findTasksByUser(Integer userId);
	
	UserTasks insertTask(Map<String,Object> requestBody);
	
	void updateTaskStatus(Integer taskId, Integer taskDone);
	
	void deleteTask(Integer taskId);
}
