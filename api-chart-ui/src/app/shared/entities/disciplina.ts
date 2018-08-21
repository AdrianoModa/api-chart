import { Aluno } from './aluno';
export class Disciplina {

    id: number
    nomeDisciplina: string
    nota: number
    aluno: Aluno = new Aluno()
}
