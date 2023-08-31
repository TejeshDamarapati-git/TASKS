import { Component, OnInit } from '@angular/core';
import { EmployeeserviceService } from './employeeservice.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers:[EmployeeserviceService]

})
export class AppComponent {
  title = 'EMPLOYEE DETAILS';
  
  employees:any;

  constructor(private employeeservice:EmployeeserviceService){
    console.log(employeeservice.employees());
    this.employees=employeeservice.employees();
  }

}

