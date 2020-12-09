import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LabResultsComponent } from './lab-results.component';


const routes: Routes = [
  {
    path: '',
    component: LabResultsComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LabResultsRoutingModule { }
