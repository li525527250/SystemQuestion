package entity;

import java.sql.Date;
import java.util.Arrays;

public class Question {
	// 问题ID
	private int bquestionid;
	// 问题描述
	private String bdescribe;
	// 提问时间
	private String bdate;
	// 解决时间
	private String banswerDate;
	// 提问人用户名
	private String bquestionUname;
	// 提问人用户ID
	private int bquestionUid;
	// 问题解决与否
	private int banswerOrNo;
	// 问题解决描述
	private String banswerScheme;
	// 问题是否公开
	private int bopenOrNo;
	// 问题图片描述
	private String bquestionImg;
	// 问题解决描述
	private String banswerImg;
	// 所属公司
	private String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Question(int bquestionid, String banswerDate, String banswerScheme, int banswerOrNo, int bopenOrNo,
			String banswerImg) {
		super();
		this.bquestionid = bquestionid;
		this.banswerDate = banswerDate;
		this.banswerScheme = banswerScheme;
		this.banswerImg = banswerImg;
		this.bopenOrNo = bopenOrNo;
		this.banswerOrNo = banswerOrNo;
	}

	public Question(String bdescribe, String bdate, String bquestionUname, int bquestionUid, int bopenOrNo,
			String bquestionImg, String company) {
		super();
		this.bdescribe = bdescribe;
		this.bdate = bdate;
		this.bquestionUname = bquestionUname;
		this.bquestionUid = bquestionUid;
		this.bopenOrNo = bopenOrNo;
		this.bquestionImg = bquestionImg;
		this.company = company;
	}

	public Question(int bquestionid, String bdescribe, String bdate, String banswerDate, String bquestionUname,
			int bquestionUid, int banswerOrNo, String banswerScheme, int bopenOrNo, String bquestionImg,
			String banswerImg) {
		super();
		this.bquestionid = bquestionid;
		this.bdescribe = bdescribe;
		this.bdate = bdate;
		this.banswerDate = banswerDate;
		this.bquestionUname = bquestionUname;
		this.bquestionUid = bquestionUid;
		this.banswerOrNo = banswerOrNo;
		this.banswerScheme = banswerScheme;
		this.bopenOrNo = bopenOrNo;
		this.bquestionImg = bquestionImg;
		this.banswerImg = banswerImg;
	}

	public int getBquestionid() {
		return bquestionid;
	}

	public void setBquestionid(int bquestionid) {
		this.bquestionid = bquestionid;
	}

	public String getBdescribe() {
		return bdescribe;
	}

	public void setBdescribe(String bdescribe) {
		this.bdescribe = bdescribe;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getBanswerDate() {
		return banswerDate;
	}

	public void setBanswerDate(String banswerDate) {
		this.banswerDate = banswerDate;
	}

	public String getBquestionUname() {
		return bquestionUname;
	}

	public void setBquestionUname(String bquestionUname) {
		this.bquestionUname = bquestionUname;
	}

	public int getBquestionUid() {
		return bquestionUid;
	}

	public void setBquestionUid(int bquestionUid) {
		this.bquestionUid = bquestionUid;
	}

	public int getBanswerOrNo() {
		return banswerOrNo;
	}

	public void setBanswerOrNo(int banswerOrNo) {
		this.banswerOrNo = banswerOrNo;
	}

	public String getBanswerScheme() {
		return banswerScheme;
	}

	public void setBanswerScheme(String banswerScheme) {
		this.banswerScheme = banswerScheme;
	}

	public int getBopenOrNo() {
		return bopenOrNo;
	}

	public void setBopenOrNo(int bopenOrNo) {
		this.bopenOrNo = bopenOrNo;
	}

	public String getBquestionImg() {
		return bquestionImg;
	}

	public void setBquestionImg(String bquestionImg) {
		this.bquestionImg = bquestionImg;
	}

	public String getBanswerImg() {
		return banswerImg;
	}

	public void setBanswerImg(String banswerImg) {
		this.banswerImg = banswerImg;
	}

	@Override
	public String toString() {
		return "Question [bquestionid=" + bquestionid + ", bdescribe=" + bdescribe + ", bdate=" + bdate
				+ ", banswerDate=" + banswerDate + ", bquestionUname=" + bquestionUname + ", bquestionUid="
				+ bquestionUid + ", banswerOrNo=" + banswerOrNo + ", banswerScheme=" + banswerScheme + ", bopenOrNo="
				+ bopenOrNo + ", bquestionImg=" + bquestionImg + ", banswerImg=" + banswerImg + "]";
	}

	public Question() {
		super();
	}

}
