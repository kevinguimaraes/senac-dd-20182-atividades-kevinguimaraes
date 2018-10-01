package model.bo;

import model.dao.AlunoDAO;
import model.vo.Aluno;

public class AlunoBO {
	
	private AlunoDAO aDAO = new AlunoDAO();

	public int calcularSituacao(Aluno a) {
		if(this.calcularMediaFinal(a) >= 7)
			return 1;
		else if(this.calcularMediaFinal(a) >= 4.5)
			return 2;
		else
			return 3;
		
	}
	
	public double calcularMediaFinal(Aluno aluno){
		double mediaP = ((aluno.getNotaProva1() + aluno.getNotaProva2()) * (aluno.getPeson())/100) / 2;
		double mediaT = ((aluno.getTrab1() + aluno.getTrab2()) * (aluno.getPesot())/100) / 2;
		return mediaP + mediaT;
	}
	

	public int salvarAluno(Aluno novoAluno){
		return this.aDAO.inserir(novoAluno);
	}
	
	public boolean verificaPorMatricula(String m) {
		return this.aDAO.verificaPorMatricula(m);
	}
}
