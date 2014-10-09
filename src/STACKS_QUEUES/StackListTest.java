/**
 * 
 */
package STACKS_QUEUES;

import LINKED_LIST.LinkedList;

/**
 * @author Dany
 *
 */
public class StackListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList lObject=new LinkedList("10");
		lObject.insertEnd("15");
		lObject.insertEnd("18");
		//lObject.traverseList();
		LinkedListStack sList=new LinkedListStack(lObject);
		LinkedList lObject1=new LinkedList("435");
		lObject1.insertEnd("7437");
		lObject1.insertEnd("32232");
		//lObject1.traverseList();
		
		sList.push(lObject1);
		if(sList.next==null)
		{
			LinkedList lList=sList.pop();
			lList.traverseList();
		}
		
		while(sList.next!=null)
		{
			LinkedList lList=sList.pop();
			
			sList=sList.next;
			lList.traverseList();
		}

		
		
		
		
	}
	
	 

}
