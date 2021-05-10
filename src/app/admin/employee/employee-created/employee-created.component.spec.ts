import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeCreatedComponent } from './employee-created.component';

describe('EmployeeCreatedComponent', () => {
  let component: EmployeeCreatedComponent;
  let fixture: ComponentFixture<EmployeeCreatedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeCreatedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeCreatedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
