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
    return this.http.get<Task[]>(this.url);
  }

  addTask(task: Task): Observable<Task>{
    return this.http.post<Task>(this.url,task)
  }

  deleteTask(id:string): Observable<{}>{
    const url = `${this.url} + ${id}`;
    return this.http.delete(url);
  }

  updateTask(task: Task): Observable<Task>{

    return this.http.put<Task>(this.url,task);
  }
}
