package com.Jbertoni.Todolist.Task;

import java.util.List;

import com.Jbertoni.Todolist.Exception.TaskNotFoundException;

public interface TaskService {

	public List<Task> getTask();
	
	public Task addNewTask(Task taskToAdd);
	
	public void updateTask(Integer taskId, String taskContent) throws TaskNotFoundException;
	
	public void deleteTaskById(Integer taskId) throws TaskNotFoundException;
	
	public void markTask(Integer taskId, Boolean isMarked) throws TaskNotFoundException;
	
}
