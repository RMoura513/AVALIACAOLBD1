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
import model.Conteudo;
import persistence.GenericDao;
import persistence.ConteudoDao;


@WebServlet("/conteudo")
public class ConteudoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ConteudoController() {
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("conteudo.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//entrada
		String cmd = request.getParameter("botao");
		String codigo = request.getParameter("codigo");
		String disciplinaCodigo = request.getParameter("disciplinaCodigo");
		String descricao = request.getParameter("descricao");
		
		//retorno
		String saida = "";
		String erro = "";
		Conteudo co = new Conteudo();
		List<Conteudo> conteudos = new ArrayList<>();
		
		try {
			if (cmd.contains("Listar")) {
				conteudos = listarConteudo();
			}
			
		}catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("conteudo", co);
			request.setAttribute("conteudos", conteudos);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("conteudo.jsp");
			rd.forward(request, response);
			
		}
		
		
	}

	private List<Conteudo> listarConteudo() throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		ConteudoDao cDao = new ConteudoDao(gDao);
		List<Conteudo> conteudos = cDao.listar();
		return conteudos;	
	}
}
