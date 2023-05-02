package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the blog database table.
 * 
 */
@Entity
@NamedQuery(name="Blog.findAll", query="SELECT b FROM Blog b")
public class Blog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="blog_name")
	private String blogName;

	private String category;

	@Temporal(TemporalType.DATE)
	@Column(name="date_post")
	private Date datePost;

	@Lob
	private String description;

	@Column(name="image_path")
	private String imagePath;

	@Column(name="nb_like")
	private int nbLike;

	@Column(name="short_descrption")
	private String shortDescrption;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Blog() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBlogName() {
		return this.blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDatePost() {
		return this.datePost;
	}

	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getNbLike() {
		return this.nbLike;
	}

	public void setNbLike(int nbLike) {
		this.nbLike = nbLike;
	}

	public String getShortDescrption() {
		return this.shortDescrption;
	}

	public void setShortDescrption(String shortDescrption) {
		this.shortDescrption = shortDescrption;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}