package ca.ljz.resq.dao;

import java.util.List;

import ca.ljz.resq.domain.Post;

public interface PostDao {

	public void add(Post post);

	public Post find(String id);

	public List<Post> findAll();

}
