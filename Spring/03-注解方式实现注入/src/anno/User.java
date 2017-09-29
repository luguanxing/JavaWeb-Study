package anno;

import org.springframework.stereotype.Component;

@Component("user")
public class User {
	
	public void test() {
		System.out.println("User->test");
	}
	
}
