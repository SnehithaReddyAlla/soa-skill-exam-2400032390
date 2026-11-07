package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.dto.TaskRequest;
import com.klef.soa.entity.Task;
import com.klef.soa.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/task")
public class TaskController 
{
	@Autowired
	private TaskService service;
	
	@GetMapping("/")
	public String home()
	{
		return "Task Management System";
	}
	
	@PostMapping("/add")
	public ResponseEntity<Task> insertTask(@Valid @RequestBody TaskRequest request)
	{
		Task task = service.insertTask(request);
		return ResponseEntity.status(201).body(task);
	}
	
	@GetMapping("/displayall")
	public ResponseEntity<List<Task>> displayallTasks()
	{
		List<Task> tasks = service.displayAllTasks();
		return ResponseEntity.status(200).body(tasks);
	}
	
	@GetMapping("/display/{id}")
	public ResponseEntity<?> displayTaskById(@PathVariable Long id)
	{
		Task t = service.displayById(id);
		if(t != null)
		{
			return ResponseEntity.ok().body(t);
		}
		else
		{
			return ResponseEntity.ok().body("Task Id Not Found");
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateTaskById(@PathVariable Long id,@RequestBody TaskRequest request)
	{
		Task t = service.updateTask(id, request);
		if(t != null)
		{
			return ResponseEntity.ok().body(t);
		}
		else
		{
			return ResponseEntity.ok().body("Task Id Not Found To Update");
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTaskById(@PathVariable Long id)
	{
		String output = service.deleteTask(id);
		return ResponseEntity.ok().body(output);
	}
	
	@GetMapping("/displaybyname/{name}")
	public ResponseEntity<List<Task>> displayTaskByName(@PathVariable String name)
	{
		List<Task> tasks = service.displayByName(name);
		return ResponseEntity.ok().body(tasks);
	}
	
	@GetMapping("/displaybytype/{type}")
	public ResponseEntity<List<Task>> displayTaskByType(@PathVariable String type)
	{
		List<Task> tasks = service.displayByType(type);
		return ResponseEntity.ok().body(tasks);
	}
}
