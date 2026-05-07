import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Applications } from '../models/applications';

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {

  private readonly apiUrl = 'http://localhost:8080/api/applications';

  constructor(private readonly http: HttpClient) { }
//AppelREST
  getApplications(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }

  //Formulaire d'ajout
  createApplication(application: Applications) {
    return this.http.post<Applications>(this.apiUrl, application);
  }

}
