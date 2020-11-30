package fruit;

public class Apple extends Fruit{
	private String taste;
	private String texture;
	
	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public Apple() {
		super();
	}
	
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		if(obj instanceof Apple) {
			if (this.taste != ((Apple) obj).getTaste()) return false;
			if (this.texture != ((Apple) obj).getTexture()) return false;
			return true;
		}
		return false;
	}
	
	public Apple(String taste, String texture, String color, boolean rotten) {
		super(color, rotten);
		this.taste = taste;
		this.texture = texture;
	}
	
	public String toString() {
		return "Apple [ " + super.toString() + ", taste : " + this.getTaste() + ", texture : " + this.getTexture() + "]";  
	}

}
