package property;

public class enityWithoutConstructor {
	
	public String username;

	public enityWithoutConstructor() {
		System.out.println("�޲γ�ʼ��username = " + username);
		System.out.println();
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void test() {
		System.out.println("�޲ι���ʵ��->test");
		System.out.println("username = " + username);
	}
	
}
