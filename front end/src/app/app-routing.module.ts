import { registerLocaleData } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
// import { ErrorComponent } from './error/error.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { RegComponent } from './reg/reg.component';
import { RouteGuardService } from './service/route-guard.service';
import { TempComponent } from './temp/temp.component';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'login', component: LoginComponent},
  {path: 'welcome/:name', component: WelcomeComponent,canActivate: [RouteGuardService]},
  {path: 'reg', component: RegComponent}, 
  {path: 'temp', component: TempComponent, canActivate: [RouteGuardService]}, 
  {path: 'logout', component: LogoutComponent, canActivate: [RouteGuardService]},  

  
  {path: '**', component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
