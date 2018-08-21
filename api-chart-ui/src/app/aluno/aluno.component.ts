import { DisciplinaService } from './../shared/services/disciplina.service';
import { Aluno } from './../shared/entities/aluno';
import { Disciplina } from './../shared/entities/disciplina';
import { AlunoService } from './../shared/services/aluno.service';
import { Component, OnInit } from '@angular/core';
import { Chart } from "chart.js";

@Component({
  selector: 'app-aluno',
  templateUrl: './aluno.component.html',
  styleUrls: ['./aluno.component.css']
})
export class AlunoComponent implements OnInit {

  chart: any = [];
  alunos: Aluno[] = []
  disciplinas: Disciplina[] = []
  
  constructor(
    private alunoService: AlunoService,
    private disciplinaService: DisciplinaService
  ) {}

  listarAlunos(){
    return this.alunoService.listar().then(aluno => this.alunos = aluno)
  }

  listarDisciplinas(){
    return this.disciplinaService.listar().then(disciplina => this.disciplinas = disciplina)
  }

  tipoGraficoPromptInicial(){
    var optionChart = prompt('Digite o tipo de gráfico: pie, bar, horizontalBar ou line')
    return optionChart 
  }

  reloadChart(){
    return location.reload()
  }
  
  ngOnInit() { 
    this.listarAlunos()
    this.listarDisciplinas()
      .then(res => {
        let disciplina = this.disciplinas.map(res => res.nota)
        let nomeDisciplina = this.disciplinas.map(res => res.nomeDisciplina)  

        this.chart = new Chart('canvas', {
          type: this.tipoGraficoPromptInicial(),
          data: {
              labels: nomeDisciplina,
              datasets: [{
                label: 'Notas',
                data: disciplina,
                backgroundColor: 
                  [
                    'rgba(255, 99, 132, 0.2)', 
                    'rgba(54, 162, 235, 0.2)', 
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)', 
                    'rgba(153, 102, 255, 0.2)', 
                    'rgba(255, 99, 132, 0.2)', 
                    'rgba(54, 162, 235, 0.2)', 
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)', 
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(255, 99, 132, 0.2)', 
                    'rgba(54, 162, 235, 0.2)', 
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)', 
                    'rgba(153, 102, 255, 0.2)',
                  ]                  
                ,
                borderColor: 
                  [
                    'rgba(255, 99, 132, 1)', 
                    'rgba(54, 162, 235, 1)', 
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)', 
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 99, 132, 1)', 
                    'rgba(54, 162, 235, 1)', 
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)', 
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 99, 132, 1)', 
                    'rgba(54, 162, 235, 1)', 
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)', 
                    'rgba(153, 102, 255, 1)',
                    
                  ]
                ,
                borderWidth: 1
              }]
          },
          options: {
            scales: {
              yAxes: [{
                  ticks: {
                      beginAtZero:true
                  }
              }]
            }
          }
      });
    })
  }  
}