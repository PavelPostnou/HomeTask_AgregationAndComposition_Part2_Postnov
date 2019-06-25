package by.htp.treasure.entity;

public class Treasure {

	private int id;
	private String treasureName;
	private int treasureCost;
	
	public Treasure (int id, String treasureName, int treasureCost) {
		
		this.id = id;
		this.treasureName = treasureName;
		this.treasureCost = treasureCost;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTreasureName() {
		return treasureName;
	}

	public void setTreasureName(String treasureName) {
		this.treasureName = treasureName;
	}

	public int getTreasureCost() {
		return treasureCost;
	}

	public void setTreasureCost(int treasureCost) {
		this.treasureCost = treasureCost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + treasureCost;
		result = prime * result + ((treasureName == null) ? 0 : treasureName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Treasure other = (Treasure) obj;
		if (id != other.id)
			return false;
		if (treasureCost != other.treasureCost)
			return false;
		if (treasureName == null) {
			if (other.treasureName != null)
				return false;
		} else if (!treasureName.equals(other.treasureName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Сокровище №= " + id + ", " + treasureName + ", стоимость = " + treasureCost + "\n";
	}
	
	

	
}
