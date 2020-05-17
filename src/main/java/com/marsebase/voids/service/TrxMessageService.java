package com.marsebase.voids.service;

import java.util.Optional;

public interface TrxMessageService {

	void saveTrxMessage(String trxMessage) throws Exception;

	Optional<String> getAndRemoveTrxMessage();

}