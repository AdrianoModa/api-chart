import { AlunoService } from './../shared/services/aluno.service';
import { Component, OnInit } from '@angular/core';
import { Chart } from "chart.js";

@Component({
  selector: 'app-aluno',
  templateUrl: './aluno.component.html',
  styleUrls: ['./aluno.component.css']
})
export class AlunoComponent implements OnInit {

  constructor(private alunoService: AlunoService) { }

  canvas: any
  ctx: any

  consultar(){
    this.alunoService.listar()
  }
 
  ngOnInit() {
    this.consultar()
    this.canvas = document.getElementById('myChart');
    this.ctx = this.canvas.getContext('2d');
    let myChart = new Chart(this.ctx, {
      type: 'bar',
      data: {
          labels: ['Comer','Dormir','Estudar','Jogar'],
          datasets: [{
              label: '# of Votes',
              data: [10,30,50,80],
              backgroundColor: [
                'rgba(255, 99, 132, 0.3)',
                'rgba(54, 162, 235, 0.3)',
                'rgba(255, 206, 86, 0.3)',
                'rgba(128, 0, 128, 0.3)'
              ],
              borderColor: [
                'rgba(255, 99, 132)',
                'rgba(54, 162, 235)',
                'rgba(255, 206, 86)',
                'rgba(128, 0, 128)'
              ], 
              borderWidth: [.5,.5,.5,.5],
              fill: false   
          }]
      },
      options: {
        responsive: false,
        cutoutPercentage: 80,
        scales: {
          yAxes: [{
              ticks: {
                  max: 100,
                  min: 0,
              }
          }]
      }
      }
    });
  }
}