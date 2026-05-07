import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {

  private readonly apiUrl = 'http://localhost:8080/api/applications';

  constructor(private readonly http: HttpClient) { }

  getApplications(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }
}
