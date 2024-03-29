package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Matricula;

public interface IConsulta <T> {
	
	public T buscar(T t) throws SQLException, ClassNotFoundException;
	public List<T> listar()throws SQLException, ClassNotFoundException;

}
