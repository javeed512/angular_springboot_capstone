import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { Ng2SearchPipeModule } from "ng2-search-filter";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  products: Product[]=[]
  searchText:any
  pid:any

  constructor(private pservice:ProductService) { }

  ngOnInit(): void {
    this.pservice.getAllProducts().subscribe(res=>{
      this.products=res
    })
  }
  getData(){
    alert("Login first")

  }

}

