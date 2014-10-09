/**
 * 
 */
package STACKS_QUEUES;

import LINKED_LIST.LinkedList;

/**
 * @author Dany
 *
 */
public class LinkedListStack {

	public LinkedListStack next;
	public LinkedList listData;
	
	public LinkedListStack(LinkedList listData)
	{
		this.listData=listData;
		this.next=null;
	}
	
	public LinkedListStack push(LinkedList data)
	{
		LinkedListStack topNode=this;
		LinkedListStack newNode=new LinkedListStack(data);
		newNode.next=topNode;
		topNode=newNode;
		return topNode;
	}
	public LinkedList pop()
	{
		LinkedListStack topNode=this;
		LinkedList topNodeList;
		if(topNode.next==null)
		{
			topNodeList=topNode.listData;
			topNode=null;
			
		}else
		{
		topNodeList=topNode.listData;
		topNode=topNode.next;
		}
		return topNodeList;

	}
	public LinkedList peek()
	{
		LinkedListStack topNode=this;
		LinkedList lData=topNode.listData;
		return lData;
	}

}
