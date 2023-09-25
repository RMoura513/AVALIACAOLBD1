package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import model.Matricula;

public class MatriculaDao implements IConsulta<Matricula>, IMatriculaDao {
	
	private GenericDao gDao;
	
	public MatriculaDao(GenericDao gDao) {
		this.gDao = gDao;
		
	}
	
	@Override
	public Matricula buscar(Matricula ma) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "SELECT alunoRA, disciplinaCodigo, situacao, horarioCodigo, diaSemana FROM matricula WHERE alunoRA = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, ma.getAlunoRA());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			ma.setAlunoRA(rs.getInt("alunoRA"));
			ma.setDisciplinaCodigo(rs.getInt("disciplinaCodigo"));
			ma.setSituacao(rs.getString("situacao"));
			ma.setHorarioCodigo(rs.getInt("horarioCodigo"));
			ma.setDiaSemana(rs.getString("diaSemana"));
		}
		rs.close();
		ps.close();
		c.close();
		return ma;
		
		
	}

	@Override
	public List<Matricula> listar() throws SQLException, ClassNotFoundException {
		List<Matricula> matriculas = new ArrayList<Matricula>();
		Connection c = gDao.getConnection();
		String sql = "SELECT alunoRA, disciplinaCodigo, horarioCodigo, situacao, diaSemana"
				+ " FROM matricula";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Matricula ma = new Matricula();
			ma.setAlunoRA(rs.getInt("alunoRA"));
			ma.setDisciplinaCodigo(rs.getInt("disciplinaCodigo"));	
			ma.setHorarioCodigo(rs.getInt("horarioCodigo"));
			ma.setSituacao(rs.getString("situacao"));
			ma.setDiaSemana(rs.getString("diaSemana"));
			matriculas.add(ma);
		}
		rs.close();
		ps.close();
		c.close();
		return matriculas;
		
	}
	

	@Override
	public String iudMatricula(String acao, Matricula ma) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "{CALL sp_fazer_matricula (?, ?, ?, ?, ?, ? ) }";
		
		CallableStatement cs = c.prepareCall(sql);
		cs.setString(1, acao);
		cs.setInt(2, ma.getAlunoRA());
		cs.setInt(3, ma.getDisciplinaCodigo());
		cs.setString(4, ma.getSituacao());
		cs.setString(5, ma.getDiaSemana());
		cs.registerOutParameter(6, Types.VARCHAR);
		
		cs.execute();
		String saida = cs.getString(6);
		cs.close();
		c.close();
		
		return saida;
		
	}


}

