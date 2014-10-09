/**
 * 
 */
package PROJECT_2;

import LINKED_LIST.LinkedList;
import STACKS_QUEUES.LinkedListStack;

/**
 * @author Dany
 *
 */
public class LinkedListArithmetic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListStack listStack=new LinkedListArithmetic().convertExpressionToStackList("4532+34*34");
		while(listStack.pop()!=null)
		{
			LinkedList lList=listStack.pop();
			if(lList.next==null)
			{
				System.out.println("Operator : "+lList.data);
			}
			while(lList.next!=null)
			{
				lList =lList.next;
				System.out.println("List Value : "+lList.data);
			}
		}
	}
	
	public LinkedListStack convertExpressionToStackList(String expr)
	{
		LinkedListStack listStack=null;
		String sNumber="";
		StringBuffer sBuffer=new StringBuffer();
		
		for(int i=0;i<expr.length();i++)
		{
			char chr=expr.charAt(i);
			if(Character.isDigit(chr))
			{
				sBuffer.append(chr);
				if(!Character.isDigit(expr.charAt(++i)))
				{
					sNumber=sBuffer.toString();
					if(listStack==null)
					listStack=new LinkedListStack(convertNumtoList(sNumber));
					listStack.push(convertNumtoList(sNumber));
				}
			}
			if(listStack==null)
				listStack=new LinkedListStack(covertOperatorSymbolToList(Character.toString(chr)));
			listStack.push(convertNumtoList(sNumber));

		}
		
		return listStack;
	}
	
	public LinkedList convertNumtoList(String num)
	{
		LinkedList inList=null;
		int div;
		String sDigit="";
		int nData=Integer.parseInt(num);
		
		for(int i=0;i<num.length();i++)
		{
			 div=nData%10;
			 sDigit=Integer.toString(div);
			 if(inList==null)
				 inList=new LinkedList(sDigit);
			 inList.insertEnd(sDigit);
			 nData=nData/10;
		}
		return inList;
	}
	
	public LinkedList covertOperatorSymbolToList(String oprData)
	{
		return new LinkedList(oprData);

	}

}
