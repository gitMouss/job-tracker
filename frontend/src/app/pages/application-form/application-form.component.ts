import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Applications } from '../../models/applications';
import { ApplicationService } from '../../services/application.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-application-form',
  imports: [CommonModule, FormsModule],
  templateUrl: './application-form.component.html',
  styleUrl: './application-form.component.css'
})
export class ApplicationFormComponent {

  application: Applications = {
    company: '',
    position: '',
    link: '',
    status: 'ENVOYEE',
    appliedDate: '',
    notes: ''
  };

  constructor(
    private readonly applicationService: ApplicationService,
    private readonly router: Router
  ) {}

  save(): void {
    this.applicationService.createApplication(this.application).subscribe({
      next: () => this.router.navigate(['/']),
      error: (err) => console.error(err)
    });
  }

}
