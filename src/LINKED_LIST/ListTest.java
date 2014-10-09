/**
 * 
 */
package LINKED_LIST;

/**
 * @author Dany
 *
 */
public class ListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		
		 long inTime = System.nanoTime();
			LinkedList lObject=new LinkedList("10");
			lObject.insertFirst("15");
			lObject.insertFirst("18");
			lObject.insertFirst("32");
			lObject.insertFirst("45");
			lObject.traverseList();
			long pTime = System.nanoTime();
			System.out.println(" Time in Secs MergeSort (2): " + (pTime - inTime));
			lObject=lObject.insertEnd("343");
			
			lObject.traverseList();
			
			
			
			
			
		/*
		long inTime = System.nanoTime();
			java.util.LinkedList<String> lObject=new java.util.LinkedList<String>();
			lObject.addFirst("10");
			lObject.addFirst("15");
			lObject.addFirst("18");
			lObject.addFirst("32");
		    lObject.addFirst("45");
			lObject.addLast("343");
			
			for(String s : lObject)
			{
				System.out.println("  "+s);
			}
			long pTime = System.nanoTime();
			System.out.println(" Time in Secs MergeSort (2): " + (pTime - inTime));*/

			
		}
	
	

}
