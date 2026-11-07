package com.klef.soa.service;

import java.util.List;

import com.klef.soa.dto.TaskRequest;
import com.klef.soa.entity.Task;

public interface TaskService 
{
	Task insertTask(TaskRequest request);
	Task updateTask(Long id,TaskRequest request);
	String deleteTask(Long id);
	List<Task> displayAllTasks();
	Task displayById(Long id);
	List<Task> displayByName(String name);
	List<Task> displayByType(String type);
}
