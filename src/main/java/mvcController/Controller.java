package mvcController;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
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
		RequestDispatcher rd1 ;
		if(action==null)
		{
			List<Blog> listBlogs = service.getAllBlogs();
			System.out.println(listBlogs.size());
			request.setAttribute("Blogs", listBlogs);
			rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
			
		}
		if(action.contentEquals("myBlogs"))
		{
			List<Blog> listBlogs = service.getAllBlogs();
			request.setAttribute("Blogs", listBlogs);
			rd = request.getRequestDispatcher("myblogs.jsp");
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
		
			
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String action = request.getParameter("action");
       RequestDispatcher rd ;
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
                blog.setUser(user);
            }
            blog.setImagePath(request.getParameter("img")) ;
            service.addBlog(blog);
            response.sendRedirect("Controller");
                   
        }
        if(action.contentEquals("deleteBlog"))
		{
			String blogId = request.getParameter("id");
			if(blogId!=null)
			{
			int id = Integer.parseInt(blogId);
			List<Blog> Blogs = new ArrayList<Blog>();
			Blogs = service.deleteBlog(id);
			request.setAttribute("Blogs", Blogs);
			rd = request.getRequestDispatcher("myblogs.jsp");
			rd.forward(request, response);
			}
		}
        if(action.contentEquals("register"))
        {
            User user = new User();
            user.setAge(new Date(2002-10-10)) ;
            user.setCin(request.getParameter("cin")) ;
            user.setPassword(request.getParameter("password")) ;
            user.setUsername(request.getParameter("username"));
            boolean exist = service.register(user);
            if (exist== false)
            {
            	response.sendRedirect("usenot.jsp");
            }
            else 
            {
            	response.sendRedirect("Controller");
            }
            
            
        }

         

        if (action.equals("updateBlog")) {
            String blogId = request.getParameter("id");
            int id = Integer.parseInt(blogId);
            
            // Retrieve the existing blog entity using the EntityManager
            Blog blog = service.getBlogById(id);

            if (blog != null) {
                // Perform the necessary operations to update the blog entity
                // For example, you can retrieve the updated values from the request parameters
                String updatedTitle = request.getParameter("title");
                String updatedShortDescription = request.getParameter("shortDescription");
                String updatedDescription = request.getParameter("description");
                String updatedCategory = request.getParameter("category");
                String updatedImageURL = request.getParameter("img");

                blog.setBlogName(updatedTitle);
                blog.setShortDescrption(updatedShortDescription);
                blog.setDescription(updatedDescription);
                blog.setCategory(updatedCategory);
                blog.setImagePath(updatedImageURL);

                // Call the appropriate method in the DisplayService to update the blog entity
                service.updateBlog(blog);

                // Optionally, perform any additional actions or redirect the user to a different page
                response.sendRedirect("Controller?action=myBlogs");
            } else {
                // Handle the case where the blog with the given id is not found
                // For example, you can display an error message or redirect to an error page
                response.sendRedirect("error.jsp");
            }
        }



        if (action.equals("login")) {
        	
            String cin = request.getParameter("cin");
            String password = request.getParameter("password"); 
            User user = service.login(cin , password) ; 
            if (user != null) {            	  
            	  session.setAttribute("user", user);            	  
            	  System.out.println(user);
            	  String username = user.getUsername();
            	  request.setAttribute("username", username);
            	  response.sendRedirect("Controller");
            	} else {
            	  response.sendRedirect("notfound.jsp");
            	}
        }
        
        if (action.equals("logout")) {        	
        	 session.invalidate();
        	 response.sendRedirect("Controller");
        }
    }
   }

