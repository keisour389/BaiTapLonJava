import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { GoogleChartsModule } from 'angular-google-charts';
import { DatePipe } from '@angular/common';
import { CountPipe } from './order-tickets/count.pipe';

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
import { PaymentComponent } from './payment/payment.component';
import { OrderSuccessComponent } from './order-success/order-success.component';
import { ManagementComponent } from './admin/management/management.component';
import { AdminNavbarComponent } from './admin/admin-navbar/admin-navbar.component';
import { MenuComponent } from './admin/menu/menu.component';
import { BusManagementComponent } from './admin/bus/bus-management/bus-management.component';
import { OptionComponent } from './common/option/option.component';
import { TicketManagementComponent } from './admin/ticket/ticket-management/ticket-management.component';
import { EmployeeManagementComponent } from './admin/employee/employee-management/employee-management.component';
import { BusCreatedComponent } from './admin/bus/bus-created/bus-created.component';
import { EmployeeCreatedComponent } from './admin/employee/employee-created/employee-created.component';
import { ManageInformationComponent } from './admin/manage-information/manage-information.component';
import { EmployeeInfoModalComponent } from './common/modal/employee-info-modal/employee-info-modal.component';
import { TicketInfoModalComponent } from './common/modal/ticket-info-modal/ticket-info-modal.component';
import { BusInfoModalComponent } from './common/modal/bus-info-modal/bus-info-modal.component';
import { BiggerDayValidatorDirective } from './directive/biggerday-validator.directive';
import { PhonenumberValidatorDirective } from './directive/phonenumber-validator.directive';
import { ProfitStatisticComponent } from './admin/profit-statistic/profit-statistic.component';
import { DataStatisticsComponent } from './admin/data-statistics/data-statistics.component';
import { ChecknumericDirective } from './directive/checknumeric.directive';
import { LicencePlateValidatorDirective } from './directive/licence-plate-validator.directive';
import { IdValidatorDirective } from './directive/id-validator.directive';
import { FeedbackComponent } from './feedback/feedback.component';

const appRouters: Routes = [
  { path: '', component: HomeComponent, pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'search-tickets', component: SearchTicketsComponent },
  { path: 'order-tickets', component: OrderTicketsComponent },
  { path: 'payment', component: PaymentComponent },
  { path: 'order-success', component: OrderSuccessComponent },
  {
    path: 'management', component: AppComponent, children: [
      {
        path: '', component: ManagementComponent, pathMatch: 'full'
      },
      {
        path: 'bus-management', component: AppComponent, children: [
          {
            path: '', component: BusManagementComponent, pathMatch: 'full'
          },
          {
            path: 'create', component: BusCreatedComponent
          }]
      },
      {
        path: 'ticket-management', component: TicketManagementComponent
      },
      {
        path: 'employee-management', component: AppComponent, children: [
          {
            path: '', component: EmployeeManagementComponent, pathMatch: 'full'
          },
          {
            path: 'create', component: EmployeeCreatedComponent
          }]
      },
      {
        path: 'information/:managedType', component: ManageInformationComponent
      },
      {
        path: 'profit', component: AppComponent, children: [
          {
            path: '', component: ProfitStatisticComponent, pathMatch: 'full'
          },
          {
            path: 'statistic/:statisticType', component: DataStatisticsComponent
          }
        ]
      }
    ]
  },
  { path: 'menu', component: MenuComponent },
  { path: 'feedback', component: FeedbackComponent }
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
    PaymentComponent,
    OrderSuccessComponent,
    ManagementComponent,
    AdminNavbarComponent,
    MenuComponent,
    BusManagementComponent,
    OptionComponent,
    TicketManagementComponent,
    EmployeeManagementComponent,
    BusCreatedComponent,
    EmployeeCreatedComponent,
    ManageInformationComponent,
    EmployeeInfoModalComponent,
    TicketInfoModalComponent,
    BusInfoModalComponent,
    BiggerDayValidatorDirective,
    PhonenumberValidatorDirective,
    ProfitStatisticComponent,
    DataStatisticsComponent,
    ChecknumericDirective,
    LicencePlateValidatorDirective,
    IdValidatorDirective,
    FeedbackComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    GoogleChartsModule.forRoot(),
    RouterModule.forRoot(appRouters),
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
