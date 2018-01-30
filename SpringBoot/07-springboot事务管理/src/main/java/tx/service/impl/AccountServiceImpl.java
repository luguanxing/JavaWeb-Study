package tx.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tx.dao.AccountDao;
import tx.entity.Account;
import tx.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	
	@Override
	@Transactional
	public void transfer(int from, int to, int money) {
		Account formAccount = accountDao.getOne(from);
		formAccount.setBalance(formAccount.getBalance()-money);
		accountDao.save(formAccount);
		int i = 1 / 0; //模拟异常
		Account toAccount = accountDao.getOne(to);
		toAccount.setBalance(toAccount.getBalance()+money);
		accountDao.save(toAccount);
	}

}
