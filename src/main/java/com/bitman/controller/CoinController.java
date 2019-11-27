package com.bitman.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/coin")
public class CoinController {
	@GetMapping("/coinSearch")
	public String coinSearch() {
		
		return "coin/coinSearch";
	}
	
	@ResponseBody
	@GetMapping("/result")
	public Object coinInfo(String coinQ) {
		JSONObject jsonData = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		System.out.println(":: coin searching page ::");
		String coinName = coinQ;
		String url = "https://coinmarketcap.com/ko/currencies/"+coinName;

		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		}catch(Exception e) {
			e.printStackTrace();
		}
		Elements data1 = doc.select("ul.cmc-details-panel-stats");
		Elements data2 = data1.select("li");
		
		System.out.println("-----------------------------");
		for(int i = 0; i < data2.size(); i++) {
			if(i == 0 || i == 1) {
				Elements title = data2.get(i).select("h5");
				System.out.println(":: " + title.text() + " ::");
				Elements coinTotal = data2.get(i).select("span");
				Elements KRW = coinTotal.get(0).select("span");
				Elements coin = coinTotal.get(1).select("span");
				System.out.println(KRW.text());
				System.out.println(coin.text());
				if(i == 0) {
					jsonData.put("title", title.text());
					jsonData.put("content", KRW.text());
					jsonData.put("content", coin.text());
					jsonArray.add(jsonData);
					
				}else if(i == 1) {
					jsonData.put("title", title.text());
					jsonData.put("content", KRW.text());
					jsonData.put("content", coin.text());
					jsonArray.add(jsonData);
					
				}
				
			}else {
				Elements title = data2.get(i).select("h5");
				System.out.println(":: " + title.text() + " ::");
				Elements coinAmount = data2.get(i).select("div");
				System.out.println(coinAmount.text());
			}
		}
		
		System.out.println("-----------------------------");
		System.out.println(">>>"+jsonArray.toString());
		
		return jsonArray;
	}
	
}
