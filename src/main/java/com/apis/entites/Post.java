package com.apis.entites;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.apis.payloads.CommentDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	
	@Column(name = "post_title" , length = 100 , nullable = false)
	private String title;
	
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	@ManyToOne
	private Categary category;
	
	@ManyToOne
	private User user;
	
//	@OneToMany(mappedBy = "post" ,cascade = CascadeType.ALL )
//	private Set<CommentDto> comments= new HashSet<>();
	
	@OneToMany(mappedBy = "post" , cascade = CascadeType.ALL)
	private Set<Comment> comments= new HashSet<>();
	
	
	
	

	

	

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	

	

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Categary getCategory() {
		return category;
	}

	public void setCategory(Categary category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", content=" + content + ", imageName=" + imageName
				+ ", addedDate=" + addedDate + ", category=" + category + ", user=" + user + ", comments=" + comments
				+ "]";
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
