package edu.java.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import edu.java.mvc.model.Post;

public class PostDaoImpl implements PostDao {

	// Singleton 선언 먼저
	private static PostDaoImpl instance = null;
	private PostDaoImpl() {};
	public static PostDaoImpl getInstance() {
		if (instance == null) {
			instance = new PostDaoImpl();
		}
		return instance;
	}
	
//	private final int MAX_LENGTH = 3;
//	private Post[] posts = new Post[MAX_LENGTH];
//	private int count = 0;
	private List<Post> posts = new ArrayList<>();
	
	//method
//	public boolean isMemoryAvailable() {
//		return count < MAX_LENGTH;
//	}
	public boolean isindexValid(int index) {
		return index >= 0 && index < posts.size();
	}
	
	
	@Override
	public int create(Post p) {
		posts.add(p);
		return 1;

	}

	@Override
	public List<Post> read() {
		return posts;
	}

	@Override
	public Post read(int index) {
		return posts.get(index);
	}

	@Override
	public int update(int index, Post p) {
		if (isindexValid(index)) {
			posts.set(index, p);
			return 1;
		} else {
			return 0;
		}
		
	}

	@Override
	public int delete(int index) {
		if (!isindexValid(index)) {
			return 0;
		}
		posts.remove(index);
		return 1;
	}
	

}