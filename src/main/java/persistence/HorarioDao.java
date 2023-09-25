package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Disciplina;
import model.Horario;

public class HorarioDao implements IConsulta<Horario> {
	
	private GenericDao gDao;
	
	public HorarioDao(GenericDao gDao) {
		this.gDao = gDao;
		
	}
	
	@Override
	public Horario buscar(Horario t) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Horario> listar() throws SQLException, ClassNotFoundException {
		List<Horario> horarios = new ArrayList<Horario>();
		Connection c = gDao.getConnection();
		String sql = "SELECT codigo, horaInicio, horaFim, qtdAula FROM horario";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Horario ho = new Horario();
			ho.setCodigo(rs.getInt("codigo"));
			ho.setHoraInicio(rs.getString("horaInicio"));
			ho.setHoraFim(rs.getString("horaFim"));
			ho.setQtdAula(rs.getInt("qtdAula"));
			
			horarios.add(ho);
		}
		rs.close();
		ps.close();
		c.close();
		return horarios;
		
	}

}

