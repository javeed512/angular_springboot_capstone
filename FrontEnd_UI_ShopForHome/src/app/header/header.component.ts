import { Component, OnInit, EventEmitter, Output } from '@angular/core';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public searchItem:string='';

  constructor() { }

  ngOnInit(): void {
  }

  @Output()
  searchTextChanged : EventEmitter<string> =new  EventEmitter<string>();

  onSeachTextChanged(){
    this.searchTextChanged.emit(this.searchItem);
  }


}
