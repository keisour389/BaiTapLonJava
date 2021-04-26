import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusManagementComponent } from './bus-management.component';

describe('BusManagementComponent', () => {
  let component: BusManagementComponent;
  let fixture: ComponentFixture<BusManagementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BusManagementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BusManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
