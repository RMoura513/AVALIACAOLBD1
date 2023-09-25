package persistence;

import java.sql.SQLException;

import model.Matricula;

public interface IMatriculaDao {

	public String iudMatricula(String acao, Matricula ma) throws SQLException, ClassNotFoundException;
	
}
