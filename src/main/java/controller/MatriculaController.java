package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Disciplina;
import model.Matricula;
import persistence.DisciplinaDao;
import persistence.GenericDao;
import persistence.MatriculaDao;

@WebServlet("/matricula")
public class MatriculaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MatriculaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String erro = "";
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();

		GenericDao gDao = new GenericDao();
		DisciplinaDao dDao = new DisciplinaDao(gDao);

		try {
			disciplinas = dDao.listar();
		} catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		} finally {
			request.setAttribute("erro", erro);
			request.setAttribute("disciplinas", disciplinas);

			RequestDispatcher rd = request.getRequestDispatcher("matricula.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// entrada
		String cmd = request.getParameter("botao");
		String alunoRA = request.getParameter("alunoRA");
		String disciplinaCodigo = request.getParameter("disciplinaCodigo");
		String situacao = request.getParameter("situacao");
		String diaSemana = request.getParameter("diaSemana");

		// retorno
		String saida = "";
		String erro = "";
		Matricula ma = new Matricula();
		List<Matricula> matriculas = new ArrayList<>();

		if (!cmd.contains("Listar")) {
			ma.setAlunoRA(Integer.parseInt(alunoRA));
		}
		try {

			if (cmd.contains("Cadastrar") || cmd.contains("Alterar")) {
				ma.setAlunoRA(Integer.parseInt(alunoRA));
				ma.setDisciplinaCodigo(Integer.parseInt(disciplinaCodigo));
				ma.setSituacao(situacao);
				ma.setDiaSemana(diaSemana);

			}

			if (cmd.contains("Cadastrar")) {
				saida = cadastrarMatricula(ma);
				ma = null;
			}
			if (cmd.contains("Buscar")) {
				ma = buscarMatricula(ma);
			}
			if (cmd.contains("Listar")) {
				matriculas = listarMatricula();
			}

		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("matricula", ma);
			request.setAttribute("matriculas", matriculas);

			RequestDispatcher rd = request.getRequestDispatcher("matricula.jsp");
			rd.forward(request, response);

		}

	}

	private String cadastrarMatricula(Matricula ma) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		MatriculaDao mDao = new MatriculaDao(gDao);
		String saida = mDao.iudMatricula("I", ma);

		return saida;
	}


	private Matricula buscarMatricula(Matricula ma) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		MatriculaDao mDao = new MatriculaDao(gDao);
		mDao.buscar(ma);
		return ma;
	}

	private List<Matricula> listarMatricula() throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		MatriculaDao mDao = new MatriculaDao(gDao);
		List<Matricula> matriculas = mDao.listar();
		return matriculas;
	}
}
