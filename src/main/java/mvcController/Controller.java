package mvcController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Blog;
import mvcModels.DisplayService;




/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private DisplayService subjectService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		RequestDispatcher rd ;
		if(action.contentEquals("addSubject"))
		{
			
			
		}
		if(action.contentEquals("listSubjects"))
		{
			{
				List<Blog> Blogs = new ArrayList<Blog>();
				Blogs = subjectService.getAllBlogs();
				request.setAttribute("Blogs", Blogs);
				rd = request.getRequestDispatcher("listSubjects.jsp");
				rd.forward(request, response);
				}
			
		}
		if(action.contentEquals("deleteSubject"))
		{
			String subId = request.getParameter("subId");
			if(subId!=null)
			{
			int subjectId = Integer.parseInt(subId);
			List<Blog> Blogs = new ArrayList<Blog>();
			Blogs = subjectService.deleteBlog(subjectId);
			request.setAttribute("subjects", Blogs);
			rd = request.getRequestDispatcher("listSubjects.jsp");
			rd.forward(request, response);
			}
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
