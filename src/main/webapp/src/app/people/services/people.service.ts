import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';
import { Person } from '../utils/interfaces';

@Injectable()
export class PeopleService {

  constructor(private http: HttpClient) {
  }

  getPeople(): Observable<Person[]> {
    return this.http.get<Person[]>(`${environment.API_URL}/api/people`);
  }

  getPatients(): Observable<Person[]> {
    return this.http.get<Person[]>(`${environment.API_URL}/api/people/patients`);
  }

  getPhysicians(): Observable<Person[]> {
    return this.http.get<Person[]>(`${environment.API_URL}/api/people/physicians`);
  }

  updatePerson(person: Person): Observable<Person> {
    if (person.specialty) {
      return this.http.put<Person>(`${environment.API_URL}/api/people/physicians`, person);
    } else {
      return this.http.put<Person>(`${environment.API_URL}/api/people/patients`, person);
    }
  }

  createPerson(person: Person): Observable<Person> {
    if (person.specialty) {
      return this.http.post<Person>(`${environment.API_URL}/api/people/physicians`, person);
    } else {
      return this.http.post<Person>(`${environment.API_URL}/api/people/patients`, person);
    }
  }
}
