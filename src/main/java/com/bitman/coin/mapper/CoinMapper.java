package com.bitman.coin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CoinMapper {
	void updateRealCoinInfo(@Param(value = "coin_amount") double coin_amount,
			@Param(value = "coin_asset_real") String coin_asset_real,
			@Param(value = "coin_asset_total") String coin_asset_total, @Param(value = "coin_id") int coin_id);
}
