package ca.ljz.resq.service.impl;

import java.util.List;

import ca.ljz.resq.dao.AppUserDao;
import ca.ljz.resq.dao.PostDao;
import ca.ljz.resq.domain.AppUser;
import ca.ljz.resq.domain.Post;
import ca.ljz.resq.factory.DaoFactory;
import ca.ljz.resq.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
	
	/**
	 * User Service
	 */
	private AppUserDao udao = DaoFactory.getInstance().createDao(AppUserDao.class); 

	/* (non-Javadoc)
	 * @see ca.ljz.resq.service.impl.BusinessService#addUser(ca.ljz.resq.domain.AppUser)
	 */
	@Override
	public void addUser(AppUser user){
		udao.add(user);
	}
	
	/* (non-Javadoc)
	 * @see ca.ljz.resq.service.impl.BusinessService#findUser(java.lang.String, java.lang.String)
	 */
	@Override
	public AppUser findUser(String username,String password){
		return udao.find(username, password);
		
	}
	
	/* (non-Javadoc)
	 * @see ca.ljz.resq.service.impl.BusinessService#findUser(java.lang.String)
	 */
	@Override
	public AppUser findUser(String id){
		return udao.find(id);
	}

	/**
	 * Post Service
	 */
	private PostDao pdao = DaoFactory.getInstance().createDao(PostDao.class); 

	/* (non-Javadoc)
	 * @see ca.ljz.resq.service.impl.BusinessService#addUser(ca.ljz.resq.domain.AppUser)
	 */
	@Override
	public void addPost(Post post){
		pdao.add(post);
	}
	
	/* (non-Javadoc)
	 * @see ca.ljz.resq.service.impl.BusinessService#findUser(java.lang.String)
	 */
	@Override
	public Post findPost(String id){
		return pdao.find(id);
	}

	/*
	 * (non-Javadoc)
	 * @see ca.ljz.resq.service.BusinessService#findAllPosts()
	 */
	@Override
	public List<Post> findAllPosts() {
		return pdao.findAll();
	}

}
