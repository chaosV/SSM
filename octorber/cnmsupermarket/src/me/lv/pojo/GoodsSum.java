package me.lv.pojo;

public class GoodsSum {
	private int id;
	private int sum;
	private int goodsSizeId;
	private int goodsId;

	public GoodsSum() {
		super();
	}

	public GoodsSum(int id, int sum, int goodsSizeId, int goodsId) {
		super();
		this.id = id;
		this.sum = sum;
		this.goodsSizeId = goodsSizeId;
		this.goodsId = goodsId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getGoodsSizeId() {
		return goodsSizeId;
	}

	public void setGoodsSizeId(int goodsSizeId) {
		this.goodsSizeId = goodsSizeId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	@Override
	public String toString() {
		return "goodsSum [id=" + id + ", sum=" + sum + ", goodsSizeId=" + goodsSizeId + ", goodsId=" + goodsId + "]";
	}

}
