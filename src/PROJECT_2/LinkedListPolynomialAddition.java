/**
 * 
 */
package PROJECT_2;

import java.util.LinkedList;

/**
 * @author Dany
 *
 */
public class LinkedListPolynomialAddition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Node> res=new LinkedListPolynomialAddition().frameList("5429", 10000);
		while(res.peek()!=null)
		{
			Node newNode=new Node();
			newNode=res.pop();
			System.out.println("Co eff :"+newNode.sCoEff);
			System.out.println("Exp :"+newNode.sBase);
			System.out.println("Base :"+newNode.exp);
		}
		LinkedList<Node> res1=new LinkedListPolynomialAddition().frameList("7526", 10000);
		while(res1.peek()!=null)
		{
			Node newNode1=new Node();
			newNode1=res1.pop();
			System.out.println("Co eff 2:"+newNode1.sCoEff);
			System.out.println("Exp 2:"+newNode1.sBase);
			System.out.println("Base 2:"+newNode1.exp);
		}
		
		LinkedList<Node> addedNde=new LinkedListPolynomialAddition().addNumber(res, res1, 10000);
		while(addedNde.peek()!=null)
		{
			Node newNode12=new Node();
			newNode12=addedNde.pop();
			System.out.println("Co eff 2:"+newNode12.sCoEff);
			System.out.println("Exp 2:"+newNode12.sBase);
			System.out.println("Base 2:"+newNode12.exp);
		}
		
	}
	
	public LinkedList<Node> frameList(String sNumber, int nBase)
	{
		int nExp=0;
		int noOfDigit=1;
		int noOfNodes;
		
		noOfDigit=(int) Math.log10(nBase);
		
		//To identify the no of nodes for the linked list . may have an extra node for less than 4 digits
		noOfNodes=sNumber.length()/noOfDigit;
		
		LinkedList<Node> resList=new LinkedList<Node>();
		for(int i=0;i<noOfNodes;i++)
		{
			Node newNode=new Node();
			newNode.sCoEff=Integer.parseInt(sNumber.substring((sNumber.length())-noOfDigit, sNumber.length()));
			newNode.sBase=nBase;
			newNode.exp=nExp;
			resList.addLast(newNode);
			sNumber=sNumber.substring(0, sNumber.length()-noOfDigit);
			nExp++;
		}
		if(sNumber.length()>0)
		{
			Node newNode=new Node();
			newNode.sCoEff=Integer.parseInt(sNumber);
			newNode.sBase=nBase;
			newNode.exp=nExp;
			resList.addLast(newNode);
			
		}
		
		return resList;
		
	}

	public LinkedList<Node> addNumber(LinkedList<Node> lList1, LinkedList<Node> lList2, int nBase)
	{
		LinkedList<Node> resList=new LinkedList<Node>();
		int nNum1=0;
		int nNum2=0;
		int nCarry=0;
		int nExp=0;
		int base=nBase;
		int res=0;
		if(lList1==null||lList2==null)
			return null;
		while((lList1.peek()!=null) || (lList2.peek()!=null))
		{
			if((lList1.peek()!=null) && (lList2.peek()!=null))
			{
			Node newNode1=lList1.pop();
			Node newNode2=lList2.pop();
			Node addedNode=new Node();
			nNum1=newNode1.sCoEff;
			nNum2=newNode2.sCoEff;
			//Inserting base and exp of any of the number because we are accessing from right most bit
			base=newNode1.sBase;
			nExp=newNode1.exp;
			
			//To add the result set
			res=nCarry+nNum1+nNum2;
			//To make the carry as zero.if carry is not zero new node must be inserted
			nCarry=0;
			nCarry=res/base;
			res=res%base;
			
			addedNode.sCoEff=res;
			addedNode.exp=nExp;
			addedNode.sBase=base;
			
			resList.addLast(addedNode);
			}else{
				LinkedList<Node> contList;
				Node newNode=new Node();
				contList=(lList1.peek()!=null)?lList1:lList2;
				while(contList.peek()!=null)
				{
					newNode=contList.pop();
					newNode.sCoEff=newNode.sCoEff+nCarry;
					nExp=newNode.exp;
					nCarry=0;
					
					resList.addLast(newNode);
				}
			}
		}
		//To insert the last carry of the addition
		if(nCarry!=0)
		{
			Node newNode=new Node();
			newNode.sCoEff=nCarry;
			newNode.exp=nExp+1;
			newNode.sBase=nBase;
			
			resList.addLast(newNode);
			
		}
		
		return resList;
	}
	
}
