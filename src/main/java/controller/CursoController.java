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
import model.Curso;
import persistence.GenericDao;
import persistence.CursoDao;


@WebServlet("/curso")
public class CursoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public CursoController() {
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("curso.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//entrada
		String cmd = request.getParameter("botao");
		String codigo = request.getParameter("codigo");
		String nome = request.getParameter("nome");
		String cargaHoraria = request.getParameter("cargaHoraria");
		String siglaInterna = request.getParameter("silgaInterna");
		String ultimaNotaEnade = request.getParameter("ultimaNotaEnade");
		
		//retorno
		String saida = "";
		String erro = "";
		Curso cr = new Curso();
		List<Curso> cursos = new ArrayList<>();
		

		try {
			if (cmd.contains("Listar")) {
				cursos = listarCurso();
			}
			
		}catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("curso", cr);
			request.setAttribute("cursos", cursos);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("curso.jsp");
			rd.forward(request, response);
			
		}
		
		
	}

	private List<Curso> listarCurso() throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		CursoDao cDao = new CursoDao(gDao);
		List<Curso> cursos = cDao.listar();
		return cursos;	
	}
}
