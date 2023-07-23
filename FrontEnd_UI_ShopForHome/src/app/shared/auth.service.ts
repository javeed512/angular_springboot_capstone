import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  isAdminLoggedIn(){
    return !!localStorage.getItem('token');
  }

  isUserLoggedIn(){
    return !!localStorage.getItem('token');
  }


}
