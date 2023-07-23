import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  userToUpdate:User={
    id: 0,
    name: '',
    email: '',
    password: '',
    phone: 0
  }
  id:any

  constructor(private uservice:UserService,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.paramMap.get('id');
    this.uservice.getUserById(this.id).subscribe(res=>{
      this.userToUpdate=res
      alert(this.id+" will be updated")
    }

    )
  }
  editUser(data:User){
    this.userToUpdate=data
    this.userToUpdate.id=this.id
    this.uservice.updateUser(this.userToUpdate).subscribe(res=>{
      if(res){
         alert(this.id+" is updated")
      }else
      {
        alert(this.id+" is updated")
      }

    })
  }

}
