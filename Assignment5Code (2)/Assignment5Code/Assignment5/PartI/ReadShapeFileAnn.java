import java.io.*;
import java.util.ArrayList;

import shapes.*;
class ShapeException extends Exception 
{
   
   public ShapeException(String msg) 
   {
      super(msg);
   }
}

/* your tasks:
 * create a class called ShapeException
 * createShape should throw a ShapeException
 * in main(), you should catch the ShapeException
 * 
 */
public class ReadShapeFile {

	public static GeometricObject createShape(String shapeName) throws ShapeException {
		
			 if (shapeName == "Circle") return new Circle();
			 if (shapeName == "Square") return new Square();
			 if (shapeName == "Rectangle") return new Rectangle();
			 else {
				 throw new ShapeException("Cannot create shape");
					  
			 }}

		 
		
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
		
		try {int numLines = 0;
			
            while (linea  != null) {
            	GeometricObject shape = createShape(linea);
                System.out.println(shape);
                System.out.println(shapeList);
                numLines++;
            }
            return;
			
			
		} catch ( ShapeException  se) {
			System.err.println("Cannot create shape: " + linea);
			
		}
		finally{

		System.out.println(shapeList);
		in.close();
		fr.close();
		}
	}
}
