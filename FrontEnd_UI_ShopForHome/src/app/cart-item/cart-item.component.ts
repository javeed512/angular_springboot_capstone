import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartService } from '../cart.service';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-cart-item',
  templateUrl: './cart-item.component.html',
  styleUrls: ['./cart-item.component.css']
})
export class CartItemComponent implements OnInit {
  u_id:any
  p_id:any
  user:User={
    id: 0,
    name: '',
    email: '',
    password: '',
    phone: 0
  }
  grandTotal:any
  products:any=[]
  carts:any
  findTotalPrice() {
    this.grandTotal = 0;
    this.cservice.getCart(this.user.id).subscribe(carts => {

      for(let cart of carts){
        this.grandTotal += cart.totalPrice;

       }
    });
    
  }

  constructor(private router:ActivatedRoute,private cservice:CartService, private pserice:ProductService, private uservice:UserService, private rout:Router) { }

  ngOnInit(): void {

    this.u_id=this.router.snapshot.paramMap.get('uid')
    
    // alert("Welcome to Cart")
    this.getCart()

  }
  getCart(){
    this.uservice.getUserById(this.u_id).subscribe( data=>{
      this.user=data

      
      console.log(data)

      this.cservice.getCart(this.u_id).subscribe(res=>{
        this.carts=res
        console.log(res)
      })
    })

   

  }

  decreaseQuantity(cart: any, id: any) {
    cart.unit -= 1;
    cart.totalPrice = cart.unit* cart.product.price;
    this.updateCart(cart, id);   
  }

  increaseQuantity(cart: any, id: any) {
  
    cart.unit += 1;
   
    cart.totalPrice = cart.unit * cart.product.price;
    this.updateCart(cart, id);   
  }


  updateCart(cart: any, cartId: any) {
    
    this.cservice.updateCart(cart, cartId).subscribe(cart => {
      console.log(cart);
      this.getCart();
    });
  }

  deleteCart(id:any){
    this.cservice.deleteCart(id).subscribe(res=>{
      alert("item deleted ")

    })

  }

  
  goToDiscount(){
    this.rout.navigate(['discount'])
  }



  




}
