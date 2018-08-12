package salesapp.mybatis.entity;

public class CustomerEx extends Customer {
	private String associatedUserName;
	private String associatedUserMobile;
	private String associatedUserPosition;
	public String getAssociatedUserName() {
		return associatedUserName;
	}
	public void setAssociatedUserName(String associatedUserName) {
		this.associatedUserName = associatedUserName;
	}
	public String getAssociatedUserMobile() {
		return associatedUserMobile;
	}
	public void setAssociatedUserMobile(String associatedUserMobile) {
		this.associatedUserMobile = associatedUserMobile;
	}
	public String getAssociatedUserPosition() {
		return associatedUserPosition;
	}
	public void setAssociatedUserPosition(String associatedUserPosition) {
		this.associatedUserPosition = associatedUserPosition;
	}
}
