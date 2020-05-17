package com.marsebase.voids.dao;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository("SynchronizedQueueTrxMessageDao")
public class SynchronizedQueueTrxMessageDao implements TrxMessageDao {

	private Logger log = LogManager.getLogger(SynchronizedQueueTrxMessageDao.class);
	private static Queue<String> queue = new LinkedList<>();

	@Override
	public synchronized void save(String trxMessage) {
		log.info("add {}", trxMessage);
		queue.offer(trxMessage);

	}

	@Override
	public synchronized Optional<String> findAnyAndDelete() {
		String trxMessage = queue.poll();
		log.info("in findAnyAndDelete {}", trxMessage);
		return Optional.ofNullable(trxMessage);

	}

}
