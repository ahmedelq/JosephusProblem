package test;

public class Soldiers {
	private int id;
	private boolean isKilled;
	
	public Soldiers(int id, boolean isKilled) {
		this.id = id;
		this.isKilled = isKilled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isKilled() {
		return isKilled;
	}

	public void setKilled(boolean isKilled) {
		this.isKilled = isKilled;
	}
	
	
}
