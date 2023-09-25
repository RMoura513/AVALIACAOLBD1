package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conteudo;

public class ConteudoDao implements IConsulta<Conteudo> {
	
	private GenericDao gDao;
	
	public ConteudoDao(GenericDao gDao) {
		this.gDao = gDao;
		
	}
	
	@Override
	public Conteudo buscar(Conteudo t) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Conteudo> listar() throws SQLException, ClassNotFoundException {
		List<Conteudo> conteudos = new ArrayList<Conteudo>();
		Connection c = gDao.getConnection();
		String sql = "SELECT codigo, disciplinaCodigo, descricao FROM conteudo";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Conteudo co = new Conteudo();
			co.setCodigo(rs.getInt("codigo"));
			co.setDisciplinaCodigo(rs.getInt("disciplinaCodigo"));
			co.setDescricao(rs.getString("descricao"));
			
			conteudos.add(co);
		}
		rs.close();
		ps.close();
		c.close();
		return conteudos;
		
	}

}

