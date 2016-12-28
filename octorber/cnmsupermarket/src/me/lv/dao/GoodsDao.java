package me.lv.dao;

import java.util.List;

import me.lv.pojo.Goods;

public interface GoodsDao extends BaseDao<Goods> {

	Goods selectGoodsById(int goodsId);

	List<Goods> selectGoodses();

}
