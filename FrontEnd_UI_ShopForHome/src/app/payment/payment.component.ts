import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  billAmount:number = 0;

  constructor(private route:ActivatedRoute) { 

    
  }



  ngOnInit(): void {

      this.route.params.subscribe( (param:any) => {this.billAmount = param['total']} );

  }

}
