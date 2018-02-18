import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AccountSummary")
public class AccountSummary extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Date date_to, date_from;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 UserBean user = new UserBean();
		 user =  (UserBean) request.getSession(false).getAttribute("currentSessionUser");
		       //UserBean user = new UserBean();
		        String to = request.getParameter("to");
		        String from = request.getParameter("from");
		        
		        System.out.println("to ="+to);
		        System.out.println("from ="+from);
	          /*  Date to =user.setTo();
	          // request.getParameter("to");
	           Date from =user.setFrom(request.getParameter("from"));*/
		        /*DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		       
				try {
					date_to = format.parse(to);
					date_from =  format.parse(from);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        //System.out.println(date);
*/				user.setTo(to);
				user.setFrom(from);
			  SummaryPOJO po = new  SummaryPOJO();
	          List<SummaryPOJO> res= AccSummaryDAO.login(user);
	         
			
	          request.setAttribute("my_summary",res);
			  RequestDispatcher rd = request.getRequestDispatcher("DisplayAccountSummary.jsp");
			  rd.forward(request, response);
        

}
}
