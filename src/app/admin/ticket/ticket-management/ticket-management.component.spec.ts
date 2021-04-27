import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketManagementComponent } from './ticket-management.component';

describe('TicketManagementComponent', () => {
  let component: TicketManagementComponent;
  let fixture: ComponentFixture<TicketManagementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TicketManagementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TicketManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
