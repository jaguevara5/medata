import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { PeopleComponent } from './people. component';
import { PeopleService } from './services/people.service';
import { PeopleRoutingModule } from './people-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { PeopleListComponent } from './people-list/people-list.component';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { ModalModule } from 'ngx-bootstrap/modal';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { FormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    PeopleRoutingModule,
    HttpClientModule,
    FormsModule,
    BsDropdownModule.forRoot(),
    ModalModule.forRoot(),
    BsDatepickerModule.forRoot(),
  ],
  declarations: [
    PeopleComponent,
    PeopleListComponent
  ],
  providers: [
    PeopleService,
  ],
})
export class PeopleModule {
}
