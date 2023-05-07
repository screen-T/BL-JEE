package mvcModels;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Blog;
import entities.User;

/**
 * Session Bean implementation class DisplayService
 */
@Stateless
@LocalBean
public class DisplayService {
	  
    /**
     * Default constructor. 
     */
    public DisplayService() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="bloggyV4")
    private EntityManager em;
    
    public List<Blog> getAllBlogs()
    {
        List<Blog> blogs = new ArrayList<Blog>();
        TypedQuery<Blog> query = em.createNamedQuery("Blog.findAll",Blog.class);
        blogs = query.getResultList();
        return blogs;
    }
    
    public List<Blog> deleteBlog(int id)
    {
        List<Blog> blogs = new ArrayList<Blog>();
        Blog blog = em.find(Blog.class,id);
        if(blog != null) {
            em.remove(blog);
        }
        TypedQuery<Blog> query = em.createNamedQuery("Blog.findAll",Blog.class);
        blogs = query.getResultList();
        return blogs;
    }
    
    public void addBlog(Blog blog) {
        try {
            em.persist(blog);
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
        public void Register(User user) {
            try {
                em.persist(user);
            } catch (Exception e) {
                e.printStackTrace();
               
            }
    }
        public User login(String cin , String password) {
            if (cin == null || password == null  )  {
                return null;
            }
            List<User> users = em.createQuery(
                    "SELECT u FROM User u WHERE u.cin = :cin and u.password = :password", User.class)
                    .setParameter("cin", cin)
                    .setParameter("password", password)
                    .getResultList();
            if (users.isEmpty()) {
                return null;
            }
            System.out.println(users.get(0));
            return users.get(0);
            
        }
      
        }

