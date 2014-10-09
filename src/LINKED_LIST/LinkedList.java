/**
 * 
 */
package LINKED_LIST;

/**
 * @author Dany
 *
 */
public class LinkedList {

	public LinkedList next=null;
	public String data;
	
	public LinkedList(String value)
	{
		this.data=value;
	}
	

	public void insertFirst(String data)
	{
	
		LinkedList head=this;
		LinkedList firstNode=new LinkedList(data);
		firstNode.next=head;
		head=firstNode;
	}
	
	public LinkedList insertEnd(String data)
	{
	LinkedList head=this;
	LinkedList temp=head;

	if(temp.next==null)
	{
		temp.next=new LinkedList(data);
		return head;
	}
	while(temp.next!=null)
	{
		temp=temp.next;
	}
	temp.next=new LinkedList(data);
	return head;
	}
	
	public void traverseList()
	{
		LinkedList head=this;
		System.out.println("List Value : "+head.data);
		if(head.next==null)
		System.out.println("List Value : "+head.data);
		while(head.next!=null)
		{
			head=head.next;
			System.out.println("List Value : "+head.data);
			
		}
	}

}
