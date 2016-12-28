package me.lv.pojo;

import java.util.List;

public class Order {
	private int id;
	private String orderNum;
	private String address;
	private int userLoginId;
	private int orderStatusId;
	private UserLogin userLogin;
	private OrderStatus orderstatus;
	private List<OrderItem> orderItems;
	
	public Order() {
		super();
	}


	public Order(String orderNum, String address, int userLoginId, int orderStatusId) {
		super();
		this.orderNum = orderNum;
		this.address = address;
		this.userLoginId = userLoginId;
		this.orderStatusId = orderStatusId;
	}


	public Order(int id, String orderNum, String address, int userLoginId, int orderStatusId) {
		super();
		this.id = id;
		this.orderNum = orderNum;
		this.address = address;
		this.userLoginId = userLoginId;
		this.orderStatusId = orderStatusId;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

	public OrderStatus getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(OrderStatus orderstatus) {
		this.orderstatus = orderstatus;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(int userLoginId) {
		this.userLoginId = userLoginId;
	}

	public int getOrderStatusId() {
		return orderStatusId;
	}

	public void setOrderStatusId(int orderStatusId) {
		this.orderStatusId = orderStatusId;
	}
	public UserLogin getUserLogin() {
		return userLogin;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNum=" + orderNum + ", address=" + address + ", userLoginId=" + userLoginId
				+ ", orderStatusId=" + orderStatusId + "]";
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
