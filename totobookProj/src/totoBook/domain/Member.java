package totoBook.domain;

/**
 * @author
 * @version 1.0
 */

public class Member {


	private String memberId;
	private String name;
	private String password;
	private String address;
	private String phone;
	private String receiveEmail;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getReceiveEmail() {
		return receiveEmail;
	}
	public void setReceiveEmail(String receiveEmail) {
		this.receiveEmail = receiveEmail;
	}
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", password=" + password + ", address=" + address
				+ ", phone=" + phone + ", receiveEmail=" + receiveEmail + "]";
	}
	
	
	
}
