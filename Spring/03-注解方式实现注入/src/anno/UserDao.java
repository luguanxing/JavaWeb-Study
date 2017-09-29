package anno;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="userDao")
@Scope(value="prototype")
public class UserDao {

	public void add() {
		System.out.println("UserDao->add");
	}
	
}
