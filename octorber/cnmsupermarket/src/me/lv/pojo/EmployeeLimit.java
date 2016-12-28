package me.lv.pojo;

public class EmployeeLimit {
	private int id;
	private String level;

	public EmployeeLimit() {
		super();
	}

	public EmployeeLimit(int id, String level) {
		super();
		this.id = id;
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "EmployeeLimit [id=" + id + ", level=" + level + "]";
	}

}
