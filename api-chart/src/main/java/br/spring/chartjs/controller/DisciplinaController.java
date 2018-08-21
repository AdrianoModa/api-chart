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
import br.spring.chartjs.model.Disciplina;
import br.spring.chartjs.repository.DisciplinaRepository;

@RestController
@RequestMapping("/disciplina")
@CrossOrigin("${origem-permitida}")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@GetMapping
	public List<Disciplina> listarDisciplinas(){
		return disciplinaRepository.findAll();
	}
	
	@PostMapping
	public Disciplina adicionarDisciplina(@RequestBody @Valid Disciplina disciplina){
		return disciplinaRepository.save(disciplina);
	}
	
	@PutMapping
	public ResponseEntity<?> atualizarDisciplina(@RequestBody @Valid Disciplina disciplina){
		Disciplina disciplinaExistente = disciplinaRepository.findOne(disciplina.getId());
		Optional.ofNullable(disciplinaExistente).orElseThrow(() -> new RestClientException("A Disciplina não existe"));
		disciplinaRepository.save(disciplinaExistente);
		return ResponseEntity.status(HttpStatus.OK).body(disciplinaExistente);
	}
	
	@DeleteMapping
	public ResponseEntity<?> removerDisciplina(@RequestBody @Valid Long id){
		Disciplina disciplinaExistente = disciplinaRepository.findOne(id);
		Optional.ofNullable(disciplinaExistente).orElseThrow(() -> new RestClientException("A Disciplina não existe"));
		disciplinaRepository.delete(disciplinaExistente);
		return ResponseEntity.noContent().build();
	}
}