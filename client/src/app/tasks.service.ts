import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import {Observable} from "rxjs";
import {Task} from './task/task'

@Injectable({
  providedIn: 'root'
})
export class TasksService {
  private url:string = 'http://localhost:8080/api/items';

  constructor(private http: HttpClient) { }

  getTasks(): Observable<Task[]>{
    let prueba = this.http.get<Task[]>(this.url);

    return prueba;
  }

  addTask(task: Task): Observable<Task>{
    return this.http.post<Task>(this.url,task)
  }

  deleteTask(id:string): Observable<{}>{
    const url = `${this.url}/${id}`;
    console.log(url);
    return this.http.delete(url);
  }

  updateTask(task: Task): Observable<Task>{
    const url = `${this.url}/${task.id}/mark-task`;
    return this.http.put<Task>(url,task);
  }
}
