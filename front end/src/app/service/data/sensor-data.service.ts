import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SensorDataService {

  constructor(private http: HttpClient) { }

  getSensorData(sensorId: String){
    return this.http.get<any>(`http://localhost:8080/sensors/TE15`)
    // console.log("Bean executed")
  }
}
