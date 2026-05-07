import { Component, OnInit } from '@angular/core';
import { Applications } from '../../models/applications';
import { ApplicationService } from '../../services/application.service';

@Component({
  selector: 'app-application-list',
  imports: [],
  templateUrl: './application-list.component.html',
  styleUrl: './application-list.component.css'
})
export class ApplicationListComponent implements OnInit {

  applications: Applications[] = [];

  constructor(private readonly applicationService: ApplicationService){}

  ngOnInit(): void {
    this.applicationService.getApplications().subscribe({
      next: (data) => {
        this.applications = data.content;
      },
      error: (err) => {
        console.error(err);
      }
    });
  }

}
