import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BlogComponent } from './blog/blog.component';
import { HomeComponent } from './home/home.component';
import { ServicesComponent } from './services/services.component';
import { SuccessStoriesComponent } from './success-stories/success-stories.component';
import { BlogDetailComponent } from './blog/blog-detail/blog-detail.component';
import { WebinarComponent } from './webinar/webinar.component';
import { LeadershipComponent } from './leadership/leadership.component';
import { NewsComponent } from './news/news.component';
import { CareerComponent } from './career/career.component';
import { ContactComponent } from './contact/contact.component';
import { LeadershipDetailComponent } from './leadership/leadership-detail/leadership-detail.component';
import { ServicenowComponent } from './services/servicenow/servicenow.component';
import { ItsmComponent } from './services/servicenow/itsm/itsm.component';
import { ItomComponent } from './services/servicenow/itom/itom.component';
import { CsmComponent } from './services/servicenow/csm/csm.component';
import { HrsdComponent } from './services/servicenow/hrsd/hrsd.component';
import { GrcComponent } from './services/servicenow/grc/grc.component';
import { FsmComponent } from './services/servicenow/fsm/fsm.component';
import { MicroserviceComponent } from './services/microservice/microservice.component';
import { SalesforceComponent } from './services/salesforce/salesforce.component';
import { AboutComponent } from './about/about.component';
import { SapComponent } from './services/sap/sap.component';


const routes: Routes = [
            // {
            //   path: '',
            //   loadChildren: () => import('./auth/auth.module').then((n) => n.AuthModule),
            // },

            // {
            //   path: 'adminPanel',
            //   loadChildren: () => import('./admin-pan/admin-pan.module').then((n) => n.AdminPanModule)
            // },



                        { path: '', component: HomeComponent},
                        { path: 'success-stories', component: SuccessStoriesComponent },
                        { path: 'services', component: ServicesComponent},
                        { path: 'blog', component: BlogComponent},
                        { path: 'blog-detail', component: BlogDetailComponent},
                        { path: 'webinar', component: WebinarComponent},
                        { path: 'leadership', component: LeadershipComponent},
                        { path: 'news', component: NewsComponent},
                        { path: 'career', component: CareerComponent },
                        { path: 'contact', component: ContactComponent},
                        { path: 'leadership-info', component: LeadershipDetailComponent},
                        { path: 'servicenow', component: ServicenowComponent},
                        { path: 'itsm', component: ItsmComponent},
                        { path: 'itom', component: ItomComponent},
                        { path: 'csm', component: CsmComponent},
                        { path: 'hrsd', component: HrsdComponent},
                        { path: 'grc', component: GrcComponent},
                        { path: 'fsm', component: FsmComponent},
                        { path: 'microservice', component: MicroserviceComponent},
                        { path: 'salesforce', component: SalesforceComponent},
                        { path: 'about', component: AboutComponent},
                        { path: 'sap', component: SapComponent}
                           

                        
                        ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PagesRoutingModule { }
