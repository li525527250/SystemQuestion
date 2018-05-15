package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.*;

public class QuestioinDao {
	// ͨ通过提问用户id查询一个问题出来
	public static List<Question> getquestionbyid(int userid) {
		List<Question> list = new ArrayList<Question>();
		String sql = "select * from question where bquestionuid=? ORDER BY Bquestionid DESC";
		Connection con = BaseDao.conn();
		PreparedStatement psta = null;
		ResultSet rs = null;
		try {
			psta = con.prepareStatement(sql);
			psta.setInt(1, userid);
			rs = psta.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setBquestionid(rs.getInt(1));
				question.setBdescribe(rs.getString(2));
				question.setBdate(rs.getString(3));
				question.setBanswerDate(rs.getString(4));
				question.setBquestionUname(rs.getString(5));
				question.setBquestionUid(rs.getInt(6));
				question.setBanswerOrNo(rs.getInt(7));
				question.setBanswerScheme(rs.getString(8));
				question.setBopenOrNo(rs.getInt(9));
				question.setBquestionImg(rs.getString(10));
				question.setBanswerImg(rs.getString(11));
				question.setCompany(rs.getString(12));
				list.add(question);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	// 查询所有问题方法
	public static List<Question> getquestionby() {
		List<Question> list = new ArrayList<Question>();
		String sql = "select * from question ORDER BY Bquestionid DESC";
		Connection con = BaseDao.conn();
		Statement psta = null;
		ResultSet rs = null;
		try {
			psta = con.createStatement();
			rs = psta.executeQuery(sql);
			while (rs.next()) {
				Question question = new Question();
				question.setBquestionid(rs.getInt(1));
				question.setBdescribe(rs.getString(2));
				question.setBdate(rs.getString(3));
				question.setBanswerDate(rs.getString(4));
				question.setBquestionUname(rs.getString(5));
				question.setBquestionUid(rs.getInt(6));
				question.setBanswerOrNo(rs.getInt(7));
				question.setBanswerScheme(rs.getString(8));
				question.setBopenOrNo(rs.getInt(9));
				question.setBquestionImg(rs.getString(10));
				question.setBanswerImg(rs.getString(11));
				question.setCompany(rs.getString(12));
				list.add(question);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	// 通过是否公开是否解决查询出问题
	public static List<Question> getquestionbyanswerId1(int id, int openid) {
		List<Question> list = new ArrayList<Question>();
		String sql = "select * from question where banswerOrNo=? and bopenOrNo=? ORDER BY Bquestionid DESC";
		Connection con = BaseDao.conn();
		PreparedStatement psta = null;
		ResultSet rs = null;
		try {
			psta = con.prepareStatement(sql);
			psta.setInt(1, id);
			psta.setInt(2, openid);
			rs = psta.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setBquestionid(rs.getInt(1));
				question.setBdescribe(rs.getString(2));
				question.setBdate(rs.getString(3));
				question.setBanswerDate(rs.getString(4));
				question.setBquestionUname(rs.getString(5));
				question.setBquestionUid(rs.getInt(6));
				question.setBanswerOrNo(rs.getInt(7));
				question.setBanswerScheme(rs.getString(8));
				question.setBopenOrNo(rs.getInt(9));
				question.setBquestionImg(rs.getString(10));
				question.setBanswerImg(rs.getString(11));
				question.setCompany(rs.getString(12));
				list.add(question);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	// ͨ通过问题ID和是否解决来查询问题
	public static List<Question> getquestionbyanswerId2(int id, int userid) {
		List<Question> list = new ArrayList<Question>();
		String sql = "select * from question where banswerOrNo=? and bquestionUid=? ORDER BY Bquestionid DESC";
		Connection con = BaseDao.conn();
		PreparedStatement psta = null;
		ResultSet rs = null;
		try {
			psta = con.prepareStatement(sql);
			psta.setInt(1, id);
			psta.setInt(2, userid);
			rs = psta.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setBquestionid(rs.getInt(1));
				question.setBdescribe(rs.getString(2));
				question.setBdate(rs.getString(3));
				question.setBanswerDate(rs.getString(4));
				question.setBquestionUname(rs.getString(5));
				question.setBquestionUid(rs.getInt(6));
				question.setBanswerOrNo(rs.getInt(7));
				question.setBanswerScheme(rs.getString(8));
				question.setBopenOrNo(rs.getInt(9));
				question.setBquestionImg(rs.getString(10));
				question.setBanswerImg(rs.getString(11));
				question.setCompany(rs.getString(12));
				list.add(question);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}
	// 添加一个问题
	public static boolean addQuestion(Question qu) {
		String sql = "INSERT INTO question VALUES (null, ?, ?,null,?,?,0,null, ?,?, null,?)";
		Object[] args = new Object[] { qu.getBdescribe(), qu.getBdate(), qu.getBquestionUname(), qu.getBquestionUid(),
				qu.getBopenOrNo(), qu.getBquestionImg(), qu.getCompany() };
		return BaseDao.executeUpdate(sql, args);
	}

	// 修改解决一个问题
	public static boolean updQuestion(Question qu) {
		String sql = "update question set BanswerDate=?,BanswerScheme=?,BanswerImg=?,BanswerOrNo=?,bopenOrNo=? where Bquestionid=?";
		Object[] args = new Object[] { qu.getBanswerDate(), qu.getBanswerScheme(), qu.getBanswerImg(),
				qu.getBanswerOrNo(), qu.getBopenOrNo(), qu.getBquestionid() };
		return BaseDao.executeUpdate(sql, args);
	}

	// ͨ通过一个问题id查询出问题详情
	public static List<Question> getquestionbywentiId(int id) {
		List<Question> list = new ArrayList<Question>();
		String sql = "select * from question where Bquestionid=? ORDER BY Bquestionid DESC";
		Connection con = BaseDao.conn();
		PreparedStatement psta = null;
		ResultSet rs = null;
		try {
			psta = con.prepareStatement(sql);
			psta.setInt(1, id);
			rs = psta.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setBquestionid(rs.getInt(1));
				question.setBdescribe(rs.getString(2));
				question.setBdate(rs.getString(3));
				question.setBanswerDate(rs.getString(4));
				question.setBquestionUname(rs.getString(5));
				question.setBquestionUid(rs.getInt(6));
				question.setBanswerOrNo(rs.getInt(7));
				question.setBanswerScheme(rs.getString(8));
				question.setBopenOrNo(rs.getInt(9));
				question.setBquestionImg(rs.getString(10));
				question.setBanswerImg(rs.getString(11));
				list.add(question);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	// 通过时间，提问人，问题标题等条件模糊查询问题
	public static List<Question> selectQuestionBySynthesize(String sql) {
		List<Question> list = new ArrayList<Question>();
		Connection con = BaseDao.conn();
		Statement psta = null;
		ResultSet rs = null;
		try {
			psta = con.createStatement();
			rs = psta.executeQuery(sql);
			while (rs.next()) {
				Question question = new Question();
				question.setBquestionid(rs.getInt(1));
				question.setBdescribe(rs.getString(2));
				question.setBdate(rs.getString(3));
				question.setBanswerDate(rs.getString(4));
				question.setBquestionUname(rs.getString(5));
				question.setBquestionUid(rs.getInt(6));
				question.setBanswerOrNo(rs.getInt(7));
				question.setBanswerScheme(rs.getString(8));
				question.setBopenOrNo(rs.getInt(9));
				question.setBquestionImg(rs.getString(10));
				question.setBanswerImg(rs.getString(11));
				question.setCompany(rs.getString(12));
				list.add(question);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
