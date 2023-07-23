import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-pdp',
  templateUrl: './pdp.component.html',
  styleUrls: ['./pdp.component.css']
})
export class PdpComponent implements OnInit {

  productList: Product[]=[]

  constructor(private pservice:ProductService, private route:Router) { }

  ngOnInit(): void {
    
   this.getProductsTable();

  }

  getProductsTable(){
    this.pservice.getAllProducts().subscribe(res=>{
      console.log(res);
      

        res.forEach( data => { 

            console.log(data);

            this.productList.push(data);
    })
  
  })

  }
   updateProduct(id:number){
    alert(id+" product will Update")
    this.route.navigate(['update-product',id])
    


   }

   deleteProduct(id:number){
    // alert("product "+id+" will be deleted")
    this.pservice.deleteProductById(id).subscribe(res=>{
      if(res)
      alert(id+" Deleted")
    },
    (err)=>{
      alert(id+" Deleted")

    });
   }

  bulk(){
    this.route.navigate(['bulk-upload'])
  }


}

