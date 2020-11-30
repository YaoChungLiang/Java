package arraylists;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import fruit.*;



public class FruitArraylist {

	public static void main(String[] args) {
		
		// this ArrayList MUST be parameterized
		ArrayList<Fruit> fruitArrayList = new ArrayList<Fruit>();
//		Apple A = new Apple("sweet", "crisp","red",false);
//		Apple B = new Apple("tart", "soft", "green", true);
//		Lemon L = new Lemon(new Random().nextInt(101), "sour", false);
//		Orange Z = new Orange("mandarin", "sweet", true);
		
		fruitArrayList.add(new Apple("sweet", "crisp","red",false));
		fruitArrayList.add(new Apple("tart", "soft", "green", true));
		fruitArrayList.add(new Apple("tart", "soft", "green", true));
		fruitArrayList.add(new Lemon(new Random().nextInt(101), "sour", false));
		fruitArrayList.add(new Lemon(new Random().nextInt(101), "sour", false));
		fruitArrayList.add(new Lemon(new Random().nextInt(101), "sour", false));
		fruitArrayList.add(new Orange("mandarin", "sweet", true));
		fruitArrayList.add(new Orange("mandarin", "sweet", true));
		// b : average of sourness
		int avg = 0, num = 0;
		for(Fruit i : fruitArrayList) {
			if (i instanceof Lemon) {
				avg += ((Lemon) i).getSourness();
				num += 1;
			}
		}
		System.out.println("Average sourness : " +  1.0*avg/num);
		
		// c
		// identify the first rotten green apple
		Apple var = new Apple();
		for(Fruit i : fruitArrayList) {
			if(i instanceof Apple && i.isRotten() && i.getColor()=="green"){
				var = (Apple)i;
				break;
			}
		}
		// looking for apples with the same values
		System.out.println("Apples share same values");
		for(Fruit i : fruitArrayList) {
			if (i.equals(var)) System.out.println(i);
		}
		// looking for same object
		System.out.println("Apples that are same objects");
		for(Fruit i : fruitArrayList) {
			if (i == var) System.out.println(i);
		}
		
		for(int i = fruitArrayList.size()-1; i >= 0; i--) {
			if(fruitArrayList.get(i).equals(var) || fruitArrayList.get(i)==var) {
				fruitArrayList.remove(i);
			}
		}
		
		System.out.println("remainings");
		for(Fruit i : fruitArrayList) {
			System.out.println(i);
		}
	
	}
}
