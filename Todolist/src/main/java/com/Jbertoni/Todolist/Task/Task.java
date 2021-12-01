package com.Jbertoni.Todolist.Task;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;



@Entity(name = "Task")
@Table(name = "task")
@DynamicInsert
public class Task {

	@Id
	@SequenceGenerator(
			name = "task_sequence",
			sequenceName = "task_sequence",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator ="task_sequence")
	@Column(
			name = "task_id")
	private Integer id;
	
	@Column(
			name = "task_content",
			nullable = false,
			columnDefinition = "TEXT")
	private String taskContent;
	
	@Column(
			name = "marked",
			columnDefinition = "BOOLEAN")
	@ColumnDefault("false")
	private Boolean isMarked;
	
	public Task(Integer id, String taskContent, Boolean isMarked) {
		this.id = id;
		this.taskContent = taskContent;
		this.isMarked = isMarked;
	}
	public Task() {}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTaskContent() {
		return taskContent;
	}
	
	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}
	
	public Boolean getIsMarked() {
		return isMarked;
	}
	
	public void setIsMarked(Boolean isMarked) {
		this.isMarked = isMarked;
	}
	
	@Override
	public String toString() {
		 return 
			        "{ " + 
			            "id='" + id + "'" +
			            ", itemContent='" + taskContent + "'" +
			            ", isMarked='" + isMarked + "'" + 
			        "}";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
