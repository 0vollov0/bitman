package com.bitman.coin.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitman.coin.dto.RealCoin;
import com.bitman.coin.mapper.CoinMapper;

@Service
public class CoinServiceImpl implements CoinService {
	@Autowired
	CoinMapper coinMapper;
	
	@Override
	public int crawlingCoinInfo() {
		String URL = "https://www.bithumb.com/";
		Document doc = null;
		try {
			doc = Jsoup.connect(URL).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int[] eq = {0,1,2,5};
		
		List<Elements> coinElementsList = new ArrayList<Elements>();
		List<RealCoin> realCoinList = new ArrayList<RealCoin>();
		for (int i = 0; i < eq.length; i++) {
			coinElementsList.add(doc.select(".coin_list").eq(eq[0]).select(".fvtWrap").eq(eq[i]));
		}
		
		for (int i = 0; i < eq.length; i++) {
			double coin_amount;
			String coin_asset_real;
			String coin_asset_total;
			coin_amount = Double.parseDouble(coinElementsList.get(i).select(".sort_real").text().replace(",","").replace("원", ""));
			coin_asset_real = coinElementsList.get(i).select(".sort_amount").text().replace("≈ ", "").replace(",","").replace(" 원","");
			coin_asset_total = coinElementsList.get(i).select(".sort_total").text();
			realCoinList.add(new RealCoin(i+1,coin_amount, coin_asset_real, coin_asset_total));
		}
		for (int i = 0; i < eq.length; i++) {
			RealCoin realCoin = realCoinList.get(i);
			coinMapper.updateRealCoinInfo(realCoin.getCoin_amount(),realCoin.getCoin_asset_real(),realCoin.getCoin_asset_total(),realCoin.getCoin_id());
		}
		return 0;
	}
}
