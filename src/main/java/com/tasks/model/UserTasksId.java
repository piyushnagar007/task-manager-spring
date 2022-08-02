package com.tasks.model;

import java.io.Serializable;


public class UserTasksId implements Serializable{
    private Integer userId;
	private Integer taskId;
	
	
	public UserTasksId() {
		super();
	}


	public UserTasksId(Integer userId, Integer taskId) {
		super();
		this.userId = userId;
		this.taskId = taskId;
	}
}
