
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = ''
  password = ''
  errorMessage = 'Invalid Credentials'
  invalidLogin = false

  //Router
  //Angular.giveMeRouter
  //Dependency Injection
  constructor(private router: Router,
    private authenticationService: AuthenticationService) { }

  ngOnInit() {
  }

  handleLogin() {
    // console.log("this.username");
    // if(this.username==="admin" && this.password === '123') {
    if(this.authenticationService.authenticate(this.username, this.password)) {
      //Redirect to Welcome Page
      this.router.navigate(['welcome',this.username]);
      this.invalidLogin = false
    } else {
      this.invalidLogin = true
    }
  }

  handleReg() {
    // console.log("this.username");
    
      this.router.navigate(['reg']);
      
  }



  
  // handleBasicAuthLogin() {
  //   // console.log(this.username);
  //   //if(this.username==="in28minutes" && this.password === 'dummy') {
  //   this.basicAuthenticationService.executeAuthenticationService(this.username, this.password)
  //       .subscribe(
  //         data => {
  //           console.log(data)
  //           this.router.navigate(['welcome', this.username])
  //           this.invalidLogin = false      
  //         },
  //         error => {
  //           console.log(error)
  //           this.invalidLogin = true
  //         }
  //       )
  // }

  // handleJWTAuthLogin() {
  //   this.basicAuthenticationService.executeJWTAuthenticationService(this.username, this.password)
  //       .subscribe(
  //         data => {
  //           console.log(data)
  //           this.router.navigate(['welcome', this.username])
  //           this.invalidLogin = false      
  //         },
  //         error => {
  //           console.log(error)
  //           this.invalidLogin = true
  //         }
  //       )
  // }

}