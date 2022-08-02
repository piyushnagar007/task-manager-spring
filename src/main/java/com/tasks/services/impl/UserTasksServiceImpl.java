package com.tasks.services.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasks.model.UserTasks;
import com.tasks.repository.UserTaskRepository;
import com.tasks.services.UserTasksService;

@Service
public class UserTasksServiceImpl implements UserTasksService{

	@Autowired
	private UserTaskRepository userTaskRepository;
	
	@Override
	public List<UserTasks> findAll() {
		return (List<UserTasks>) userTaskRepository.findAll();
	}
	
	@Override
	public List<UserTasks> findTasksByUser(Integer userId) {
		return userTaskRepository.findAllByUserId(userId);
	}

	@Override
	public UserTasks insertTask(Map<String,Object> requestBody) {
		Integer userId = (Integer) requestBody.get("userId");
		String taskName = (String) requestBody.get("taskName");
		Timestamp updatedTimestamp = Timestamp.valueOf(LocalDateTime.now());
		return userTaskRepository.save(new UserTasks(userId, updatedTimestamp, null, taskName, 0));
	}

	@Override
	@Transactional
	public void deleteTask(Integer taskId) {
	   userTaskRepository.deleteByTaskId(taskId);
	}

	@Override
	@Transactional
	public void updateTaskStatus(Integer taskId, Integer taskDone) {
		userTaskRepository.updateTaskStatus(taskDone, taskId);
	}

	
	

}
