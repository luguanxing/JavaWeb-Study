package property;

public class enityWithoutConstructor {
	
	public String username;

	public enityWithoutConstructor() {
		System.out.println("无参初始化username = " + username);
		System.out.println();
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void test() {
		System.out.println("无参构造实体->test");
		System.out.println("username = " + username);
	}
	
}
