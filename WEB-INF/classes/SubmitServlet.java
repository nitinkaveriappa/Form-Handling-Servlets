import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SubmitServlet
 */
@WebServlet("/SubmitServlet")
public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Reads the form data
		int studentid = Integer.parseInt(request.getParameter("studentid"));
		String name = request.getParameter("name");
		String streetaddress = request.getParameter("streetaddress");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		int zip = Integer.parseInt(request.getParameter("zip"));
		String telephonenumber = request.getParameter("telephonenumber");
		String email = request.getParameter("email");
		String url = request.getParameter("url");
		String dateofsurvey = request.getParameter("dateofsurvey");
		String like = request.getParameter("like");
		String interest = request.getParameter("interest");
		String comments = request.getParameter("comments");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		String recommend = request.getParameter("recommend");
		
		String data = request.getParameter("data");
		
		//Inserts the student data into the database
		StudentDAO studentDAO = new StudentDAO();
		try {
			studentDAO.addStudent(studentid, name, streetaddress, city, state, zip, telephonenumber, email, url, dateofsurvey, like, interest, comments, month, year, recommend);
		} catch (SQLException e) {
			System.out.println("Insert data error");
			e.printStackTrace();
		}
		
		//Calculates the mean and standard deviation of the data and returns a DataBean object
		DataProcessor dataprocessor = new DataProcessor();
		DataBean cData = dataprocessor.calculate(data);
		//Gets the list of students
		ArrayList<Integer> list = null;
		try {
			list = studentDAO.StudentList();
		} catch (SQLException e) {
			System.out.println("Student list retrive error");
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("cData",cData);
		session.setAttribute("list", list);
		Double mean = cData.getMean();
		RequestDispatcher dispatch;
		//IF mean is greater than 90 then redirect to winner acknowledgement 
		if(mean > 90.00)
		{
			dispatch = request.getRequestDispatcher("WinnerAcknowledgement.jsp");
		}
		else
		{
			dispatch = request.getRequestDispatcher("SimpleAcknowledgement.jsp");
		}
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int student_id = Integer.parseInt(request.getParameter("id"),10);
		
		//Gets the student data in the form of student bean
		StudentDAO studentDAO = new StudentDAO();
		StudentBean sData = null;
		try {
			sData = studentDAO.getStudent(student_id);
		} catch (SQLException e) {
			System.out.println("Student retrive error");
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		
		RequestDispatcher dispatch;
		//IF student exists then display details 
		if(sData != null)
		{
			session.setAttribute("sData",sData);
			dispatch = request.getRequestDispatcher("StudentJSP.jsp");
		}
		else
		{
			dispatch = request.getRequestDispatcher("NoSuchStudent.jsp");
		}
		dispatch.forward(request, response);
		
	}
}
