package totoBook.domain;

public class Member {

	private String memberid;
	private String name;
	private String password;
	private String adrress;
	private String phonumber;
	private String receiveemail;
	
	
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdrress() {
		return adrress;
	}
	public void setAdrress(String adrress) {
		this.adrress = adrress;
	}
	public String getPhonumber() {
		return phonumber;
	}
	public void setPhonumber(String phonumber) {
		this.phonumber = phonumber;
	}
	public String getReceiveemail() {
		return receiveemail;
	}
	public void setReceiveemail(String receiveemail) {
		this.receiveemail = receiveemail;
	}
	@Override
	public String toString() {
		return "Member [memberid=" + memberid + ", name=" + name + ", password=" + password + ", adrress=" + adrress
				+ ", phonumber=" + phonumber + ", receiveemail=" + receiveemail + "]";
	}
	
}
