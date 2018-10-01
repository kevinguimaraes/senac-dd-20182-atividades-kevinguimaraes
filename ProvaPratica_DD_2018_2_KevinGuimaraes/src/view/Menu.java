package view;

import model.bo.AlunoBO;
import model.vo.Aluno;

public class Menu {
	
	public static void main(String[] args) {
		AlunoBO bo = new AlunoBO();
		Aluno novoAluno = new Aluno();
		novoAluno.setMatricula("11");
		novoAluno.setNome("Edson");
		novoAluno.setNotaProva1(10);
		novoAluno.setNotaProva1(9.25);
		novoAluno.setPeson(20);
		novoAluno.setTrab1(18);
		novoAluno.setTrab2(50);
		novoAluno.setPesot(54);
		novoAluno.setNivel("Avancado");
		novoAluno.setSobrenome("asdasda");
		
		bo.salvarAluno(novoAluno);
	}
}