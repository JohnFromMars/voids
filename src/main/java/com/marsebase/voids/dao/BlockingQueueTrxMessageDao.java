package com.marsebase.voids.dao;

import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository("BlockingQueueTrxMessageDao")
public class BlockingQueueTrxMessageDao implements TrxMessageDao {

	private static final int QUEUE_SIZE = 5000;
	private Logger log = LogManager.getLogger(BlockingQueueTrxMessageDao.class);

	private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(QUEUE_SIZE);


	@Override
	public void save(String trxMessage) {
		try {
			queue.put(trxMessage);
			
		} catch (InterruptedException e) {
			log.error(e);
		}
	}

	@Override
	public Optional<String> findAnyAndDelete() {
		String trxMessage = queue.poll();
		return Optional.ofNullable(trxMessage);
	}

}
