import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeserviceService {

  constructor() { }

 employees() {
  return[
      { id: 1, name: 'John ', age: 30, designation: 'Manager', address: 'bgr 1st cross' },
      { id: 2, name: 'Smith', age: 28, designation: 'Developer', address: 'hsr apts' },
      { id: 3, name: 'Jack', age: 30, designation: 'Tech Support', address: 'hsr bda cmplx'},
      { id: 4, name: 'Jord', age: 45, designation: 'Tech Lead', address: 'bllr 2nd street'},
      { id: 5, name: 'Sparrow', age: 35, designation: 'Developer', address: 'Texux US'},
      { id: 6, name: 'Neil', age: 50, designation: 'QA', address: 'Londan'},
      { id: 7, name: 'Harry', age: 20, designation: 'DataBase', address: 'Canada'},
      { id: 8, name: 'Messi', age: 42, designation: 'Analyst', address: 'Atlaanta'},
      { id: 9, name: 'Rogue', age: 32, designation: 'Api Dev', address: 'Spain'},
      { id: 10, name: 'Elson', age: 56, designation: 'Admin', address: 'Australia'},
  ]
 }
}

