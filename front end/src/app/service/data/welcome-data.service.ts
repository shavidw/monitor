import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'

export class HelloWorldBean{
  constructor(public msg: String){}
}

@Injectable({
  providedIn: 'root'
})
export class WelcomeDataService {

  constructor( private http:HttpClient) { }

  executeHelloWorldBean(){
    return this.http.get<HelloWorldBean>('http://localhost:8080/hello-world-bean')
    // console.log("Bean executed")
  }

  executeHelloWorldWithPathVariable(name: String){
    return this.http.get<HelloWorldBean>(`http://localhost:8080/hello-world/path-variable/${name}`)
    // console.log("Bean executed")
  }
}
