package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Banco;
import model.vo.CaracPerImovelVo;

public class CaracPerImovelDao {
	
	public ArrayList<CaracPerImovelVo> getCarcPerImovelDao(int idimovel) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<CaracPerImovelVo> caracPerImovels = new ArrayList<CaracPerImovelVo>();
		String query = "select c.nome, ci.valor from carac_imovel as ci inner join caracteristica as c on c.idcaracteristica = ci.idcaracteristica where ci.idimovel = " + idimovel;
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				CaracPerImovelVo caracPerImovelsVo = new CaracPerImovelVo();
				caracPerImovelsVo.setCaracteristica(resultado.getString(1));
				caracPerImovelsVo.setValor(resultado.getInt(2));
				caracPerImovels.add(caracPerImovelsVo);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Todos os CaracImovel");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return caracPerImovels;
	}

}
