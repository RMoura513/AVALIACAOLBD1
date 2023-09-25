package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Curso;

public class CursoDao implements IConsulta<Curso> {
	
	private GenericDao gDao;
	
	public CursoDao(GenericDao gDao) {
		this.gDao = gDao;
		
	}
	
	@Override
	public Curso buscar(Curso t) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Curso> listar() throws SQLException, ClassNotFoundException {
		List<Curso> cursos = new ArrayList<Curso>();
		Connection c = gDao.getConnection();
		String sql = "SELECT codigo, nome, cargaHoraria, siglaInterna, ultimaNotaEnade FROM curso";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Curso cr = new Curso();
			cr.setCodigo(rs.getInt("codigo"));
			cr.setNome(rs.getString("nome"));
			cr.setCargaHoraria(rs.getInt("cargaHoraria"));
			cr.setSiglaInterna(rs.getString("siglaInterna"));
			cr.setUltimaNotaEnade(rs.getInt("ultimaNotaEnade"));
			
			cursos.add(cr);
		}
		rs.close();
		ps.close();
		c.close();
		return cursos;
		
	}

}

