package ca.ljz.resq.dao;

import java.util.List;

import ca.ljz.resq.domain.AppUser;

public interface AppUserDao {

	void add(AppUser user);

	AppUser find(String id);

	List<AppUser> getAll();

	AppUser find(String username, String password);

}