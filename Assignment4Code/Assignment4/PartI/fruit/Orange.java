package fruit;

public class Orange extends Citris {
	private String type;

	public Orange() {
		super();
	}
	
	public Orange(String type, String taste, boolean rotten) {
		super(taste, "orange", rotten);
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		if(obj instanceof Orange) {
			if(this.type != ((Orange)obj).type) return false;
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "Orange [ " + super.toString() + ", type : " + this.getType() +"]"; 
	}
	
}
