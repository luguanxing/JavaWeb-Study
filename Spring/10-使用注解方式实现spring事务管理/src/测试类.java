import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.AccountService;

public class ≤‚ ‘¿‡ {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		AccountService service = (AccountService) context.getBean("accountService");
		service.transferMoney("∑ ∑ ", "≈£≈£", 5);
	}

}
