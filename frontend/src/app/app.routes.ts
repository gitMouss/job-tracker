import { Routes } from '@angular/router';
import { ApplicationListComponent } from './pages/application-list/application-list.component';
import { ApplicationFormComponent } from './pages/application-form/application-form.component';

export const routes: Routes = [
    { path: '', component: ApplicationListComponent},
    { path: 'new', component: ApplicationFormComponent}
];
