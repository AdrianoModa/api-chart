package br.spring.chartjs.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import br.spring.chartjs.model.Aluno;
import br.spring.chartjs.repository.AlunoRepository;

@RestController
@RequestMapping("/aluno")
@CrossOrigin("${origem-permitida}")
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping
	public List<Aluno> listarTodos(){
		return alunoRepository.findAll();
	}
	
	@PostMapping
	public Aluno adicionarAluno(@RequestBody @Valid Aluno aluno){
		return alunoRepository.save(aluno);
	}
	
	@PutMapping
	public ResponseEntity<?> atualizarAluno(@RequestBody @Valid Aluno aluno){
		Aluno alunoExistente = alunoRepository.findOne(aluno.getId());
		Optional.ofNullable(alunoExistente).orElseThrow(() -> new RestClientException("Erro: O Aluno não existe!"));
		alunoRepository.save(aluno);
		return ResponseEntity.status(HttpStatus.OK).body(aluno);
	}
	
	@DeleteMapping
	public ResponseEntity<?> removerAluno(Long id){
		Aluno alunoExistente = alunoRepository.findOne(id);
		Optional.ofNullable(alunoExistente).orElseThrow(() -> new RestClientException("Erro: O Aluno não existe!"));
		alunoRepository.delete(alunoExistente.getId());
		return ResponseEntity.status(204).build();
	}

}
