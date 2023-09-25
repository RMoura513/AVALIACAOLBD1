package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import model.Aluno;
import model.Matricula;

public class AlunoDao implements IConsulta<Aluno>, IAlunoDao {
	
	private GenericDao gDao;
	
	public AlunoDao(GenericDao gDao) {
		this.gDao = gDao;
		
	}
	
	@Override
	public Aluno buscar(Aluno al) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "SELECT RA, cursoCodigo, turno, CPF, nome, nomeSocial, dataNascimento, tel, emailPes, emailCor, dataConclusaoSeg, "
				+ "instituicaoConclusaoSeg, pontuacaoVestibular, posicaoVestibular, dataIngresso ,semestreAnoIngresso, "
				+ "semestreAnoLimiteGrad FROM aluno WHERE RA = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, al.getRA());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			al.setRA(rs.getInt("RA"));
			al.setCursoCodigo(rs.getInt("cursoCodigo"));
			al.setTurno(rs.getString("turno"));
			al.setCPF(rs.getString("CPF"));
			al.setNome(rs.getString("nome"));
			al.setNomeSocial(rs.getString("nomeSocial"));
			al.setDataNascimento(LocalDate.parse(rs.getString("dataNascimento")));
			al.setTel(rs.getInt("tel"));
			al.setEmailPes(rs.getString("emailPes"));
			al.setEmailCor(rs.getString("emailCor"));
			al.setDataConclusaoSeg(LocalDate.parse(rs.getString("dataConclusaoSeg")));
			al.setInstituicaoConclusaoSeg(rs.getString("instituicaoConclusaoSeg"));
			al.setPontuacaoVestibular(rs.getFloat("pontuacaoVestibular"));
			al.setPosicaoVestibular(rs.getInt("posicaoVestibular"));
			al.setDataIngresso(LocalDate.parse(rs.getString("dataIngresso")));
			al.setSemestreAnoIngresso(rs.getString("semestreAnoIngresso"));
			al.setSemestreAnoLimiteGrad(rs.getString("semestreAnoLimiteGrad"));
		
		
		}
		rs.close();
		ps.close();
		c.close();
		return al;
		
		
	}

	@Override
	public List<Aluno> listar() throws SQLException, ClassNotFoundException {
		List<Aluno> alunos = new ArrayList<Aluno>();
		Connection c = gDao.getConnection();
		String sql = "SELECT RA, cursoCodigo, turno, CPF, nome, nomeSocial, dataNascimento, tel, emailPes, emailCor, dataConclusaoSeg, "
				+ "instituicaoConclusaoSeg, pontuacaoVestibular, posicaoVestibular, semestreAnoIngresso, semestreAnoLimiteGrad "
				+ "FROM aluno";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Aluno al = new Aluno();
			al.setRA(rs.getInt("RA"));
			al.setCursoCodigo(rs.getInt("cursoCodigo"));
			al.setTurno(rs.getString("turno"));
			al.setCPF(rs.getString("CPF"));
			al.setNome(rs.getString("nome"));
			al.setNomeSocial(rs.getString("nomeSocial"));
			al.setDataNascimento(LocalDate.parse(rs.getString("dataNascimento")));
			al.setTel(rs.getInt("tel"));
			al.setEmailPes(rs.getString("emailPes"));
			al.setEmailCor(rs.getString("emailCor"));
			al.setDataConclusaoSeg(LocalDate.parse(rs.getString("dataConclusaoSeg")));
			al.setInstituicaoConclusaoSeg(rs.getString("instituicaoConclusaoSeg"));
			al.setPontuacaoVestibular(rs.getFloat("pontuacaoVestibular"));
			al.setPosicaoVestibular(rs.getInt("posicaoVestibular"));
			al.setSemestreAnoIngresso(rs.getString("semestreAnoIngresso"));
			al.setSemestreAnoLimiteGrad(rs.getString("semestreAnoLimiteGrad"));
			
			alunos.add(al);
		}
		rs.close();
		ps.close();
		c.close();
		return alunos;
		
	}
	

	@Override
	public String iudAluno(String acao, Aluno al) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "{CALL sp_crud_aluno (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }";
		
	      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.US);
	      String string_data_nasc = al.getDataNascimento().format(dtf);
	      String string_data_con = al.getDataConclusaoSeg().format(dtf);
	      String string_data_ing = al.getDataIngresso().format(dtf);
		
		CallableStatement cs = c.prepareCall(sql);
		cs.setString(1, acao);
		cs.setInt(2, al.getRA());
		cs.setInt(3, al.getCursoCodigo());
		cs.setString(4, al.getTurno());
		cs.setString(5, al.getCPF());
		cs.setString(6, al.getNome());
		cs.setString(7, al.getNomeSocial());
		cs.setString(8, string_data_nasc);
		cs.setInt(9, al.getTel());
		cs.setString(10, al.getEmailPes());
		cs.setString(11, al.getEmailCor());
		cs.setString(12, string_data_con);
		cs.setString(13, al.getInstituicaoConclusaoSeg());
		cs.setFloat(14, al.getPontuacaoVestibular());
		cs.setInt(15, al.getPosicaoVestibular());
		cs.setString(16, string_data_ing);
		cs.registerOutParameter(17, Types.VARCHAR);
		
		cs.execute();
		String saida = cs.getString(17);
		cs.close();
		c.close();
		
		return saida;
		
	}
	
}

