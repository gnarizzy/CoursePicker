package servlet;
import helper.Course;
import helper.CourseHelper;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CourseController
 */
@WebServlet("/CourseController")
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name =request.getParameter("name");
		String major = request.getParameter("major");
		String email = request.getParameter("email");
		
		
		String url = "/index.jsp";
		
		if(name.length() != 0 && major.length() != 0 && email.length() != 0) {
			url = "/home.jsp";		
		}
		
		

		if(request.getParameter("View Schedule") != null) {
			url = "/schedule.jsp";
		
		}
		
		request.setAttribute("name", name);
		request.setAttribute("major", major);
		request.setAttribute("email", email);
		
		
		ServletContext sc = getServletContext();
	    RequestDispatcher rd = sc.getRequestDispatcher(url);

	    rd.forward(request, response);
		
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("callNumber") != null){
			//WHEN YOU ADD COURSE IT WILL COME HERE THIS IS WHERE WE IMPLEMENT THE SCHEDULE.JAVA CLASS
			
			ServletContext sc = getServletContext();
		    RequestDispatcher rd = sc.getRequestDispatcher("/requirement.jsp");
		    rd.forward(request, response);
		    return;
		}
		
				if(request.getParameter("reqID") != ""){
					ServletContext sc = getServletContext();
				    RequestDispatcher rd = sc.getRequestDispatcher("/requirement.jsp");
				    
				    ArrayList<Course> a = new ArrayList<Course>();
				    CourseHelper cH = new CourseHelper();
				    
				    int id = Integer.parseInt(request.getParameter("reqID"));
				    
				    System.out.println(id);
				    System.out.println(id);
				    System.out.println(id);
				    System.out.println(id);
				    
				    a = cH.getCourseWithRequirementList(id);
				    
				    request.setAttribute("list", a);

				    rd.forward(request, response);
				    return;
				}

				else{
					ServletContext sc = getServletContext();
				    RequestDispatcher rd = sc.getRequestDispatcher("/home.jsp");
				    
				    rd.forward(request, response);
				    return;
				}
	}

}
