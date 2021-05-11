import { TestBed } from '@angular/core/testing';

import { BusesScheduleService } from './buses-schedule.service';

describe('BusesScheduleService', () => {
  let service: BusesScheduleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BusesScheduleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
