package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Disciplina;

public class DisciplinaDao implements IConsulta<Disciplina> {
	
	private GenericDao gDao;
	
	public DisciplinaDao(GenericDao gDao) {
		this.gDao = gDao;
		
	}
	
	@Override
	public Disciplina buscar(Disciplina di) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "SELECT codigo, cursoCodigo, horarioCodigo, nome, qtdHorasSemanais FROM Disciplina WHERE codigo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, di.getCodigo());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			di.setCodigo(rs.getInt("codigo"));
			di.setCursoCodigo(rs.getInt("cursoCodigo"));
			di.setHorarioCodigo(rs.getInt("horarioCodigo"));
			di.setNome(rs.getString("nome"));
			di.setQtdHorasSemanais(rs.getInt("qtdHorasSemanais"));
		
		}
		rs.close();
		ps.close();
		c.close();
		return di;
		
		
	}

	@Override
	public List<Disciplina> listar() throws SQLException, ClassNotFoundException {
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		Connection c = gDao.getConnection();
		String sql = "SELECT codigo, cursoCodigo, horarioCodigo, nome, qtdHorasSemanais FROM disciplina";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Disciplina di = new Disciplina();
			di.setCodigo(rs.getInt("codigo"));
			di.setCursoCodigo(rs.getInt("cursoCodigo"));
			di.setHorarioCodigo(rs.getInt("horarioCodigo"));
			di.setNome(rs.getString("nome"));
			di.setQtdHorasSemanais(rs.getInt("qtdHorasSemanais"));
			
			disciplinas.add(di);
		}
		rs.close();
		ps.close();
		c.close();
		return disciplinas;
		
	}

}

