import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserGuard implements CanActivate {

  constructor(private auth : AuthService,private router:Router){}
  canActivate() {
    if(this.auth.isUserLoggedIn()){
      return true;
   }
   alert("Please Sign in as User")
      this.router.navigate(['user-login'])
      return false;
  }
  
}
