import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Alert } from 'src/app/temp/temp.component';

@Injectable({
  providedIn: 'root'
})
export class AlertDataService {

  constructor(
    private http: HttpClient
  ) { }

  retrieveAllAlerts(username: String){
    return this.http.get<Alert[]>(`http://localhost:8080/alerts`)
    // console.log("Bean executed")
  }
  
}
