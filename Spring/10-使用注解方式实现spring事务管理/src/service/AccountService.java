package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dao.AccountDao;

@Transactional
@Component(value="accountService")
public class AccountService {

	@Resource(name="accountDao")
	private AccountDao accountDao;
	
	//转账操作
	public void transferMoney(String from_user, String to_user, int value) {
		
		accountDao.subMoney(from_user, value);
		
		//模拟异常
		int i = 1 / 0;
		
		accountDao.addMoney(to_user, value);
		
	}
	
}
