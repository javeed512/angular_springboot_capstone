import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Admin } from './admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  baseUrl:string="http://localhost:8080/admin"

  constructor(private http:HttpClient) { }

  addAdmin(adminData:Admin){

    console.log("service" +adminData)

     return    this.http.post(this.baseUrl+"/add-admin",adminData);


  }
getAllAdmin(){
  return this.http.get<Admin[]>(this.baseUrl+"/getAll");
}

}
