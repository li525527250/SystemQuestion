package entity;

public class Bauthority {
	// 权限ID
	private int bauthorityid;
	// 权限描述
	private String authority;

	public Bauthority(int bauthorityid, String authority) {
		super();
		this.bauthorityid = bauthorityid;
		this.authority = authority;
	}

	public Bauthority() {
		super();
	}

	public int getBauthorityid() {
		return bauthorityid;
	}

	public void setBauthorityid(int bauthorityid) {
		this.bauthorityid = bauthorityid;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
