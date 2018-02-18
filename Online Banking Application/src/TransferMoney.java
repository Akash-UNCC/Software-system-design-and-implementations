import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TransferMoney
 */
@WebServlet("/TransferMoney")
public class TransferMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//HttpSession session=request.getSession(false);
		//UserBean myName=(UserBean) session.getAttribute("currentSessionUser");
		
		
		 UserBean user = new UserBean();
		 user =  (UserBean) request.getSession(false).getAttribute("currentSessionUser");
		 //UserBean user = new UserBean();
		 //user.setUserName();
	     user.setAccount(request.getParameter("acc"));
	     user.setAmount(request.getParameter("amo"));
	     //HttpSession session = request.getSession();
	     // String myName1 = (String)session.getAttribute("currentSessionUser");
	     //user.setUserName(myName1);
	     //System.out.println(myName1);
	     //System.out.println("user.getUsername()::::::"+myName1);
	     //user.setUserName(myName1);
	      String new_balance= TransferDAO.login(user);
	     
	     request.setAttribute("new_balance",new_balance);
         RequestDispatcher rd= request.getRequestDispatcher("DisplayNewBalance.jsp");
         rd.forward(request, response); 
	     
	     
	}



}
