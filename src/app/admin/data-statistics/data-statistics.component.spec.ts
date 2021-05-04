import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DataStatisticsComponent } from './data-statistics.component';

describe('DataStatisticsComponent', () => {
  let component: DataStatisticsComponent;
  let fixture: ComponentFixture<DataStatisticsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DataStatisticsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DataStatisticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
