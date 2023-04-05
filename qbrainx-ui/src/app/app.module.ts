import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DefaultLayoutComponent } from './layouts/default-layout/default-layout.component';
import { SharedModule } from './shared/shared.module';
import { NgwWowModule } from 'ngx-wow';
import { SwaggerApiModule } from './core/helpers/swagger-api.module';
import { HttpClientModule } from '@angular/common/http';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { ApiConfiguration } from './api/qbrainx-api/api-configuration';
import { environment } from 'src/environments/environment';



@NgModule({
  declarations: [
    AppComponent,
    DefaultLayoutComponent,
    AdminLayoutComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,
    SharedModule,
    NgwWowModule,
    SwaggerApiModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
  constructor(private base: ApiConfiguration) {
    base.rootUrl = `${environment.apiPrefix}${environment.apiQbrainx}`;
  }
}
