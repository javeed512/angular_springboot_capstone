import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseUrl:string="http://localhost:8080/user"

  constructor(private http:HttpClient) { }
  addUser(userData:User){

    console.log("service" +userData)

     return    this.http.post(this.baseUrl+"/add-user",userData);


  }

  getAllUser(){
    
    return this.http.get<User[]>(this.baseUrl+"/getAll");
    
  }
   updateUser(user:User) {
    return this.http.put<User>(this.baseUrl+"/updateUser",user);
   }

   deleteUser(id:number){
    return this.http.delete(this.baseUrl+"/deleteUser/"+id)
   }

   getUserById(id:number){
    return this.http.get<any>(this.baseUrl+"/get-user/"+id)
  }


 



}
