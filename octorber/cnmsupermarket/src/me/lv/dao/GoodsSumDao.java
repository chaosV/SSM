package me.lv.dao;

import me.lv.pojo.GoodsSum;

public interface GoodsSumDao extends BaseDao<GoodsSum>{
	GoodsSum select(int sizeId, int goodsId);
}
