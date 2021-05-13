import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const defaultUrl = "http://localhost:8080/api/busschedules";

@Injectable({
  providedIn: 'root'
})
export class BusesScheduleService {

  constructor(private http: HttpClient) { }

  getAllBusesSchedule(page: Number, size: Number): Observable<any> {
    return this.http.get<any>(defaultUrl + "/getAllBusSchedules/?page=" + page + "&size=" + size);
  }

  getBusesScheduleByDestination(page: Number, size: Number, destiantion: string): Observable<any> {
    return this.http.get<any>(defaultUrl + "/getBusSchedulesByDestination/?page=" + page + "&size=" + size + "&dest=" + destiantion);
  }
}
