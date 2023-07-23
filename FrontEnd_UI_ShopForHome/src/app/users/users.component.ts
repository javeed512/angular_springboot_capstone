import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  userList:User[]=[]

  constructor(private uservice:UserService,private route:Router) { }

  ngOnInit(): void {
    
      this.uservice.getAllUser().subscribe(res=>{

        console.log(res);
        
      

        res.forEach( data => { 

            console.log(data);

            this.userList.push(data);
    })
      })

      
    }
    updateUser(id:number){
      alert(id+" User will upadate")
    this.route.navigate(['update-user',id])
    }
    
    deleteUser(id:number){

      alert("user will be deleted")

      this.uservice.deleteUser(id).subscribe(res=>{
        alert(id+" user deleted")
      })
    }
  }
  




