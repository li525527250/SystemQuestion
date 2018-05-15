package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.Buser;

public class UserDao {
	// ͨ通过用户账号密码查询登录
	public Buser selectuser(String username, String password) {
		String sql = "SELECT * from buser WHERE uname=? and upassword=?";
		Buser buser = new Buser();
		Connection con = BaseDao.conn();
		PreparedStatement psta = null;
		ResultSet rs = null;
		try {
			psta = con.prepareStatement(sql);
			psta.setString(1, username);
			psta.setString(2, password);
			rs = psta.executeQuery();
			while (rs.next()) {
				buser.setUid(rs.getInt(1));
				buser.setUname(rs.getString(2));
				buser.setUpassword(rs.getString(3));
				buser.setUauthorityid(rs.getInt(4));
				buser.setCompany(rs.getString(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return buser;
	}

	// 通过用户名实时查询是否该用户注册过
	public boolean selectID(String uid) {
		String sql = "select * from buser where uname=?";
		Connection con = BaseDao.conn();
		PreparedStatement psta = null;
		ResultSet rs = null;
		try {
			psta = con.prepareStatement(sql);
			psta.setString(1, uid);
			rs = psta.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	// 添加注册一个用户
	public static boolean registerUser(Buser qu) {
		String sql = "INSERT INTO buser VALUES (null, ?, ?,?,?)";
		Object[] args = new Object[] { qu.getUname(), qu.getUpassword(), qu.getUauthorityid(), qu.getCompany() };
		return BaseDao.executeUpdate(sql, args);
	}
}
