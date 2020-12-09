import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { ModalModule } from 'ngx-bootstrap/modal';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { FormsModule } from '@angular/forms';
import { LabResultsService } from './lab-results.service';
import { LabResultsComponent } from './lab-results.component';
import { LabResultsRoutingModule } from './lab-results-routing.module';
import { NgxEchartsModule } from 'ngx-echarts';

@NgModule({
  imports: [
    CommonModule,
    LabResultsRoutingModule,
    HttpClientModule,
    FormsModule,
    BsDropdownModule.forRoot(),
    ModalModule.forRoot(),
    BsDatepickerModule.forRoot(),
    NgxEchartsModule.forRoot({
      echarts: () => import('echarts')
    })
  ],
  declarations: [
    LabResultsComponent
  ],
  providers: [
    LabResultsService
  ],
})
export class LabResultsModule {
}
