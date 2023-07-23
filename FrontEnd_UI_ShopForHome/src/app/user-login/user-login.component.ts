import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  constructor(private uservice:UserService,private router:Router) { }
  uname:string=''
  pwd:string=''

  ngOnInit(): void {
  }

  userLogin(){
    
      this.uservice.getAllUser().subscribe( userList =>  {

        console.log(userList);
        // alert(userList)

          userList.forEach( data => { 

              console.log(data);

           console.log("uname "+this.uname+" password"+this.pwd)

        if(data.email == this.uname && data.password == this.pwd){

            alert("Login Successful!")

             console.log("login success")

         
             localStorage.setItem('token',"hgdgfjbvjh-dnjdbvjh-klkioubhawgf-uidhrbvsejuhdvjbj-jfdhh")
              this.router.navigate(['user-page',data.id]);

           }
           
          else{

              console.log("Invalid Credentials, Enter valid data")

          }

        });

});  
      

}


      
  }


