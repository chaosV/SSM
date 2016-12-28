package me.lv.pojo;

public class GoodsSize {
	private int id;
	private String size;

	public GoodsSize() {
		super();
	}

	public GoodsSize(int id, String size) {
		super();
		this.id = id;
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "GoodsSize [id=" + id + ", size=" + size + "]";
	}

}
