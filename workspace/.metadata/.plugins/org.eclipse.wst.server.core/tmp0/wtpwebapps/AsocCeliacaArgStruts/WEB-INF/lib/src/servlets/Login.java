package servlets;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Hashtable<String, String> logins;  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		logins = new Hashtable<String, String>();
		logins.put("socio", config.getInitParameter("socio"));
		logins.put("opUnidad", config.getInitParameter("opUnidad"));
		logins.put("adminUnidad", config.getInitParameter("adminUnidad"));
		logins.put("socioVirtual", config.getInitParameter("socioVirtual"));
		logins.put("opCentral", config.getInitParameter("opCentral"));
		logins.put("adminCentral", config.getInitParameter("adminCentral"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = request.getParameter("usuario");
		String pass = request.getParameter("pass");
		
		
		if ((logins.contains(usuario)) && (logins.get(usuario).equals(pass))){			
			HttpSession sesion = request.getSession();
			sesion.setAttribute("usuario", request.getParameter("usuario"));
			response.sendRedirect(usuario + "/index.html");
			return;
		}		
		response.sendRedirect("index.html");
		return;
	}

}
