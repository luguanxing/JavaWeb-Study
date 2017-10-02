package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import dao.AccountDao;

@Component(value="accountService")
public class AccountService {

	@Resource(name="accountDao")
	private AccountDao accountDao;
	
	//ת�˲���
	public void TX_transferMoney(String from_user, String to_user, int value) {
		
		accountDao.subMoney(from_user, value);
		
		//ģ���쳣
		//int i = 1 / 0;
		
		accountDao.addMoney(to_user, value);
		
	}
	
}
