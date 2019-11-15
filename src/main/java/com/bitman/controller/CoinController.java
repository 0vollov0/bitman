package com.bitman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/coin")
public class CoinController {
	@RequestMapping("/coinSearch")
	public String coinSearch() {
		return "coinSearch";
	}
}
