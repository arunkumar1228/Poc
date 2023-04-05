import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-what-we-offer',
  templateUrl: './what-we-offer.component.html',
  styleUrls: ['./what-we-offer.component.scss']
})
export class WhatWeOfferComponent implements OnInit {
  WhatWeAreForm= new FormGroup({
    Title: new FormControl(''),
    SubTitle:new FormControl(''),
    Description:new FormControl(''),
    WhatWeOfferImage:new FormControl(''),
   
  });
  whatWeOfferImage :any;
  constructor(private httpClient : HttpClient) { }

  ngOnInit(): void {
  }

  imageValidate(event:any)
  {
    
    if (
      event.target.files[0].type == 'image/png' ||
      event.target.files[0].type == 'image/gif' ||
      event.target.files[0].type == 'image/jpeg' ||
      event.target.files[0].type == 'image/jpg' ||
      event.target.files[0].type == 'image/webp'
    ){
      this.whatWeOfferImage=event.target.files[0];
    }
    else {
      alert("Select Only Image")
    }
  }

  submit()
  {
    
    let body = new FormData();
  
    body.append("file", this.whatWeOfferImage);
    body.append("description", this.WhatWeAreForm.value.Description);
    body.append("link", this.WhatWeAreForm.value.Title);
       
     
     this.httpClient
     .post('https://devsite.qbrainx.com/qbrainx-web/v1/weOffers/createNews', body, {
       responseType: 'text'
     })
     .subscribe((data) => {
       window.location.reload();
     });
  }

}
