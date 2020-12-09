import { Component, OnInit } from '@angular/core';
import { LabResultsService } from './lab-results.service';
import { EChartOption } from 'echarts';
import * as moment from 'moment';
import 'moment/locale/es-mx';

@Component({
  selector: 'lab-results',
  templateUrl: './lab-results.component.html',
  styleUrls: ['./lab-results.component.less']
})
export class LabResultsComponent implements OnInit {
  options: EChartOption[] = [];
  bhData = {
    eritrocitos: [],
    hemoglobina: [],
    hematocrito: [],
    vgm: [],
    cmhc: [],
    hcm: [],
    rdw: [],
  };
  bhReferenceData = {
    eritrocitosLow: [],
    eritrocitosHigh: [],
    hemoglobinaLow: [],
    hemoglobinaHigh: [],
    hematocritoLow: [],
    hematocritoHigh: [],
    vgmLow: [],
    vgmHigh: [],
    cmhcLow: [],
    cmhcHigh: [],
    hcmLow: [],
    hcmHigh: [],
    rdwLow: [],
    rdwHigh: [],
  };
  bhGraphLabels = [
    'Eritrocitos',
    'Hemoglobina',
    'Hematocrito',
    'VGM',
    'CMHC',
    'HCM',
    'RDW'
  ];

  studyType = {
    eritrocitosLow: 4.10,
    eritrocitosHigh: 5.70,
    hemoglobinaLow: 12.5,
    hemoglobinaHigh: 16.5,
    hematocritoLow: 39,
    hematocritoHigh: 45,
    vgmLow: 78,
    vgmHigh: 103,
    cmhcLow: 30,
    cmhcHigh: 34,
    hcmLow: 27,
    hcmHigh: 32,
    rdwLow: 11.6,
    rdwHigh: 14.5,
  }

  constructor(
    private labResultsService: LabResultsService
  ) {}

  ngOnInit(): void {

    const xAxisData = [];
    const data: any[][] = [[],[]];
    moment.locale('es-mx');

    this.labResultsService.getResults()
      .subscribe((res: any[]) => {

        res.forEach(r => {
          xAxisData.push(moment(r.resultsDate).format('L'));
          this.bhData.eritrocitos.push(r.bhData.eritrocitos);
          this.bhReferenceData.eritrocitosLow.push(this.studyType.eritrocitosLow);
          this.bhReferenceData.eritrocitosHigh.push(this.studyType.eritrocitosHigh);
          this.bhData.hemoglobina.push(r.bhData.hemoglobina);
          this.bhReferenceData.hemoglobinaLow.push(this.studyType.hemoglobinaLow);
          this.bhReferenceData.hemoglobinaHigh.push(this.studyType.hemoglobinaHigh);
          this.bhData.hematocrito.push(r.bhData.hematocrito);
          this.bhReferenceData.hematocritoLow.push(this.studyType.hematocritoLow);
          this.bhReferenceData.hematocritoHigh.push(this.studyType.hematocritoHigh);
          this.bhData.vgm.push(r.bhData.vgm);
          this.bhReferenceData.vgmLow.push(this.studyType.vgmLow);
          this.bhReferenceData.vgmHigh.push(this.studyType.vgmHigh);
          this.bhData.cmhc.push(r.bhData.cmhc);
          this.bhReferenceData.cmhcLow.push(this.studyType.cmhcLow);
          this.bhReferenceData.cmhcHigh.push(this.studyType.cmhcHigh);
          this.bhData.hcm.push(r.bhData.hcm);
          this.bhReferenceData.hcmLow.push(this.studyType.hcmLow);
          this.bhReferenceData.hcmHigh.push(this.studyType.hcmHigh);
          this.bhData.rdw.push(r.bhData.rdw);
          this.bhReferenceData.rdwLow.push(this.studyType.rdwLow);
          this.bhReferenceData.rdwHigh.push(this.studyType.rdwHigh);
        });

        Object.keys(this.bhData).forEach((key) => {
          this.options.push({
            legend: {},
            tooltip: {},
            xAxis: {
              data: xAxisData,
              silent: false,
              splitLine: {
                show: false,
              },
            },
            yAxis: {},
            series: [
              {
                type: 'line',
                data: this.bhData[key],
                animationDelay: (idx) => idx * 10,
              },
              {
                name: 'Low',
                type: 'line',
                data: this.bhReferenceData[key + 'Low'],
                animationDelay: (idx) => idx * 10,
              },
              {
                name: 'High',
                type: 'line',
                data: this.bhReferenceData[key + 'High'],
                animationDelay: (idx) => idx * 10,
              },
            ],
            animationEasing: 'elasticOut',
            animationDelayUpdate: (idx) => idx * 5,
          });
        })
      });

  }
}
