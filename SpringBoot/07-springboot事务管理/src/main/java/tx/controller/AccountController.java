package tx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tx.service.AccountService;

@RestController	//省去@ResponseBody
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/transfer")
	public String transfer() {
		try {
			accountService.transfer(1, 2, 200);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "failed";
		}
	}
	
}
