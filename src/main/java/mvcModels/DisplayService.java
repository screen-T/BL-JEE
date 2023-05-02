package mvcModels;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Blog;

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
    @PersistenceContext(unitName="tp4jee")
    private EntityManager em;
    public List<Blog> getAllBlogs()
    {
    List<Blog> subjects = new ArrayList<Blog>();
    TypedQuery<Blog> query = em.createNamedQuery("Subject.findAll",Blog.class);
    subjects = query.getResultList();
    return subjects;
    }
    
    public List<Blog> deleteBlog(int id)
    {
    List<Blog> subjects = new ArrayList<Blog>();
    Blog sub = em.find(Blog.class,id);
    if(sub!=null)
    em.remove(sub);
    TypedQuery<Blog> query =
    em.createNamedQuery("Subject.findAll",Blog.class);
    subjects = query.getResultList();
    return subjects;
}
}
