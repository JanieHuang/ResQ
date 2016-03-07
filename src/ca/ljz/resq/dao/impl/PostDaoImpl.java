package ca.ljz.resq.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import ca.ljz.resq.dao.PostDao;
import ca.ljz.resq.domain.AppUser;
import ca.ljz.resq.domain.Post;
import ca.ljz.resq.utils.JdbcUtils;

public class PostDaoImpl implements PostDao {

	@Override
	public void add(Post post) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "insert into post(id, topic, description, address, appuser_id) values(?,?,?,?,?)";
			Object params[] = { post.getId(), post.getTopic(), post.getDescription(), post.getAddress(), post.getAppUser().getId() };
			runner.update(conn, sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Post find(String id) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from post where id=?";
			Post post = runner.query(conn, sql, new BeanHandler<Post>(Post.class), id);

			sql = "select a.* from appuser a, post p where a.id=p.appuser_id and p.id=?";
			post.setAppUser(runner.query(conn, sql, new BeanHandler<AppUser>(AppUser.class), id));

			return post;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Post> findAll() {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from post";
			List<Post> posts = runner.query(conn, sql, new BeanListHandler<Post>(Post.class));

			for (Post post : posts) {
				sql = "select a.* from appuser a, post p where a.id=p.appuser_id and p.id=?";
				post.setAppUser(runner.query(conn, sql, new BeanHandler<AppUser>(AppUser.class), post.getId()));
			}

			return posts;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
