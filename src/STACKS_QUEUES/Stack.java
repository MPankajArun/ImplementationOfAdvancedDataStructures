/**
 * 
 */
package STACKS_QUEUES;

/**
 * @author Dany
 *
 */
public class Stack {

	String[] sArray;
    public int top;
	public Stack(int size)
	{
		sArray=new String[(int) size];
		top=-1;
	}
	
	public String pop()
	{
		return sArray[top--];
	}
	public void push(String value)
	{
		sArray[++top]=value;
	}
	public String peek()
	{
		return sArray[top];
	}

	public int getTop() {
		return top;
	}
}
