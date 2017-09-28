package property;

public class enityWithConstructor {
	
	public String username;

	public enityWithConstructor(String username) {
		this.username = username;
		System.out.println("有参初始化username = " + username);
		System.out.println();
	}
	
	public void test() {
		System.out.println("有参构造实体->test");
		System.out.println("username = " + username);
	}
	
}
