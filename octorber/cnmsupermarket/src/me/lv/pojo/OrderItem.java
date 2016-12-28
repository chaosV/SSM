package me.lv.pojo;

public class OrderItem {
	private int id;
	private int sum;
	private int orderId;
	private int goodsId;

	public OrderItem() {
		super();
	}

	public OrderItem(int id, int sum, int orderId, int goodsId) {
		super();
		this.id = id;
		this.sum = sum;
		this.orderId = orderId;
		this.goodsId = goodsId;
	}

	public OrderItem(int sum, int orderId, int goodsId) {
		super();
		this.sum = sum;
		this.orderId = orderId;
		this.goodsId = goodsId;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "OrderItem [sum=" + sum + ", orderId=" + orderId + ", goodsId=" + goodsId + "]";
	}

}
