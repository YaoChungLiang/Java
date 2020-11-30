import java.io.*;
import java.util.List;
import java.util.ArrayList;
 
public class ListOfNumbers {
	
    private List<Integer> list;
    private String inFile;
    private static final int SIZE = 10;
 
    public ListOfNumbers () {
    	 list = new ArrayList<Integer>(SIZE);
         for (int i = 0; i < SIZE; i++)
             list.add(new Integer(i));

    }
    

    public ListOfNumbers (String inFile) {
    	this();
    	this.inFile = inFile;	
    }
    
    
    public void readList(String fileName) {
    	
        String line = null;

    
        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "r");
            while ((line = raf.readLine()) != null) {
                Integer i = new Integer(Integer.parseInt(line));
                System.out.println(i);
                list.add(i);
                raf.close();
                
            }
        } catch(FileNotFoundException fnfe) {
            System.err.println("File: " + fileName + " not found.");
        } catch (IOException ioe) {
            System.err.println(ioe.toString());
        }
        
    }
    
    public void writeList() {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("outFile.txt"));
            for (int i = 0; i < list.size(); i++)
                out.println("Value at: " + i + " = " + list.get(i));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                                 e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
    
    public static void cat(String fileName) {
        RandomAccessFile input = null;
        String line = null;
        File file = new File(fileName);
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        } catch(FileNotFoundException fnf) {
            System.err.format("File: %s not found%n", file);
        } catch(IOException e) {
            System.err.println(e.toString());
        } finally {
            if (input != null) {
           
            try {
                input.close();
            } catch(IOException io) {
            }
        }
    }
    }
    
    public static void main(String[] args) {
    	ListOfNumbers listOfNumbers = new ListOfNumbers("numberfile.txt");
    	ListOfNumbers.cat("numberfile.txt");
    	listOfNumbers.readList("numberfile.txt");
    }

}
