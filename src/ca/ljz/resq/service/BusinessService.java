package ca.ljz.resq.service;

import java.util.List;

import ca.ljz.resq.domain.AppUser;
import ca.ljz.resq.domain.Post;

public interface BusinessService {

	void addUser(AppUser user);

	AppUser findUser(String username, String password);

	AppUser findUser(String id);

	void addPost(Post post);

	Post findPost(String id);
	
	List<Post> findAllPosts();

}