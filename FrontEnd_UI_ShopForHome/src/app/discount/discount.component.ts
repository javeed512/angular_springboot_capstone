import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-discount',
  templateUrl: './discount.component.html',
  styleUrls: ['./discount.component.css']
})
export class DiscountComponent implements OnInit {

  constructor(private http:HttpClient) { }
  
  discounts:any

  ngOnInit(): void {
    this.http.get<any>("http://localhost:8181/discount/getAll").subscribe(res=>{
      // alert("Welcome to Discounts Page")
      this.discounts=res
    })
  }

}
