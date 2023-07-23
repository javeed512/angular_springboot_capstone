import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../admin';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  constructor(private aservice:AdminService,private router:Router) { }
  uname:string=''
  pwd:string=''

  ngOnInit(): void {

  }
  adminLogin(){
  
    this.aservice.getAllAdmin().subscribe( adminList =>  {

      console.log(adminList);

        adminList.forEach( data => { 

            console.log(data);

         console.log("uname "+this.uname+" password"+this.pwd)

      if(data.email == this.uname && data.password == this.pwd){

          alert("Login Successful!")

           console.log("login success")
           localStorage.setItem('token',"hgdgfjbvjh-dnjdbvjh-klkioubhawgf")
           this.uname=="admin@gmail.com" ? localStorage.setItem('userType','admin') : localStorage.setItem('userType','user')
            this.router.navigate(['admin-page']);

         }
         
        else{
            console.log("Invalid Credentials, Enter valid data")

        }

      });

});  
    

}

}
