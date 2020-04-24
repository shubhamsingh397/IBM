package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Account;

@Repository
public interface AccountDao extends CrudRepository<Account, Integer>{

	@Query
	public Optional<Account> findByAccountId(String id);
	public Iterable<Account> findByAccountType(String type);
	public void removeByAccountId(String id);
	
}
