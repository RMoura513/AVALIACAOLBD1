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
import model.Aluno;
import model.Disciplina;
import persistence.GenericDao;
import persistence.AlunoDao;
import persistence.DisciplinaDao;


@WebServlet("/disciplina")
public class DisciplinaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public DisciplinaController() {
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("disciplina.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//entrada
		String cmd = request.getParameter("botao");
		String codigo = request.getParameter("codigo");
		String cursoCodigo = request.getParameter("cursoCodigo");
		String horarioCodigo = request.getParameter("horarioCodigo");
		String nome = request.getParameter("nome");
		String qtdHorasSemanais = request.getParameter("qtdhorasSemanais");
		
		//retorno
		String saida = "";
		String erro = "";
		Disciplina di = new Disciplina();
		List<Disciplina> disciplinas = new ArrayList<>();
		

		try {
		if (cmd.contains("Buscar")) {
			di = buscarDisciplina(di);
		}
			if (cmd.contains("Listar")) {
				disciplinas = listarDisciplina();
			}
			
		}catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("disciplina", di);
			request.setAttribute("disciplinas", disciplinas);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("disciplina.jsp");
			rd.forward(request, response);
			
		}
		
		
	}
	
	private Disciplina buscarDisciplina(Disciplina di) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		DisciplinaDao dDao = new DisciplinaDao(gDao);
		dDao.buscar(di);
		return di;
	}

	private List<Disciplina> listarDisciplina() throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		DisciplinaDao dDao = new DisciplinaDao(gDao);
		List<Disciplina> disciplinas = dDao.listar();
		return disciplinas;	
	}
}
