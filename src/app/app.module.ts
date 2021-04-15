import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { TestComponent } from './test/test.component';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { SearchTicketsComponent } from './search-tickets/search-tickets.component';
import { OrderTicketsComponent } from './order-tickets/order-tickets.component';
import { CountPipe } from './order-tickets/count.pipe';
import { PaymentComponent } from './payment/payment.component';

const appRouters: Routes = [
  {path: '', component: HomeComponent, pathMatch:'full'},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'search-tickets', component: SearchTicketsComponent},
  {path: 'order-tickets', component: OrderTicketsComponent},
  {path: 'payment', component: PaymentComponent}
];


@NgModule({
  declarations: [
    CountPipe,
    AppComponent,
    TestComponent,
    LoginComponent,
    RegisterComponent,
    NavbarComponent,
    HomeComponent,
    FooterComponent,
    SearchTicketsComponent,
    OrderTicketsComponent,
    PaymentComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRouters)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
