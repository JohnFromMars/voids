package com.marsebase.voids.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.marsebase.voids.service.TrxMessageService;

@RestController
public class TrxMessageController {

	private Logger log = LogManager.getFormatterLogger(TrxMessageController.class);

	@Autowired
	private TrxMessageService trxMessageService;

	@PostMapping("/trxMessage")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveTrxMessage(@RequestBody String trxMessage) throws Exception {
		log.info("save message is called..");
		trxMessageService.saveTrxMessage(trxMessage);
	}

}
