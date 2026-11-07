package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.dto.TaskRequest;
import com.klef.soa.entity.Task;
import com.klef.soa.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService
{
	@Autowired
	private TaskRepository repo;

	@Override
	public Task insertTask(TaskRequest request) 
	{
		Task task = Task.builder()
				.name(request.getName())
				.type(request.getType())
				.status(request.getStatus())
				.location(request.getLocation())
				.build();
		
		return repo.save(task);
	}

	@Override
	public Task updateTask(Long id,TaskRequest request) 
	{
		Optional<Task> optional = repo.findById(id);
		if(optional.isPresent())
		{
			Task task = optional.get();
			task.setName(request.getName());
			task.setType(request.getType());
			task.setStatus(request.getStatus());
			task.setLocation(request.getLocation());
			
			return repo.save(task);
		}
		else
		{
			return null;
		}
	}

	@Override
	public String deleteTask(Long id) 
	{
		boolean status = repo.existsById(id);
		if(status)
		{
			repo.deleteById(id);
			return "Task Deleted Successfully";
		}
		else 
		{
			return "Task ID Not Found";
		}
	}

	@Override
	public List<Task> displayAllTasks() 
	{
		return repo.findAll();
	}

	@Override
	public Task displayById(Long id) 
	{
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Task> displayByName(String name) 
	{
		
		return repo.findByName(name);
	}

	@Override
	public List<Task> displayByType(String type) 
	{
		return repo.findByType(type);
	}
	
}
