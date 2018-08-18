import { Injectable } from '@angular/core';
import { Http } from '@angular/http'

import 'rxjs/add/operator/toPromise'

@Injectable()
export class AlunoService {

  constructor(private httpClient: Http) { }

  alunoUrl = 'http://localhost:8080/aluno'

  listar(): Promise<any> {
    return this.httpClient.get(this.alunoUrl)
      .toPromise()
      .then(response => response.json())
  }

}
