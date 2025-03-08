package com.apis.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.apis.entites.Categary;
import com.apis.entites.Post;
import com.apis.entites.User;
import com.apis.exceptions.ResourceNotFoundException;
import com.apis.payloads.PostDto;
import com.apis.payloads.PostResponce;
import com.apis.repositarys.PostRepo;
import com.apis.repositarys.categoryRepo;
import com.apis.repositarys.userRepo;
import com.apis.services.PostService;

@Service
public class PostserviceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private userRepo UserRepo;
	
	@Autowired
	private categoryRepo CategoryRepo;
	
	
	@Override
	public PostDto createPost(PostDto postDto , Integer userId , Integer categaryId) {
		
		User user = this.UserRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User id", userId));
		
		Categary category = this.CategoryRepo.findById(categaryId).orElseThrow(()-> new ResourceNotFoundException("Categary", "Categary id", categaryId));
		
		Post post=this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		Post newpost=this.postRepo.save(post);
		return this.modelMapper.map(newpost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post= this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "post id", postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		Post updated = this.postRepo.save(post);
		return this.modelMapper.map(updated, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post= this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "post id", postId));
		this.postRepo.delete(post);

	}

	@Override
	public PostResponce getAllPost(Integer pageNumber , Integer pageSize , String sortBy , String sortDir) {
		
		Sort sort=null;
		if(sortDir.equalsIgnoreCase("asc")) {
			sort= Sort.by(sortBy).ascending();
		}
		else
		{ 
			sort=Sort.by(sortBy).descending();
		}
		
		Pageable p =PageRequest.of(pageNumber, pageSize, sort);
		
		
		Page<Post> pagepots=this.postRepo.findAll(p);
		
		List<Post> pots= pagepots.getContent();
		
		List<PostDto> postdto =pots.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		PostResponce  responce = new PostResponce();
		
		responce.setContent(postdto);
		responce.setPageNumber(pagepots.getNumber());
		responce.setPageSize(pagepots.getSize());
		responce.setTotalElment(pagepots.getTotalElements());
		responce.setTotalPage(pagepots.getTotalPages());
		responce.setLastPage(pagepots.isLast());
		return responce;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post posts = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "post id", postId)); 
		return this.modelMapper.map(posts, PostDto.class);
		//return postDto;
	}

	@Override
	public List<PostDto> getAllPostsByCategory(Integer categoryId) {
		Categary cat = this.CategoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Categary", "categary id", categoryId));
		List<Post> posts=this.postRepo.findByCategory(cat);
		
		List<PostDto> postDtos=posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return postDtos;
	}

	@Override
	public List<PostDto> getAllPostsByUser(Integer userId) {
		User user = this.UserRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "user id", userId));
		List<Post> posts=this.postRepo.findByUser(user);
		List<PostDto> postdtos=posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return postdtos;
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		List<Post> posts = this.postRepo.searchByTitle("%"+keyword+"%");
		List<PostDto> postDtos=posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

}
