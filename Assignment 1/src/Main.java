/*
 * Jin Byoun
 * TCSS 342
 * Homework 1
 */

/**
 * this main class that will run the sorting algorithims.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		int length, length2;
		PrintWriter writer = null;
		LinkedNode initialNode = new LinkedNode();
		LinkedNode copy = new LinkedNode();
		
		try {
			
			
            writer = new PrintWriter(new FileOutputStream("output.txt"));
            length = readValues(initialNode);
            //length2 = readValues(copy);
            
            Sorting2 sort = new Sorting2(length, writer);
            sort.bubbleSort(initialNode);
            displayList(initialNode);
            /*
            Sorting sort = new Sorting(length, writer);
            
      
            
            sort.bubbleSort(copy);
           	sort.shellSort(initialNode);
            */
    		
    		//displayList(initialNode);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());

        } 
		writer.close();
		


	
	}

	public static int readValues(LinkedNode theInitialNode) {
		int length = 1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("What file should we look at?");
		String fileName = scanner.next();
		File file = new File(fileName);
		
		Scanner scanner2;
		try {
			scanner2 = new Scanner(file);
			int initialData = scanner2.nextInt();
			theInitialNode.setElement(initialData);
			while (scanner2.hasNext()) {
				int data = scanner2.nextInt();
				LinkedNode nextNode = new LinkedNode(data);
				length++;
				theInitialNode.setNext(nextNode);
				theInitialNode = theInitialNode.getNext();
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return length;
		
	}
	
	public static void displayList(LinkedNode theInitialNode) {

		while (theInitialNode != null) {
			
            System.out.println(theInitialNode.getElement());
            theInitialNode = theInitialNode.getNext();
        }
	
	}

}