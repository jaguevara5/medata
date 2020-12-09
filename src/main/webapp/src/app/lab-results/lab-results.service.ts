import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable()
export class LabResultsService {

  constructor(private http: HttpClient) {
  }

  getResults(): Observable<any[]> {
    return this.http.get<any[]>(`${environment.API_URL}/api/labresults`);
  }
}
