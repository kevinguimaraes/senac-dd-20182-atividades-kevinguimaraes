package controller;

import model.bo.AlunoBO;
import model.vo.Aluno;

public class ControladorAluno {
	public int cadastrarAlunoController(Aluno a) {
		//FuncionarioBo funcionarioBo = new FuncionarioBo();
		AlunoBO alunoBo = new AlunoBO();
		return alunoBo.salvarAluno(a);
		
	}
	
	public double calcularMediaFinal(Aluno a) {
		AlunoBO alunoBo = new AlunoBO();
		return alunoBo.calcularMediaFinal(a);
	}
	
	public int calcularSituacao(Aluno a) {
		AlunoBO alunoBo = new AlunoBO();
				
		return alunoBo.calcularSituacao(a);
	}
	
	public boolean verificaPorMatricula(String m)
	{
		AlunoBO alunoBo = new AlunoBO();
		return alunoBo.verificaPorMatricula(m);
	}
	
}
