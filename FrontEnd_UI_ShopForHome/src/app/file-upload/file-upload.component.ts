import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-file-upload',
  templateUrl: './file-upload.component.html',
  styleUrls: ['./file-upload.component.css']
})
export class FileUploadComponent implements OnInit {

  url:string="http://localhost:8080/products/add-bulk-products"
  constructor(private http:HttpClient) { }

  ngOnInit(): void {
  }

  file:any

  selectFile(event:any){
    console.log(event)
    this.file=event.target.files[0]
    console.log(this.file)


  }
  uploadFile(){

    let formData = new FormData()
    formData.append("file",this.file)
    this.http.post(this.url,formData).subscribe(res=>{
      console.log(res)
      alert("file uploaded")
    },(err)=>{
      console.log(err)

    })


  }

}
