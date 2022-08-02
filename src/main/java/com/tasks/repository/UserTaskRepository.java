package com.tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tasks.model.UserTasks;
import com.tasks.model.UserTasksId;

public interface UserTaskRepository extends JpaRepository<UserTasks, UserTasksId>{

	List<UserTasks> findAllByUserId(Integer userId);
	
	void deleteByTaskId(Integer taskId);
	
	@Modifying
    @Query("update UserTasks u set u.taskDone = :taskDone where u.taskId = :taskId")
    int updateTaskStatus(@Param("taskDone") Integer taskDone, @Param("taskId") Integer taskId);
	
}
