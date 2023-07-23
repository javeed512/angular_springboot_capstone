import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../admin';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private aservice:AdminService, private route:Router) { }
  admin:Admin={
    id: 0,
    email: '',
    password: ''
  }

  ngOnInit(): void {
  }
  addAdmin(data:Admin){
    this.admin=data
    this.aservice.addAdmin(this.admin).subscribe(res=>{
     if(res) alert("admin added successfully")
    },(err)=>{
      alert("admin added successfully. Now Log in!!")
      

    })

  }

}
