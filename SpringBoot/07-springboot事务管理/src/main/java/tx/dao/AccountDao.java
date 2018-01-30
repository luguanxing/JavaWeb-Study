package tx.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tx.entity.Account;

public interface AccountDao extends JpaRepository<Account, Integer> {
	
	
	
}
