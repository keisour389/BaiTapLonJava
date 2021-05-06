import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeInfoModalComponent } from './employee-info-modal.component';

describe('EmployeeInfoModalComponent', () => {
  let component: EmployeeInfoModalComponent;
  let fixture: ComponentFixture<EmployeeInfoModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeInfoModalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeInfoModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
