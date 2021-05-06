import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfitStatisticComponent } from './profit-statistic.component';

describe('ProfitStatisticComponent', () => {
  let component: ProfitStatisticComponent;
  let fixture: ComponentFixture<ProfitStatisticComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfitStatisticComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfitStatisticComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
