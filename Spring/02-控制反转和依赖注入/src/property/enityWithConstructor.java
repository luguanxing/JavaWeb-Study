package property;

public class enityWithConstructor {
	
	public String username;

	public enityWithConstructor(String username) {
		this.username = username;
		System.out.println("�вγ�ʼ��username = " + username);
		System.out.println();
	}
	
	public void test() {
		System.out.println("�вι���ʵ��->test");
		System.out.println("username = " + username);
	}
	
}
