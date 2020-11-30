import java.io.*;
import java.util.ArrayList;

import shapes.*;
//class ShapeException extends Exception 
//{
//	private static final long serialVersionUID = 1L;
//	public ShapeException(String msg) 
//	{
//		super(msg);
//	}
//}

/* your tasks:
 * create a class called ShapeException
 * createShape should throw a ShapeException
 * in main(), you should catch the ShapeException
 * 
 */
public class ReadShapeFileAnn {
// string pool
	public static GeometricObject createShape(String shapeName) throws Exception {
		System.out.println(shapeName);
		 if (shapeName.equals("Circle")) return new Circle();
		 else if (shapeName.equals("Square")) return new Square();
		 else if (shapeName.equals("Rectangle")) return new Rectangle();
		 else {
			 throw new Exception("Cannot create shape");  
		 }
	}

		 
		
		/* if shapeName is "Circle" return Circle();
		 * if shapeName is "Square" return Square();
		 * if shapeName is "Rectangle" return Rectangle();
		 * if it is not any one of these, it should throw
		 * a ShapeException
		 */
		

	
	public static void main(String[] args) throws FileNotFoundException,IOException {
		ArrayList<GeometricObject> shapeList = new ArrayList<GeometricObject>();
		File f = new File("shapes.txt");
		FileReader fr = null;
		BufferedReader in = null;
		fr = new FileReader(f);
		in = new BufferedReader(fr); 
		 
		
		String linea = in.readLine(); 
		
		/* create a loop to read the file line-by-line */

		while(linea != null) {
			try {
				shapeList.add(createShape(linea));
			}catch(Exception e) {
				System.out.println(e);
			}finally {
				linea = in.readLine();
			}
		}
		in.close();
		fr.close();
		
		System.out.println(shapeList);

//		}
	}
}
