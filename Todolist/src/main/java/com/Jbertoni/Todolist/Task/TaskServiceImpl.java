package com.Jbertoni.Todolist.Task;

import java.util.List;
import java.util.Objects;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jbertoni.Todolist.Exception.TaskNotFoundException;


@Service
public class TaskServiceImpl implements TaskService{
   
	private final TaskRepository taskRepository;
	
	@Autowired
	public TaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	@Override
	public List<Task>getTask(){
		List<Task> taskList = this.taskRepository.findAll();
		return taskList;
	}
	
	@Override
	public Task addNewTask(Task taskToAdd) {
		Task addedTask = this.taskRepository.save(taskToAdd);
		return addedTask;
	}
	
	@Transactional
	@Override
	public void updateTask(Integer taskId, String taskContent) throws TaskNotFoundException{
		Task taskFinded = this.taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Task Not Found"));
		
		if(taskContent != null && taskContent.length() > 0 && !Objects.equals(taskFinded.getTaskContent(), taskContent)) {
			taskFinded.setTaskContent(taskContent);
		}
	}
	
	@Override
	public void deleteTaskById(Integer taskId) throws TaskNotFoundException{
		
		boolean taskExist = this.taskRepository.existsById(taskId);
		
		if(!taskExist) {
			throw new TaskNotFoundException("Task does not exist");
		}
		
		this.taskRepository.deleteById(taskId);
	}
	
	@Transactional
	@Override
	public void markTask(Integer taskId, Boolean isMarked) throws TaskNotFoundException{
		Task taskFinded = this.taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Task not exist "));
		
		if(isMarked !=  null && !Objects.equals(taskFinded.getIsMarked(), isMarked)) {
			taskFinded.setIsMarked(isMarked);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
