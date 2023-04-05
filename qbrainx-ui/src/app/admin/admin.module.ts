import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { BannerComponent } from './banner/banner.component';
import { CoreServiceComponent } from './core-service/core-service.component';
import { WhoWeAreComponent } from './who-we-are/who-we-are.component';
import { LifeAtQbxComponent } from './life-at-qbx/life-at-qbx.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { WhatWeOfferComponent } from './what-we-offer/what-we-offer.component';
import { ReachUsComponent } from './reach-us/reach-us.component';
import { ServicesComponent } from './services/services.component';
import { ItsmComponent } from './itsm/itsm.component';
import { ItsmfeaturesComponent } from './itsm/itsmfeatures/itsmfeatures.component';
import { ItsmadvantagesComponent } from './itsm/itsmadvantages/itsmadvantages.component';


@NgModule({
  declarations: [AdminComponent, AdminDashboardComponent, BannerComponent, CoreServiceComponent, WhoWeAreComponent, LifeAtQbxComponent, WhatWeOfferComponent, ReachUsComponent, ServicesComponent, ItsmComponent, ItsmfeaturesComponent, ItsmadvantagesComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class AdminModule { }
