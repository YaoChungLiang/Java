package fruit;

public class Lemon extends Citris {
	private int sourness;
	
	public int getSourness() {
		return sourness;
	}

	public void setSourness(int sourness) {
		this.sourness = sourness;
	}

	public Lemon() {
		super();
	}
	
	public Lemon(int sourness, String taste, boolean rotten) {
		super(taste, "yellow", rotten);
		this.sourness = sourness;
	}
	
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		if(obj instanceof Lemon) {
			if(this.sourness != ((Lemon)obj).sourness) return false;
			return true;
		}
		return false;
	}	
	public String toString() {
		return "Lemon [ " + super.toString() + ", sourness : " + this.getSourness() +"]"; 
	}
}
