package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.LedgerDAO;
import com.luv2code.springdemo.entity.Ledger;

@Service
public class LedgerServiceImpl implements LedgerService {
	
	// need to inject customer dao
		@Autowired
		private LedgerDAO ledgerDAO;
		
		
	@Override
	@Transactional
	public List<Ledger> getValues() {
		return ledgerDAO.getValues();
	}

}
