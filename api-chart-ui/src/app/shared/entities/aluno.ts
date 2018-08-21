import { Disciplina } from './disciplina';

export class Aluno {

    id: number
    nome: string
    disciplinas: Disciplina = new Disciplina()
}
