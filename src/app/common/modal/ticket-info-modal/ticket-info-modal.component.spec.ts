import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketInfoModalComponent } from './ticket-info-modal.component';

describe('TicketInfoModalComponent', () => {
  let component: TicketInfoModalComponent;
  let fixture: ComponentFixture<TicketInfoModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TicketInfoModalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TicketInfoModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
