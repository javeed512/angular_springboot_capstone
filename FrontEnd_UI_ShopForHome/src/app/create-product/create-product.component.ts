import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {

  product:Product={
    id : 0,
    name: '',
    price: 0,
    url: '',
    quantity: 0,
    catagory: ''
  }
  

  constructor(private pservice:ProductService) { }

  ngOnInit(): void {
  }
  productRegistration(data : any){
    alert(data.name)
    this.product=data
    this.pservice.addProduct(this.product).subscribe(res=>{
      if(res !=null){

        alert("Product Registered Successfully!")



    }

    else{

      alert("Registration failed! Try Again..")

     

    }
    })


  }

}
