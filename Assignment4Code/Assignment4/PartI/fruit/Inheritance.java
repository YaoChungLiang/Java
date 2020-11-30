package fruit;

public class Inheritance {

	public static void main(String[] args) {
		// Here's some scratch space to experiment/debug your Fruit objects
		Fruit a = new Fruit();
		System.out.println(a);
		Apple b = new Apple("good", "crossbar", "red", true);
		Apple c = new Apple("good", "crossbar", "red", true);
		System.out.println(b);
		System.out.println(c.equals(b));
	}

}
