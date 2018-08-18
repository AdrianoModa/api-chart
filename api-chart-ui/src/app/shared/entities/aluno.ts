import { Disciplina } from './disciplina';

export class Aluno {

    id: number
    nome: string
    disciplina: Disciplina = new Disciplina()
}
