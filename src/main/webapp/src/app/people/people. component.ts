import { Component, TemplateRef } from '@angular/core';
import { PeopleService } from './services/people.service';
import { Observable } from 'rxjs';
import { PeronTypes } from './utils/enums';
import { DropdownObject, Person } from './utils/interfaces';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';

@Component({
  selector: 'people',
  templateUrl: './people.component.html',
  styleUrls: ['./people.component.less']
})
export class PeopleComponent {

  modalRef: BsModalRef;
  people$: Observable<Person[]>;
  personType = PeronTypes.ALL;
  isNew = true;
  person = {} as Person;
  isPhysician = false;

  peopleTypes: DropdownObject[] = [
    {
      value: PeronTypes.ALL,
      label: 'Todos'
    },
    {
      value: PeronTypes.PATIENTS,
      label: 'Pacientes'
    },
    {
      value: PeronTypes.PHYSICIANS,
      label: 'Doctores'
    }
  ];

  selectedType: DropdownObject;

  constructor(
    private modalService: BsModalService,
    private peopleService: PeopleService) {
    this.people$ = this.peopleService.getPeople();
    this.selectedType = this.peopleTypes[0];
    this.person.sex = 'Masculino';
  }

  updateList(type: DropdownObject) {
    this.selectedType = type;
    if (type.value === PeronTypes.PATIENTS) {
      this.people$ = this.peopleService.getPatients();
    } else if (type.value === PeronTypes.PHYSICIANS) {
      this.people$ = this.peopleService.getPhysicians()
    } else {
      this.people$ = this.peopleService.getPeople();
    }
  }

  savePerson(person: Person) {
    this.modalRef.hide();
    this.person.specialty = this.isPhysician ? this.person.specialty : null;
    if (this.person.id) {
      this.person = person;
      this.peopleService.updatePerson(this.person)
        .subscribe(() => {
          this.updateList(this.selectedType);
        });
    } else {
      this.peopleService.createPerson(this.person)
        .subscribe(() => {
          this.updateList(this.selectedType);
        });
    }
  }

  openModal(template: TemplateRef<any>, person: Person, isNew: boolean) {
    this.isNew = isNew;
    if (this.isNew) {
      this.isPhysician = false;
      this.person = {} as Person;
      this.person.sex = 'Masculino';
    } else {
      this.person = { ...person };
      this.isPhysician = !!this.person.specialty;
    }
    this.modalRef = this.modalService.show(template);
  }
}
