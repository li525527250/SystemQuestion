package entity;

public class Buser {
	//用户ID
	private int uid;
	//用户名
	private String uname;
	//用户密码
	private String upassword;
	//权限ID
	private int uauthorityid;
	
	private String company;
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public int getUauthorityid() {
		return uauthorityid;
	}
	public void setUauthorityid(int uauthorityid) {
		this.uauthorityid = uauthorityid;
	}
	
	public Buser(int uid, String uname, String upassword, int uauthorityid, String company) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upassword = upassword;
		this.uauthorityid = uauthorityid;
		this.company = company;
	}
	public Buser(String uname, String upassword, int uauthorityid) {
		super();
		this.uname = uname;
		this.upassword = upassword;
		this.uauthorityid = uauthorityid;
	}
	
	public Buser(String uname, String upassword, int uauthorityid, String company) {
		super();
		this.uname = uname;
		this.upassword = upassword;
		this.uauthorityid = uauthorityid;
		this.company = company;
	}
	public Buser(int uid, String uname, String upassword, int uauthorityid) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upassword = upassword;
		this.uauthorityid = uauthorityid;
	}
	public Buser() {
		super();
	}
	@Override
	public String toString() {
		return "Buser [uid=" + uid + ", uname=" + uname + ", upassword="
				+ upassword + ", uauthorityid=" + uauthorityid + "]";
	}
	
}
