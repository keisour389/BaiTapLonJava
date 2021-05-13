import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const defaultAccountUrl = "http://localhost:8080/api/ticketmanagement";

@Injectable({
  providedIn: 'root'
})

export class TicketsService {
  

  constructor(private http: HttpClient) { }

  getTicketsByTripId(page: Number, size: Number, tripId: string): Observable<any>{
    return this.http.get<any>(defaultAccountUrl + "/getTicketsByTripId/?page=" + page + "&size=" + size + "&tripId=" + tripId);
  }
}
