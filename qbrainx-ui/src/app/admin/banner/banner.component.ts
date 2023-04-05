import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { BannerDto } from 'src/app/api/qbrainx-api/models';
import { BehaviorSubject, Observable } from 'rxjs';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';
import { AdminPanalService } from '../admin-panal.service';
import { HttpHeaders,HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.scss']
})
export class BannerComponent implements OnInit {

  BannerForm= new FormGroup({
    email: new FormControl(''),
    country: new FormControl(''),
    city:new FormControl(''),
    address:new FormControl(''),
    phone:new FormControl(''),
    BannerImage: new FormControl(''),
  });
  bannerImage!:File;
  bannerObj: any;


  
  constructor(private adminPanalService:AdminPanalService,private router:Router,private httpClient : HttpClient) { }

  ngOnInit(): void {
  }

 banImage(event:any)
  {
    
    if (
      event.target.files[0].type == 'image/png' ||
      event.target.files[0].type == 'image/gif' ||
      event.target.files[0].type == 'image/jpeg' ||
      event.target.files[0].type == 'image/jpg'
    ){
      this.bannerImage=event.target.files[0];
    }
    else {
      alert("Select Only Image")
    }
  }
  
  bannerSubmit()
  {
    
   let body = new FormData();
  
   body.append("file", this.bannerImage);
   body.append("country", this.BannerForm.value.country);
   body.append("city", this.BannerForm.value.city);
   body.append("address", this.BannerForm.value.address);
   body.append("phone", this.BannerForm.value.phone);
   body.append("email", this.BannerForm.value.email);
    
    this.httpClient
    .post('http://localhost:8081/qbrainx-web-home/v1/banner/createBanner', body, {
      responseType: 'text'
    })
    .subscribe((data) => {
      window.location.reload();
    });

  }
}
