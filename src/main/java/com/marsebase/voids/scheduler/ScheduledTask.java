package com.marsebase.voids.scheduler;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.marsebase.voids.service.TrxMessageService;

@Component
public class ScheduledTask {

	private Logger log = LogManager.getLogger(ScheduledTask.class);
	
	@Autowired
	private TrxMessageService trxMessageService;

	@Scheduled(fixedRate = 2000)
	public void task1() {
		
		
		Optional<String> trxMessage = trxMessageService.getAndRemoveTrxMessage();
		
		while(trxMessage.isPresent()){
			log.info("task:{}", trxMessage);
			trxMessage = trxMessageService.getAndRemoveTrxMessage();
		}
		
	
	}

}
