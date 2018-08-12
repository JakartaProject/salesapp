package salesapp.mybatis.entity;

public class FollowEx extends Follow {
	private int associatedUserRole;
	private String associatedUserName;
	public int getAssociatedUserRole() {
		return associatedUserRole;
	}
	public void setAssociatedUserRole(int associatedUserRole) {
		this.associatedUserRole = associatedUserRole;
	}
	public String getAssociatedUserName() {
		return associatedUserName;
	}
	public void setAssociatedUserName(String associatedUserName) {
		this.associatedUserName = associatedUserName;
	}
}
