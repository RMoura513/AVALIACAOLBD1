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
import model.Horario;
import persistence.GenericDao;
import persistence.HorarioDao;
import persistence.DisciplinaDao;


@WebServlet("/horario")
public class HorarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public HorarioController() {
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("horario.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//entrada
		String cmd = request.getParameter("botao");
		String codigo = request.getParameter("codigo");
		String horaInicio = request.getParameter("horaInicio");
		String horaFim = request.getParameter("horaFim");
		String qtdAula = request.getParameter("qtdAula");
	
		//retorno
		String saida = "";
		String erro = "";
		Horario ho = new Horario();
		List<Horario> horarios = new ArrayList<>();
		

		try {
			if (cmd.contains("Listar")) {
				horarios = listarHorario();
			}
			
		}catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("horario", ho);
			request.setAttribute("horarios", horarios);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("horario.jsp");
			rd.forward(request, response);
			
		}
		
		
	}

	private List<Horario> listarHorario() throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		HorarioDao hDao = new HorarioDao(gDao);
		List<Horario> horarios = hDao.listar();
		return horarios;	
	}
}
