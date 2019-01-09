/*
 * Jin Byoun
 * TCSS 342
 * Homework 1
 */

/*
 * this class is our own implemented class of linked nodes to be used for storing and sorting.
 */
public class LinkedNode {
	
	private LinkedNode myNextNode;
	
	private int myData;
	
	public LinkedNode() {
		
	}
	
	public LinkedNode(int theElement) {
		myData = theElement;
	}
	
	/*
	 * returns the next node.
	 */
	public LinkedNode getNext() {
		return myNextNode;
	}
	
	/*
	 * sets the next to point to the node.
	 */
	public void setNext(LinkedNode theNextNode) {
		myNextNode = theNextNode;
	}
	
	/**
	 * returns the element
	 * @return
	 */
	public int getElement() {
		return myData;
	}
	
	/**
	 * stores the current element
	 * @param theElement
	 */
	public void setElement(int theElement) {
	    myData = theElement;
	}
	
	@Override
    public String toString() {
        String result = myData + " ";

        if (myNextNode != null) {
            result += myNextNode.getElement();
        }
        return result;
    }
}
