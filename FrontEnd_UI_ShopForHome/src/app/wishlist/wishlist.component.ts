import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { HomeComponent } from '../home/home.component';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { UserPageComponent } from '../user-page/user-page.component';
import { UserService } from '../user.service';
import { Wishlist } from '../wishlist';
import { WishlistService } from '../wishlist.service';

@Component({
  selector: 'app-wishlist',
  templateUrl: './wishlist.component.html',
  styleUrls: ['./wishlist.component.css']
})
export class WishlistComponent implements OnInit {

  constructor(private uservice:UserService,private pservice:ProductService,private router:ActivatedRoute,private wservice:WishlistService) { }
 u_id:any
  list:any=[]
  product:any=[]
  prd:Product={
    id: 0, 
    name: '',
    price: 0,
    url: '',
    quantity: 0,
    catagory: ''
  }
  ngOnInit(): void {
    this.u_id=this.router.snapshot.paramMap.get('id')
    this.wservice.getUserWishlist(this.u_id).subscribe(res=>{
      for(let obj of res )
      
      this.list.push(obj.pid)

      console.log(this.list)
      
    })
    this.getProduct()
    console.log(this.product)
    
    }
    getProduct(){
      this.pservice.getAllProducts().subscribe(res=>{
        res.find((prd:any)=>{
          if(this.list.includes(prd.id)){
            this.product.push(prd);
            
          }
        });
      })
    }
    deleteData(pid:number){
      this.wservice.deleteFromWishlist(this.u_id,pid).subscribe(res=>{
        console.log(res)
      })


    }


  }

  
  

  




