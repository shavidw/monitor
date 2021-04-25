import { Component, OnInit } from '@angular/core';
import {Chart} from 'node_modules/chart.js';
import { AlertDataService } from '../service/data/alert-data.service';
import {productSales} from '../data/products';
import { Subscription } from 'rxjs';
import { interval } from 'rxjs';
import { SensorDataService } from '../service/data/sensor-data.service';
// import Chart from 'chart.js/auto';

export class Alert{
  constructor(
    public id: number,
    public sensorId: string,
    public alertDate: Date,
    public reading: String
  ){}
}

@Component({
  selector: 'app-temp',
  templateUrl: './temp.component.html',
  styleUrls: ['./temp.component.css']
})
export class TempComponent implements OnInit {

  productSales: any[] = []; 
  alerts: Alert[];
  mySub: Subscription;
  // = [
  //   new Alert(1,new Date(), new Date(), 'ddd'),
  //   new Alert(2,new Date(), new Date(), 'ddd')
  // ]


  constructor( private service:AlertDataService, private sensorDataService: SensorDataService) {
    this.alerts=[],
    Object.assign(this,{productSales})
    
    this.mySub = interval(2000).subscribe((func => {
      this.onIdSelect(1);
    }))
  }

  ngOnInit(): void {

    this.service.retrieveAllAlerts("admin").subscribe(
      response => {
        console.log(response)
        this.alerts=response;
      }
    )
    
  

}

  onIdSelect(id:number){
    this.sensorDataService.getSensorData('TE').subscribe(
      data => {
        console.log(data);
        this.productSales = data;
      }
    )
  }
  view: any[number] = [700, 370];

  // options
  legend: boolean = true;
  showLabels: boolean = true;
  animations: boolean = true;
  xAxis: boolean = true;
  yAxis: boolean = true;
  showYAxisLabel: boolean = true;
  showXAxisLabel: boolean = true;
  xAxisLabel: string = 'Products';
  yAxisLabel: string = 'Sales';
  timeline: boolean = true;

  colorScheme = {
    domain: ['#704FC4', '#4B852C', '#B67A3D', '#5B6FC8', '#25706F']
  };
}
