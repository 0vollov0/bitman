package com.bitman.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bitman.coin.service.CoinServiceImpl;

@Component
public class CronTable {
	@Autowired
	CoinServiceImpl coinService;

	@Scheduled(cron = "0 00 0 * * *")
    public void updateRealCoinInfo() {
		coinService.crawlingCoinInfo();
    }
}
