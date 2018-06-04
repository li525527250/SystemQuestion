package dao;

import java.sql.*;

public class BaseDao {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bquestion";
	private static final String UNAME = "root";
	private static final String PWD = "root";

	// 获取connction对象
	public static Connection conn() {
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, UNAME, PWD);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	// 关闭�?��连接对象
	public static void closeAll(ResultSet rs, Statement sta, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (sta != null)
				sta.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ͨ创建公共的增删改方法
	public static boolean executeUpdate(String sql, Object[] args) {
		boolean flag = false;
		Connection con = conn();
		PreparedStatement sta = null;
		try {
			sta = con.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				if (args[i] == "" || args[i] == null)
					sta.setObject(i + 1, "");
				else
					sta.setObject(i + 1, args[i]);
			}
			int count = sta.executeUpdate();
			if (count != 0)
				flag = true;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			closeAll(null, sta, con);
		}
		return flag;
	}
}
