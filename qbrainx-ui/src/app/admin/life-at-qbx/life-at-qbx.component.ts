import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-life-at-qbx',
  templateUrl: './life-at-qbx.component.html',
  styleUrls: ['./life-at-qbx.component.scss']
})
export class LifeAtQbxComponent implements OnInit {

  LifeqbxForm= new FormGroup({
    Title: new FormControl(''),
    SubTitle:new FormControl(''),
    Established:new FormControl(''),
    Projects:new FormControl(''),
    Clients:new FormControl(''),
    id:new FormControl(''),
    // LifeQbxImage:new FormControl(''),
   
  });
  LifeQbxImage!:File;
  constructor(private httpClient : HttpClient) { }
  lifeatqbObj: any
  ngOnInit(): void {
    this.getall();
  }
  // imageValidate(event:any)
  // {
    
  //   if (
  //     event.target.files[0].type == 'image/png' ||
  //     event.target.files[0].type == 'image/gif' ||
  //     event.target.files[0].type == 'image/jpeg' ||
  //     event.target.files[0].type == 'image/jpg'
  //   ){
  //     this.whoWeAreImage=event.target.files[0];
  //   }
  //   else {
  //     alert("Select Only Image")
  //   }
  // }
  submit()
  {
    
   let body = new FormData();
  
   let headers = new HttpHeaders({
    'Content-Type': 'application/json'
  });
   body.append("textTitle", this.LifeqbxForm.value.Title);
   body.append("textSubTitle", this.LifeqbxForm.value.SubTitle);
   body.append("established", this.LifeqbxForm.value.Established);
   body.append("project", this.LifeqbxForm.value.Projects);
   body.append("client", this.LifeqbxForm.value.Clients);
   
    this.httpClient
    .post('https://devsite.qbrainx.com/qbrainx-web/v1/lifeAtQb/createText', JSON.stringify(body), {
      responseType: 'text',
      headers
    })
    .subscribe((data) => {
      window.location.reload();
    });

  }
  getall() { 
    this.httpClient
    .get<any>('https://devsite.qbrainx.com/qbrainx-web/v1/lifeAtQb/getAllText',  {
      responseType: 'json'
    })
    .subscribe(data => {
        this.lifeatqbObj = data[0];
    });
  }
  update()
  {
    
   let body = new FormData();
  
   let headers = new HttpHeaders({
    'Content-Type': 'application/json'
  });
   body.append("textTitle", this.LifeqbxForm.value.Title);
   body.append("textSubTitle", this.LifeqbxForm.value.SubTitle);
   body.append("established", this.LifeqbxForm.value.Established);
   body.append("project", this.LifeqbxForm.value.Projects);
   body.append("client", this.LifeqbxForm.value.Clients);
   body.append("id", this.LifeqbxForm.value.id);
      
    
    this.httpClient
    .put('https://devsite.qbrainx.com/qbrainx-web/v1/lifeAtQb/updateTextDetailsById', body, {
      responseType: 'text'
    })
    .subscribe((data) => {
      // window.location.reload();
    });

  }
  // delete(){
  //   this.httpClient
  //    .delete('https://devsite.qbrainx.com/qbrainx-web/v1/whoWeAre/deleteFeedbackById?id='+this.LifeqbxFormDelete.value.Whoweare, {
  //      responseType: 'text'
  //    })
  //    .subscribe((data) => {
  //      window.location.reload();
  //    });
  //  }

}
