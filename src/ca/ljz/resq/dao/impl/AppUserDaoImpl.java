package ca.ljz.resq.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import ca.ljz.resq.dao.AppUserDao;
import ca.ljz.resq.domain.AppUser;
import ca.ljz.resq.utils.JdbcUtils;

public class AppUserDaoImpl implements AppUserDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.ljz.resq.dao.impl.AppUserDao#add(ca.ljz.resq.domain.AppUser)
	 */
	@Override
	public void add(AppUser user) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "insert into appuser(id, username, password, email) values(?,?,?,?)";
			Object params[] = { user.getId(), user.getUsername(), user.getPassword(), user.getEmail() };
			runner.update(conn, sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.ljz.resq.dao.impl.AppUserDao#find(java.lang.String)
	 */
	@Override
	public AppUser find(String id) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from appuser where id=?";
			return runner.query(conn, sql, new BeanHandler<AppUser>(AppUser.class), id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.ljz.resq.dao.impl.AppUserDao#getAll()
	 */
	@Override
	public List<AppUser> getAll() {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from appuser";
			return runner.query(conn, sql, new BeanListHandler<AppUser>(AppUser.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ca.ljz.resq.dao.AppUserDao#find(java.lang.String, java.lang.String)
	 */
	@Override
	public AppUser find(String username, String password) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from appuser where username=? AND password=?";
			return runner.query(conn, sql, new BeanHandler<AppUser>(AppUser.class), username, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
