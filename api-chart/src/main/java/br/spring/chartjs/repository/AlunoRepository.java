package br.spring.chartjs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.spring.chartjs.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
