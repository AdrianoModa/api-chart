package br.spring.chartjs.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Disciplina implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nomeDisciplina;
	private Float nota;
	@ManyToOne	
	private Aluno aluno;
	
	public Disciplina() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Disciplina(Long id, String nomeDisciplina, Float nota) {
		super();
		this.id = id;
		this.nomeDisciplina = nomeDisciplina;
		this.nota = nota;
	}

	public Disciplina(Long id, String nomeDisciplina, Float nota, Aluno aluno) {
		super();
		this.id = id;
		this.nomeDisciplina = nomeDisciplina;
		this.nota = nota;
		this.aluno = aluno;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public Float getNota() {
		return nota;
	}

	public void setNota(Float nota) {
		this.nota = nota;
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disciplina [id=" + id + ", nomeDisciplina=" + nomeDisciplina + ", nota=" + nota + ", aluno=" + aluno
				+ "]";
	}	
}