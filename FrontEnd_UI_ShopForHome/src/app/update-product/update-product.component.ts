import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  productToUpdate:Product={
    id: 0,
    name: '',
    price: 0,
    url: '',
    quantity: 0,
    catagory: ''
  }
id:any
  constructor(private pservice:ProductService,private route:ActivatedRoute) { }


  ngOnInit(): void {
    this.id=this.route.snapshot.paramMap.get('id')
    this.pservice.getProductById(this.id).subscribe(res=>{
      this.productToUpdate=res
      // alert(this.id+" will be Update")
    })
  }

  editProduct(data:Product){
    this.productToUpdate=data
    this.productToUpdate.id=this.id
    
    this.pservice.updateProduct(this.productToUpdate).subscribe(res=>{
      alert("Data updated")
  
    },
    (err) =>{
  
      alert("Data updated")
  
  
    }
    )
}
}
