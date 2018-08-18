import { AlunoService } from './shared/services/aluno.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AlunoComponent } from './aluno/aluno.component';
import { DisciplinaService } from './shared/services/disciplina.service';
import { HttpModule } from '@angular/http';

@NgModule({
  declarations: [
    AppComponent,
    AlunoComponent
  ],
  imports: [
    BrowserModule,
    HttpModule
  ],
  providers: [AlunoService, DisciplinaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
