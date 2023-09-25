package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Aluno;
import persistence.GenericDao;
import persistence.AlunoDao;


@WebServlet("/aluno")
public class AlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public AlunoController() {
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("aluno.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//entrada
		String cmd = request.getParameter("botao");
		String ra = request.getParameter("RA");
		String cursoCodigo = request.getParameter("cursoCodigo");
		String turno = request.getParameter("turno");
		String cpf = request.getParameter("CPF");
		String nome = request.getParameter("nome");
		String nomeSocial = request.getParameter("nomeSocial");
		String dataNascimento = request.getParameter("dataNascimento");
		String tel = request.getParameter("tel");
		String emailPes = request.getParameter("emailPes");
		String emailCor = request.getParameter("emailCor");
		String dataConclusaoSeg = request.getParameter("dataConclusaoSeg");
		String instituicaoConclusaoSeg = request.getParameter("instituicaoConclusaoSeg");
		String pontuacaoVestibular = request.getParameter("pontuacaoVestibular");
		String posicaoVestibular = request.getParameter("posicaoVestibular");
		String dataIngresso = request.getParameter("dataIngresso");
		String semestreAnoIngresso = request.getParameter("semestreAnoIngresso");
		String semestreAnoLimiteGrad = request.getParameter("semestreAnoLimiteGrad");
		
		//retorno
		String saida = "";
		String erro = "";
		Aluno al = new Aluno();
		List<Aluno> alunos = new ArrayList<>();
		
		if (!cmd.contains("Listar")){
			al.setRA(Integer.parseInt(ra));
		}
		if (cmd.contains("Cadastrar") || cmd.contains("Alterar")) {
			
			LocalDate data_nasc = (LocalDate.parse(dataNascimento));
			LocalDate data_con = (LocalDate.parse(dataConclusaoSeg));
			LocalDate data_ing = (LocalDate.parse(dataIngresso));
	
			al.setRA(Integer.parseInt(ra));
			al.setCursoCodigo(Integer.parseInt(cursoCodigo));
			al.setTurno(turno);
			al.setCPF(cpf);
			al.setNome(nome);
			al.setNomeSocial(nomeSocial);
			al.setDataNascimento(data_nasc);
			al.setTel(Integer.parseInt(tel));
			al.setEmailPes(emailPes);
			al.setEmailCor(emailCor);
			al.setDataConclusaoSeg(data_con);
			al.setInstituicaoConclusaoSeg(instituicaoConclusaoSeg);
			al.setPontuacaoVestibular(Float.parseFloat(pontuacaoVestibular));
			al.setPosicaoVestibular(Integer.parseInt(posicaoVestibular));
			al.setDataIngresso(data_ing);
			al.setSemestreAnoIngresso(semestreAnoIngresso);
			al.setSemestreAnoLimiteGrad(semestreAnoLimiteGrad);
			
		}
			
		try {
			if (cmd.contains("Cadastrar")) {
				saida = cadastrarAluno(al);
				al = null;
			}
			if (cmd.contains("Alterar")) {
				saida = alterarAluno(al);
				al = null;
			}
			if (cmd.contains("Excluir")) {
				excluirAluno(al);
				al = null;
			}
			if (cmd.contains("Buscar")) {
				al = buscarAluno(al);
			}
			if (cmd.contains("Listar")) {
				alunos = listarAluno();
			}
			
		}catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("aluno", al);
			request.setAttribute("alunos", alunos);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("aluno.jsp");
			rd.forward(request, response);
			
		}
		
		
	}

	private String cadastrarAluno(Aluno al) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		AlunoDao aDao = new AlunoDao(gDao);
		String saida = aDao.iudAluno("I", al);
		
		return saida;
	}

	private String alterarAluno(Aluno al) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		AlunoDao aDao = new AlunoDao(gDao);
		String saida = aDao.iudAluno("U", al);
		
		return saida;
		}

	private String excluirAluno(Aluno al) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		AlunoDao aDao = new AlunoDao(gDao);
		String saida = aDao.iudAluno("D", al);
		
		return saida;
		}

	private Aluno buscarAluno(Aluno al) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		AlunoDao aDao = new AlunoDao(gDao);
		aDao.buscar(al);
		return al;
	}

	private List<Aluno> listarAluno() throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		AlunoDao aDao = new AlunoDao(gDao);
		List<Aluno> alunos = aDao.listar();
		return alunos;	
	}
}
