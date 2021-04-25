import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HelloWorldBean, WelcomeDataService } from '../service/data/welcome-data.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  welcomeMsg: String =""
  name: String=""

  constructor(private router: ActivatedRoute,
    private service: WelcomeDataService) { }

  ngOnInit(): void {
    // console.log(this.router.snapshot.params['name'])
    this.name=this.router.snapshot.params['name']

    this.getWelcomeMsgWithParameter()
  }

  getWelcomeMsg(){
    // console.log("clicked")
    // console.log(this.service.executeHelloWorldBean())
    this.service.executeHelloWorldBean().subscribe(
      response => this.handleSuccessfulResponse(response)
      
    );
  }

  getWelcomeMsgWithParameter(){
    // console.log("clicked")
    // console.log(this.service.executeHelloWorldBean())
    this.service.executeHelloWorldWithPathVariable(this.name).subscribe(
      response => this.handleSuccessfulResponse(response)
      
    );
  }

  handleSuccessfulResponse(response: HelloWorldBean){
    this.welcomeMsg=response.msg;
  }

  updateAlertType(){
    
  }

}
