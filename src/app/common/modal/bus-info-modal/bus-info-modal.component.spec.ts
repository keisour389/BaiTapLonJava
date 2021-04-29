import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusInfoModalComponent } from './bus-info-modal.component';

describe('BusInfoModalComponent', () => {
  let component: BusInfoModalComponent;
  let fixture: ComponentFixture<BusInfoModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BusInfoModalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BusInfoModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
