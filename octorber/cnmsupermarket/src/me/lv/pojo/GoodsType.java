package me.lv.pojo;

public class GoodsType {
	private int id;
	private String name;
	private int subTypeId;
	private SubType subType;

	public SubType getSubType() {
		return subType;
	}

	public void setSubType(SubType subType) {
		this.subType = subType;
	}

	public GoodsType() {
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

	public int getSubTypeId() {
		return subTypeId;
	}

	public void setSubTypeId(int subTypeId) {
		this.subTypeId = subTypeId;
	}

	@Override
	public String toString() {
		return "GoodsType [id=" + id + ", name=" + name + ", subTypeId=" + subTypeId + "]";
	}

}
