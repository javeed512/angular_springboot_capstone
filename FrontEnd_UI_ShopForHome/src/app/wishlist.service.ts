import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Wishlist } from './wishlist';

@Injectable({
  providedIn: 'root'
})
export class WishlistService {

  baseUrl:string="http://localhost:8080/wishlist"

  constructor(private http:HttpClient) { }
  addToWishList(uid:any,pid:any){
    return this.http.get(this.baseUrl+"/add/"+uid+"/"+pid)
  }
  getUserWishlist(uid:any){
    return this.http.get<Wishlist[]>(this.baseUrl+"/get-user-wishlist/"+uid)
  }
  deleteFromWishlist(uid:any,pid:any){
    return this.http.delete(this.baseUrl+"/delete/"+uid+"/"+pid)
  }
}
