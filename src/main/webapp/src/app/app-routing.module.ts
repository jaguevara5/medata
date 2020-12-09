import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: 'people',
    loadChildren: () => import('./people/people.module').then(m => m.PeopleModule)
  },
  {
    path: 'lab-results',
    loadChildren: () => import('./lab-results/lab-results.module').then(m => m.LabResultsModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
