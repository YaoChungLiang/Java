package fruit;

public class Citris extends Fruit {
	private String taste;
	
	public Citris() {
		super();
	}
	
	public Citris(String taste, String color, boolean rotten) {
		super(color, rotten);
		this.taste = taste;
	}
	
	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}
	
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		if(obj instanceof Citris) {
			if (this.taste != ((Citris)obj).taste) return false;
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "Citris [ " + super.toString() + ", taste : " + this.getTaste() +"]";  
	}
}
