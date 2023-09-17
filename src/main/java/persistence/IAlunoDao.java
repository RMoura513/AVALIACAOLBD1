package persistence;

import java.sql.SQLException;

import model.Aluno;

public interface IAlunoDao {

	public String iudAluno(String acao, Aluno al) throws SQLException, ClassNotFoundException;
	
}
