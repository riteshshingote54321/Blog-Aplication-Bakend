package com.apis.entites;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "title" , length = 100)
	private String categoryTitle;
	
	@Column(name = "Decription")
	private String categoryDescription;
	
//	@OneToMany(mappedBy = "categary" ,  cascade = CascadeType.ALL )
//	private List<Post> posts=new ArrayList<Post>();
	
	@OneToMany(mappedBy = "category" ,  cascade = CascadeType.ALL)
	private List<Post> posts=new ArrayList<Post>();
	
	
	

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public Categary() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
