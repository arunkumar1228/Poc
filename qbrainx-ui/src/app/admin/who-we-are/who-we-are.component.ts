import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-who-we-are',
  templateUrl: './who-we-are.component.html',
  styleUrls: ['./who-we-are.component.scss']
})
export class WhoWeAreComponent implements OnInit {

  WhoWeAreForm= new FormGroup({
    // Title: new FormControl(''),
    Description:new FormControl(''),
    CTA:new FormControl(''),
    WhoWeAreImage: new FormControl(''),
  });
  whoWeAreImage: any;
  whoweareObj: any;

  WhoWeAreFormUpdate = new FormGroup({  
  Description:new FormControl(''),
  CTA:new FormControl(''),
  WhoWeAreImage: new FormControl(''),
  WhoweareId: new FormControl(''),
  });
  WhoWeAreFormDelete = new FormGroup({
    Whoweare: new FormControl('')
  });
  constructor(private httpClient : HttpClient) { }

  ngOnInit(): void {
  }
  imageValidate(event:any)
  {
    
    if (
      event.target.files[0].type == 'image/png' ||
      event.target.files[0].type == 'image/gif' ||
      event.target.files[0].type == 'image/jpeg' ||
      event.target.files[0].type == 'image/jpg'
    ){
      this.whoWeAreImage=event.target.files[0];
    }
    else {
      alert("Select Only Image")
    }
  }

  whoSubmit()
  {
    
   let body = new FormData();
  
   body.append("file", this.whoWeAreImage);
   body.append("description", this.WhoWeAreForm.value.Description);
   body.append("link", this.WhoWeAreForm.value.CTA);
      
    
    this.httpClient
    .post('https://devsite.qbrainx.com/qbrainx-web/v1/whoWeAre/createFeedback', body, {
      responseType: 'text'
    })
    .subscribe((data) => {
      window.location.reload();
    });

  }
  onChange(event:any) { 
    this.httpClient
    .get<any>('https://devsite.qbrainx.com/qbrainx-web/v1/whoWeAre/getFeedbackById?id='+event.target.value,  {
      responseType: 'json'
    })
    .subscribe(data => {
        this.whoweareObj = data;
        console.log(this.whoweareObj);
    });
  }
  whoweareUpdate()
  {
    
   let body = new FormData();
  
   body.append("file", this.whoWeAreImage);
   body.append("id", this.WhoWeAreFormUpdate.value.WhoweareId);
   body.append("description", this.WhoWeAreFormUpdate.value.Description);
   body.append("link", this.WhoWeAreFormUpdate.value.CTA);
      
    
    this.httpClient
    .put('https://devsite.qbrainx.com/qbrainx-web/v1/whoWeAre/updateFeedbackDetailsById', body, {
      responseType: 'text'
    })
    .subscribe((data) => {
      window.location.reload();
    });

  }
  delete(){
    this.httpClient
     .delete('https://devsite.qbrainx.com/qbrainx-web/v1/whoWeAre/deleteFeedbackById?id='+this.WhoWeAreFormDelete.value.Whoweare, {
       responseType: 'text'
     })
     .subscribe((data) => {
       window.location.reload();
     });
   }
  
}
