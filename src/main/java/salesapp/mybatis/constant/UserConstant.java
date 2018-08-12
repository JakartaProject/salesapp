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
		
		public int level() {
			return 3-flag();
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
	
	public static enum CustomerStatus {
		POOL(0), SHORT_ASSOCIATED(1), LONG_ASSOCIATED(2);
		private int flag;

		CustomerStatus(int flag) {
			this.flag = flag;
		}

		public int flag() {
			return flag;
		}

		public static CustomerStatus type(int flag) {
			for (CustomerStatus type : CustomerStatus.values()) {
				if (type.flag() == flag) {
					return type;
				}
			}
			throw new RuntimeException();
		}
	}
	
	public static enum CustomerAssociatedType {
		RECV_SELF(1), ALLOCATED(2);
		private int flag;

		CustomerAssociatedType(int flag) {
			this.flag = flag;
		}

		public int flag() {
			return flag;
		}

		public static CustomerAssociatedType type(int flag) {
			for (CustomerAssociatedType type : CustomerAssociatedType.values()) {
				if (type.flag() == flag) {
					return type;
				}
			}
			throw new RuntimeException();
		}
	}
	
	public static enum FollowType {
		COMMON(0), LOCK(1), UNLOCK(2);
		private int flag;

		FollowType(int flag) {
			this.flag = flag;
		}

		public int flag() {
			return flag;
		}

		public static FollowType type(int flag) {
			for (FollowType type : FollowType.values()) {
				if (type.flag() == flag) {
					return type;
				}
			}
			throw new RuntimeException();
		}
	}
}
