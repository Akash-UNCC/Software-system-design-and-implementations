import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AccountBalance")
public class AccountBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 UserBean user = new UserBean();
		 user =  (UserBean) request.getSession(false).getAttribute("currentSessionUser");
		 
		     String bal = AccountDAO.login(user);
		     System.out.println("hi bal >>>>  "+bal);
	
		     
		       request.setAttribute("balance",bal);
	           RequestDispatcher rd= request.getRequestDispatcher("Balance.jsp");
	           rd.forward(request, response); 
			 
        
		
	}

	

}
