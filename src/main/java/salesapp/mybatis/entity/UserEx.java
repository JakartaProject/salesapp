package salesapp.mybatis.entity;

public class UserEx extends User {
	private int customerNum;
	private int nextLevelNum;

	public int getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}

	public int getNextLevelNum() {
		return nextLevelNum;
	}

	public void setNextLevelNum(int nextLevelNum) {
		this.nextLevelNum = nextLevelNum;
	}
}
