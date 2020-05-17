package com.marsebase.voids.dao;

import java.util.Optional;

public interface TrxMessageDao {

	void save(String trxMessage);

	Optional<String> findAnyAndDelete();

}