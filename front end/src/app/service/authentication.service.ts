import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }

  authenticate (username: string, password: string){
    if(username==="admin" && password === '123') {
      sessionStorage.setItem('authenticaterUser', username)
      return true;
    }
    return false;
  }

isUserLoggedIn(){
  let user = sessionStorage.getItem('authenticaterUser')
  return !(user===null)
}

logout(){
  sessionStorage.removeItem('authenticaterUser')
}

}
