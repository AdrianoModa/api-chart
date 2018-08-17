package br.spring.chartjs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.spring.chartjs.model.Aluno;
import br.spring.chartjs.model.Disciplina;
import br.spring.chartjs.repository.AlunoRepository;
import br.spring.chartjs.repository.DisciplinaRepository;

@SpringBootApplication
public class ApiChartApplication implements CommandLineRunner {
	
	@Autowired
	AlunoRepository alunoRepository;
	@Autowired
	DisciplinaRepository disciplinaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiChartApplication.class, args);
		DateFormat df = new SimpleDateFormat("HH:mm:ss 'do dia' dd-MM-yyyy", new Locale("pt", "BR"));
		Calendar calendar = Calendar.getInstance();
		System.out.println("O projeto ApiChar está rodando às " + df.format(calendar.getTime()));
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Disciplina disciplina1 = new Disciplina(null, "Matemática", 9.8f);
		Disciplina disciplina2 = new Disciplina(null, "Português", 8.9f);
		Disciplina disciplina3 = new Disciplina(null, "História", 8.6f);
		Disciplina disciplina4 = new Disciplina(null, "Geografia", 9.2f);
		Disciplina disciplina5 = new Disciplina(null, "Inglês", 10.0f);
		
		Disciplina disciplina6 = new Disciplina(null, "Matemática", 10.0f);
		Disciplina disciplina7 = new Disciplina(null, "Português", 8.8f);
		Disciplina disciplina8 = new Disciplina(null, "História", 7.8f);
		Disciplina disciplina9 = new Disciplina(null, "Geografia", 9.5f);
		Disciplina disciplina10 = new Disciplina(null, "Inglês", 10.0f);
		
		List<Disciplina> disciplinas1 = new ArrayList<>();
		disciplinas1.add(disciplina1);
		disciplinas1.add(disciplina2);
		disciplinas1.add(disciplina3);
		disciplinas1.add(disciplina4);
		disciplinas1.add(disciplina5);
		
		List<Disciplina> disciplinas2 = new ArrayList<>();
		disciplinas2.add(disciplina6);
		disciplinas2.add(disciplina7);
		disciplinas2.add(disciplina8);
		disciplinas2.add(disciplina9);
		disciplinas2.add(disciplina10);
		
		Aluno aluno1 = new Aluno(null, "Adriano Moda", disciplinas1);
		Aluno aluno2 = new Aluno(null, "Bruna Adriane", disciplinas2);
		
		disciplinaRepository.save(Arrays.asList(disciplina1, disciplina2, disciplina3, disciplina4, disciplina5, 
				disciplina6, disciplina7, disciplina8, disciplina9, disciplina10));	
		alunoRepository.save(Arrays.asList(aluno1, aluno2));
		
		
		
	}
}