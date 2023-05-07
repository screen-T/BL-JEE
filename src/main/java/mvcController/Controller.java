package mvcController;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Blog;
import entities.User;
import mvcModels.DisplayService;
import mvcModels.UserService;




/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private DisplayService service;
	
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
		if(action==null)
		{
			List<Blog> listBlogs = service.getAllBlogs();
			System.out.println(listBlogs.size());
			request.setAttribute("Blogs", listBlogs);
			rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
		if(action.contentEquals("addBlog"))
		{
			
			rd = request.getRequestDispatcher("insertblog.jsp");
			rd.forward(request, response);
			
		}
		if (action != null && action.equals("addBlog")) {
		    response.sendRedirect("insertblog.jsp");
		}
		if(action.contentEquals("deleteSubject"))
		{
			String subId = request.getParameter("subId");
			if(subId!=null)
			{
			int subjectId = Integer.parseInt(subId);
			List<Blog> Blogs = new ArrayList<Blog>();
			Blogs = service.deleteBlog(subjectId);
			request.setAttribute("subjects", Blogs);
			rd = request.getRequestDispatcher("ListBlogs.jsp");
			rd.forward(request, response);
			}
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String action = request.getParameter("action");
       String Cin="" ;
       HttpSession session = request.getSession(true);
        if(action.contentEquals("saveBlog"))
        {	
        	
        	
            Blog blog = new Blog();
            blog.setBlogName(request.getParameter("title"));
            blog.setCategory(request.getParameter("category"));
            blog.setDatePost(new Date(2002-01-01));
            blog.setDescription(request.getParameter("description"));
            blog.setImagePath(request.getParameter("imagePath"));
            blog.setNbLike(0);
            blog.setShortDescrption(request.getParameter("shortDescription"));
            User user = (User) session.getAttribute("user");
            if (user != null) {
                // set the user's cin on the blog
                blog.setUser(user);
            }
            blog.setImagePath(request.getParameter("img")) ;
            
            service.addBlog(blog);
            response.sendRedirect("Controller");
            System.out.printf("aaa");
            
        }
        if(action.contentEquals("register"))
        {
            User user = new User();
            user.setAge(new Date(2002-10-10)) ;
            user.setCin(request.getParameter("cin")) ;
            user.setPassword(request.getParameter("password")) ;
            user.setUsername(request.getParameter("username"));
            service.Register(user);
            response.sendRedirect("Controller");
        }
        if (action.equals("login")) {
            String cin = request.getParameter("cin");
            String password = request.getParameter("password");
            Cin=cin ; 
           
            User user = service.login(cin , password) ;
            
            if (user != null) {
            	  
            	  session.setAttribute("user", user);
            	  
            	  System.out.println(user);
            	  String username = user.getUsername();
            	  request.setAttribute("username", username);
            	  response.sendRedirect("Controller");
            	} else {
            	  response.sendRedirect("login.jsp?error=Invalid username or password");
            	}

        }
        if (action.equals("logout")) {
        	
        	 session.invalidate();
        	 response.sendRedirect("Controller");
        }
    }}

