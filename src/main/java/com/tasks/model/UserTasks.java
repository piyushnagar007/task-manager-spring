package com.tasks.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "user_tasks")
@IdClass(UserTasksId.class)
public class UserTasks implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer taskId;

	@Id
	private Integer userId;
	
	@Column
	private Timestamp updatedTimestamp;
	
	@Column(name = "taskName")
	private String taskName;
	
	@Column
	private Integer taskDone;
	
	public UserTasks(Integer userId, Timestamp updatedTimestamp, Integer taskId, String taskName, Integer taskDone) {
		super();
		this.userId = userId;
		this.updatedTimestamp = updatedTimestamp;
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDone = taskDone;
	}
	
	public UserTasks() {
		super();
	}


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Timestamp getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(Timestamp updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Integer getTaskDone() {
		return taskDone;
	}

	public void setTaskDone(Integer taskDone) {
		this.taskDone = taskDone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(taskId, taskName, updatedTimestamp, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserTasks other = (UserTasks) obj;
		return Objects.equals(taskId, other.taskId) && Objects.equals(taskName, other.taskName)
				&& Objects.equals(updatedTimestamp, other.updatedTimestamp) && Objects.equals(userId, other.userId);
	}
	
	
	
	
	
	
	
	
}
