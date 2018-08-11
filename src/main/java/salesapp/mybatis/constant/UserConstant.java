package salesapp.mybatis.constant;

public class UserConstant {
	public static enum UserRole {
		ADMIN(0), GENERAL_MANAGER(1), MANAGER(2), SELLER(3);
		private int flag;

		UserRole(int flag) {
			this.flag = flag;
		}

		public int flag() {
			return flag;
		}

		public static UserRole role(int flag) {
			for (UserRole role : UserRole.values()) {
				if (role.flag() == flag) {
					return role;
				}
			}
			throw new RuntimeException();
		}

		public UserRole nextLevel() {
			switch (this) {
			case ADMIN:
				return GENERAL_MANAGER;
			case GENERAL_MANAGER:
				return MANAGER;
			case MANAGER:
				return SELLER;
			default:
				return null;
			}
		}
		
		public int compare(UserRole role) {
			return role.flag - this.flag;
		}
	}

	public static enum UserStatus {
		REGISTED(1), DELETED(0);
		private int flag;

		UserStatus(int flag) {
			this.flag = flag;
		}

		public int flag() {
			return flag;
		}

		public static UserStatus role(int flag) {
			for (UserStatus role : UserStatus.values()) {
				if (role.flag() == flag) {
					return role;
				}
			}
			throw new RuntimeException();
		}
	}
}
