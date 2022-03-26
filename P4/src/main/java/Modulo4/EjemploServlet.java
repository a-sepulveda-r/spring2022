package Modulo4;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EjemploServlet
 */
@WebServlet("/EjemploServlet")
public class EjemploServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EjemploServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        Connection conn;
        String vret = null;

		try {
			// Inicializa Conexion
			conn = DBConnection.initializeDatabase();
			
			// Utiliza el select del Crud
			switch(request.getParameter("operation")) {
				case "select":
					vret = TitleTypes.select(conn,Integer.parseInt(request.getParameter("title_no")));
					break;
				case "insert":
					if(TitleTypes.insert(conn,Integer.parseInt(request.getParameter("title_no")),request.getParameter("title"))) {
						vret = "Exito";
					};
					break;
				case "update":	
					if(TitleTypes.update(conn,Integer.parseInt(request.getParameter("title_no")),request.getParameter("title"))) {
						vret = "Exito";
					};
					break;
				case "delete":	
					if(TitleTypes.delete(conn,Integer.parseInt(request.getParameter("title_no")))){
						vret = "Exito";
					};
					break;
					
					
			};
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		response.getWriter().append(vret);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}