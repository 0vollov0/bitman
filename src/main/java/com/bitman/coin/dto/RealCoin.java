package com.bitman.coin.dto;

public class RealCoin {
	private int coin_id;
	private double coin_amount;
	private String coin_asset_real;
	private String coin_asset_total;

	public RealCoin(int coin_id,double coin_amount, String coin_asset_real, String coin_asset_total) {
		this.coin_id = coin_id;
		this.coin_amount = coin_amount;
		this.coin_asset_real = coin_asset_real;
		this.coin_asset_total = coin_asset_total;
	}

	public int getCoin_id() {
		return coin_id;
	}

	public void setCoin_id(int coin_id) {
		this.coin_id = coin_id;
	}

	public double getCoin_amount() {
		return coin_amount;
	}

	public void setCoin_amount(double coin_amount) {
		this.coin_amount = coin_amount;
	}

	public String getCoin_asset_real() {
		return coin_asset_real;
	}

	public void setCoin_asset_real(String coin_asset_real) {
		this.coin_asset_real = coin_asset_real;
	}

	public String getCoin_asset_total() {
		return coin_asset_total;
	}

	public void setCoin_asset_total(String coin_asset_total) {
		this.coin_asset_total = coin_asset_total;
	}

	@Override
	public String toString() {
		return "RealCoin [coin_id=" + coin_id + ", coin_amount=" + coin_amount + ", coin_asset_real=" + coin_asset_real
				+ ", coin_asset_total=" + coin_asset_total + "]";
	}

}
