import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusCreatedComponent } from './bus-created.component';

describe('BusCreatedComponent', () => {
  let component: BusCreatedComponent;
  let fixture: ComponentFixture<BusCreatedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BusCreatedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BusCreatedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
