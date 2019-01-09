import java.io.PrintWriter;

public class Sorting {

    private static int pass;
    private static int cmp;
    private static int exch;
    private static int length;
    private static double k;
    private static int totalPass;
    private static int totalCmp;
    private static int totalExch;
    private static PrintWriter writer;


    public Sorting(int theLength, PrintWriter theWriter) {
        length = theLength;
        pass = 0;
        cmp = 0;
        exch = 0;
        k = 0;
        totalPass = 0;
        totalCmp = 0;
        totalExch = 0;
        writer = theWriter;
    }

    public void bubbleSort(LinkedNode first) {

    	LinkedNode previous, current, next;    
    	

    	boolean swapped = true;
    	if (k != 1) {
    		resultBubbleSortTitle();
    	}
    	while (swapped) {
    		previous = first;
    		current = first.getNext();
    		next = first.getNext().getNext();
    		swapped = false;

    		while (next != null) {
    			cmp++;
    			if (current.getElement() > next.getElement()) {
    				exch++;
    				current.setNext(next.getNext());
    		        next.setNext(current);
    		        previous.setNext(next);
    				current = previous.getNext();
    				next = previous.getNext().getNext();
    				swapped = true;
    			}

    			previous = previous.getNext();
    			current = current.getNext();
    			next = next.getNext();
    		}

    		pass++;
    		totalPass++;
    		totalCmp += cmp;
    		totalExch += exch;
    		if (k != 1) {
        		resultBubbleSort();
        	} 
    	}
    	if (k != 1) {
    		resultBubbleSortTotal();
    	} 

    }

    public void shellSort(LinkedNode first) {

    	pass = 0;
        cmp = 0;
        exch = 0;

        totalPass = 0;
        totalCmp = 0;
        totalExch = 0;

        LinkedNode current, next, currentPrev, nextPrev;      

        boolean swapped = true;

        int index = 0;
        int extra = 0;
        

      
        resultShellSortTitle();
        // find k
        while (((Math.pow(3, index) - 1) / 2) < length) {
            k = (Math.pow(3, index) - 1) / 2;
            ++index;
        }
        index--;
        
        while (k > 1) {

            swapped = true;

            current = first.getNext();
            next = first.getNext();
            currentPrev = first;
            nextPrev = first;

            for (int i = 0; i < k; i++) {
                nextPrev = next;
                next = next.getNext();
            }

            extra = length - (int) k;

            while (swapped) {
                swapped = false;

                while (next != null) {
                   cmp++;
                    if (current.getElement() > next.getElement()) {
                    	exch++;
                    	nextPrev.setNext(next.getNext());
                        next.setNext(current.getNext());
                        currentPrev.setNext(next);
                        current.setNext(nextPrev.getNext());
                        nextPrev.setNext(current);

                        currentPrev = currentPrev.getNext();
                        nextPrev = nextPrev.getNext();
                        current = currentPrev.getNext();
                        next = nextPrev.getNext();

                        swapped = true;
                        
                    }

                    else {
                        currentPrev = currentPrev.getNext();
                        nextPrev = nextPrev.getNext();
                        current = currentPrev.getNext();
                        next = nextPrev.getNext();
                    }
                }
                pass++;

                current = first.getNext();
                next = first.getNext();
                currentPrev = first;
                nextPrev = first;

                for (int i = 0; i < k; i++) {
                    nextPrev = next;
                    next = next.getNext();
                }
                resultShellSort();
            }


            pass -= 1;
            totalPass += pass;
            totalCmp += cmp-extra;
            totalExch += exch;
            resultShellSortTotal();
            k = (Math.pow(3, --index) - 1) / 2;
            extra = length - (int) k;
            
        }

        if (k == 1) {
            bubbleSort(first);
        }

    }
   
    private void resultBubbleSortTitle() {

    	System.out.println("\nBUBBLE SORT\n");
    	System.out.println("------------------------------------------\n");
    	System.out.println("       pass  cmp   exch  \n");
    	System.out.println("------------------------------------------");
    	writer.println("\nBUBBLE SORT\n");
    	writer.println("------------------------------------------\n");
    	writer.println("       pass  cmp   exch   \n");
    	writer.println("------------------------------------------");
    	
    	

    }
    
    private void resultBubbleSort() {

	    	System.out.println("       " + pass + "     " + cmp + "    " + exch);
	    	writer.println("      " + pass + "     " + cmp + "    " + exch);

    }
    
    private void resultBubbleSortTotal() {
    	
    	System.out.println("------------------------------------------");
    	System.out.println("Total: " + totalPass + "   " + totalCmp + "   " + totalExch);
    	writer.println("------------------------------------------");
    	writer.println("Total: " + totalPass + "   " + totalCmp + "   " + totalExch);

    }
    

    private void resultShellSortTitle() {
    	System.out.println("\nSHELL SORT\n");
    	System.out.println("------------------------------------------\n");
    	System.out.println("   k   pass  cmp  exch   ");
    	System.out.println("------------------------------------------");
    	writer.println("\nSHELL SORT\n");
    	writer.println("------------------------------------------\n");
    	writer.println("   k   pass  cmp  exch   ");
    	writer.println("-------------------------------------------");
    
    }
    
    private void resultShellSort() {

    	System.out.println("   k   " + pass + "    " + cmp + "    " + exch);
    	writer.println("   k    " + pass + "    " + cmp + "    " + exch);
    	
    }
    
    private void resultShellSortTotal() {
    	System.out.println("------------------------------------------");
    	System.out.println("Total: " + totalPass + "   " + totalCmp + "   " + totalExch);
    	writer.println("------------------------------------------");
    	writer.println("Total: " + totalPass + "   " + totalCmp + "   " + totalExch);
    }
}