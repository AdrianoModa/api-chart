import { Http } from '@angular/http';
import { Injectable } from '@angular/core';

import 'rxjs/add/operator/toPromise'

@Injectable()
export class DisciplinaService {
  
  constructor(private httpClient: Http) { }

  disciplinaUrl = 'http://localhost:8080/disciplina'

  listar(): Promise<any> {
    return this.httpClient.get(this.disciplinaUrl)
      .toPromise()
      .then(result => result.json())
  }

}
