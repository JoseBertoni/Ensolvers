package com.Jbertoni.Todolist.Task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jbertoni.Todolist.Exception.TaskNotFoundException;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/items")
public class TaskController {
     
	private final TaskService taskService;
	
	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping
	public ResponseEntity<List<Task>> getTask(){
		ResponseEntity<List<Task>> responseEntity;
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		List<Task> taskList = this.taskService.getTask();
		
		responseEntity = new ResponseEntity<List<Task>>(taskList, headers, HttpStatus.OK);
	    return responseEntity; 
	}
	
	@PostMapping
	public ResponseEntity<Task> addNewTask(RequestEntity<Task> requestEntity){
		ResponseEntity<Task> responseEntity;
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		Task taskToAdd = requestEntity.getBody();
		Task addedTask = this.taskService.addNewTask(taskToAdd);
		
		responseEntity = new ResponseEntity<Task>(addedTask, headers, HttpStatus.OK);
		return responseEntity;
		
	}
	
	@PutMapping(path = "/{taskId}")
	public ResponseEntity<String> updateTask (@PathVariable("taskId") Integer taskId, RequestEntity<Task> requestEntity) throws TaskNotFoundException{
		ResponseEntity<String> responseEntity;
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		Task taskToUpdate = requestEntity.getBody();
		String taskContentToUpdate = taskToUpdate.getTaskContent();
		
		this.taskService.updateTask(taskId, taskContentToUpdate);
		
		String msg = "Task succesfully updated";
		responseEntity = new ResponseEntity<String>(msg,headers,HttpStatus.OK);
		return responseEntity;
			
	}
	
	
	@DeleteMapping(path = "/{taskId}")
	public ResponseEntity<String> deletedTaskById(@PathVariable("taskId") Integer taskId) throws TaskNotFoundException{
		ResponseEntity<String> responseEntity;
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/json");
		
		this.taskService.deleteTaskById(taskId);
		
		String msg = "Task succesfully deleted ";
		responseEntity = new ResponseEntity<String>(msg,headers,HttpStatus.OK);
		return responseEntity;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping(path = "{taskId}/mark-task" )
	public ResponseEntity<String>markItem(@PathVariable("taskId") Integer taskId, RequestEntity<Task>requestEntity) throws TaskNotFoundException{
		
		ResponseEntity<String>responseEntity;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		Task taskToMark = requestEntity.getBody();
		Boolean isMarked = taskToMark.getIsMarked();
		
		this.taskService.markTask(taskId,isMarked);
		
		String msg = "Item succesfully marked";
		responseEntity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);
		
		return responseEntity;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
