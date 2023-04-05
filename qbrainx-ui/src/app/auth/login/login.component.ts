import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { AdminPanalService } from '../../../app/admin/admin-panal.service';
import { Router } from '@angular/router';
import { HttpHeaders,HttpClient, HttpParams,HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  LoginForm = new FormGroup({
    username: new FormControl(''),
    password:new FormControl(''),
  });
  errors : any
  constructor(private adminPanalService:AdminPanalService,private router:Router,private httpClient : HttpClient) { }

  ngOnInit(): void {
  }
  loginFormSubmit() {
  let body = new FormData();
  body.append("username", this.LoginForm.value.username)
  body.append("password", this.LoginForm.value.password)
  let header = {
    'accept': '*/*',
  }
  this.httpClient
    .post('https://devsite.qbrainx.com/qbrainx-web/v1/admin/AdminLogin', body,  {
     headers: header,
     responseType: 'text'
    })
    .subscribe(data => {
      console.log(data);
      localStorage.setItem('username', this.LoginForm.value.username);
      this.router.navigate(['/admin']);
    },
    error => {
      this.errors = 'Invalid username / password';
    },
    );

  }
}
