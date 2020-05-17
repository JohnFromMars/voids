package com.marsebase.voids.service;

import java.util.Optional;
import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.marsebase.voids.dao.TrxMessageDao;

@Service
public class SimpleTrxMessageService implements TrxMessageService {

	private Logger log = LogManager.getFormatterLogger(SimpleTrxMessageService.class);

	@Autowired
	@Qualifier("BlockingQueueTrxMessageDao")
	private TrxMessageDao trxMessageDao;

	@Override
	public void saveTrxMessage(String trxMessage) throws TimeoutException {
		trxMessageDao.save(trxMessage);
	}

	@Override
	public Optional<String> getAndRemoveTrxMessage() {
		return trxMessageDao.findAnyAndDelete();
	}

}
