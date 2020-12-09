import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Person } from '../utils/interfaces';

@Component({
  selector: 'people-list',
  templateUrl: './people-list.component.html',
})
export class PeopleListComponent implements OnInit {
  @Input() peopleList: Person[] = [];
  @Output() editPerson = new EventEmitter<Person>();

  ngOnInit() {

  }

  getFullName(person: Person): String {
    return `${person.firstName} ${person.firstLastName} ${person.secondLastName}`;
  }
}
