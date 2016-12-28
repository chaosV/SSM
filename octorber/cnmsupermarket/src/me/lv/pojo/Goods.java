package me.lv.pojo;

import java.util.Date;
import java.util.List;

public class Goods {
	private int id;
	private String name;
	private String url;
	private double price;
	private double discount;
	private Date creatDate;
	private int expiryDate;
	private String producer;
	private String desc;
	private int goodsTypeId;
	private GoodsType goodsType;
	
	
	
	
	public Goods(String name, String url, double price, double discount, Date creatDate, int expiryDate,
			String producer, String desc, int goodsTypeId,int id) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.price = price;
		this.discount = discount;
		this.creatDate = creatDate;
		this.expiryDate = expiryDate;
		this.producer = producer;
		this.desc = desc;
		this.goodsTypeId = goodsTypeId;
	}

	public Goods(String name, String url, double price, double discount, Date creatDate, int expiryDate,
			String producer, String desc, int goodsTypeId) {
		super();
		this.name = name;
		this.url = url;
		this.price = price;
		this.discount = discount;
		this.creatDate = creatDate;
		this.expiryDate = expiryDate;
		this.producer = producer;
		this.desc = desc;
		this.goodsTypeId = goodsTypeId;
	}

	public Goods(int id, String name, String url, double price, double discount, Date creatDate, int expiryDate,
			String producer, String desc, int goodsTypeId) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.price = price;
		this.discount = discount;
		this.creatDate = creatDate;
		this.expiryDate = expiryDate;
		this.producer = producer;
		this.desc = desc;
		this.goodsTypeId = goodsTypeId;
	}

	private List<GoodsSum> goodsSums;
	public GoodsType getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	public Goods() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}

	public int getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(int expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public int getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(int goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", url=" + url + ", price=" + price + ", discount=" + discount
				+ ", creatDate=" + creatDate + ", expiryDate=" + expiryDate + ", producer=" + producer
				+ ", goodsTypeId=" + goodsTypeId + ", desc=" + desc + "]";
	}

	public List<GoodsSum> getGoodsSums() {
		return goodsSums;
	}

	public void setGoodsSums(List<GoodsSum> goodsSums) {
		this.goodsSums = goodsSums;
	}

}
