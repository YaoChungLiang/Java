package fruit;

public class Fruit {
	private String color;
	private boolean rotten;
	private static int next_id;
	private int id;
	
	public Fruit() {
		this.id = next_id;
		next_id ++;
	}
	
	public Fruit(String color, boolean rotten) {
		this();
		this.color = color;
		this.rotten = rotten;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public boolean isRotten() {
		return this.rotten;
	}
	
	public void setRotten(boolean rotten) {
		this.rotten = rotten;
	}
	
	public int getId() {
		return this.id;
	}
	
	public boolean equals(Object obj) {  
		if(obj instanceof Fruit) {
			if (this.color != ((Fruit) obj).getColor()) return false;
			if (this.rotten != ((Fruit) obj).isRotten()) return false;
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "Class : Fruit, Id: " + this.id + ", my color : " + this.color + ", rotten is " + this.rotten;
	}
}
