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

public class AlunoDao implements IConsulta<Aluno>, IAlunoDao {
	
	private GenericDao gDao;
	
	public AlunoDao(GenericDao gDao) {
		this.gDao = gDao;
		
	}
	
	@Override
	public Aluno buscar(Aluno al) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "SELECT RA, CPF, nome, nomeSocial, dataNascimento, tel, emailPes, emailCor, dataConclusaoSeg, "
				+ "instituicaoConclusaoSeg, pontuacaoVestibular, posicaoVestibular, semestreIngresso, anoIngresso, "
				+ "semestreLimiteGrad, anoLimiteGrad FROM aluno WHERE RA = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, al.getRA());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			al.setRA(rs.getInt("RA"));
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
			al.setSemestreIngresso(rs.getInt("semestreIngresso"));
			al.setAnoIngresso(rs.getInt("anoIngresso"));
			al.setSemestreLimiteGrad(rs.getInt("semestreLimiteGrad"));
			al.setAnoLimiteGrad(rs.getInt("anoLimiteGrad"));
		
		
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
		String sql = "SELECT RA, CPF, nome, nomeSocial, dataNascimento, tel, emailPes, emailCor, dataConclusaoSeg, "
				+ "instituicaoConclusaoSeg, pontuacaoVestibular, posicaoVestibular, semestreIngresso, anoIngresso, "
				+ "semestreLimiteGrad, anoLimiteGrad FROM aluno";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Aluno al = new Aluno();
			al.setRA(rs.getInt("RA"));
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
			al.setSemestreIngresso(rs.getInt("semestreIngresso"));
			al.setAnoIngresso(rs.getInt("anoIngresso"));
			al.setSemestreLimiteGrad(rs.getInt("semestreLimiteGrad"));
			al.setAnoLimiteGrad(rs.getInt("anoLimiteGrad"));
			
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
		String sql = "{CALL sp_crud_aluno (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }";
		
	      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.US);
	      String string_data_nasc = al.getDataNascimento().format(dtf);
	      String string_data_con = al.getDataConclusaoSeg().format(dtf);
		
		CallableStatement cs = c.prepareCall(sql);
		cs.setString(1, acao);
		cs.setInt(2, al.getRA());
		cs.setString(3, al.getCPF());
		cs.setString(4, al.getNome());
		cs.setString(5, al.getNomeSocial());
		cs.setString(6, string_data_nasc);
		cs.setInt(7, al.getTel());
		cs.setString(8, al.getEmailPes());
		cs.setString(9, al.getEmailCor());
		cs.setString(10, string_data_con);
		cs.setString(11, al.getInstituicaoConclusaoSeg());
		cs.setFloat(12, al.getPontuacaoVestibular());
		cs.setInt(13, al.getPosicaoVestibular());
		cs.setInt(14, al.getSemestreIngresso());
		cs.setInt(15, al.getAnoIngresso());
		cs.setInt(16, al.getSemestreLimiteGrad());
		cs.setInt(17, al.getAnoLimiteGrad());
		cs.registerOutParameter(18, Types.VARCHAR);
		
		cs.execute();
		String saida = cs.getString(18);
		cs.close();
		c.close();
		
		return saida;
		
	}
	
}

