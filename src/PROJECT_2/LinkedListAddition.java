/**
 * 
 */
package PROJECT_2;

import java.util.LinkedList;


/**
 * @author Dany
 *
 */
public class LinkedListAddition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long inTime=System.currentTimeMillis();
		
		LinkedList<Node> res=new LinkedListPolynomialAddition().frameList("999999999999999999999999999999999999999999999999999999999999999999999999999999", 10000);
		LinkedList<Node> res1=new LinkedListPolynomialAddition().frameList("999999999999999999999999999999999999999999999999999999999999999999999999999999", 10000);

		String sRes=new LinkedListAddition().addNumber(res, res1, 10000);
		System.out.println("OUTPUT : "+sRes);
		long pTime=System.currentTimeMillis();
		System.out.println("Time in Secs "+(pTime-inTime));

	}
	
	public String addNumber(LinkedList<Node> lList1, LinkedList<Node> lList2, int nBase)
	{
		LinkedList<Node> resList=new LinkedList<Node>();
		String sResult="";
		String sData="";
		
		
		int nNum1=0;
		int nNum2=0;
		int nCarry=0;
		int nExp1=0;
		int nExp2=0;
		int base=nBase;
		int res=0;
		int nCoEff=0;
		int noOfDigit=(int) Math.log10(nBase);


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
			nExp1=newNode1.exp;
			
			//To add the result set
			res=nCarry+nNum1+nNum2;
			//To make the carry as zero.if carry is not zero new node must be inserted
			nCarry=0;
			nCarry=res/base;
			//System.out.println("carry after addition : "+nCarry);
			res=res%base;
			//System.out.println("result : "+res);

			addedNode.sCoEff=res;
			addedNode.exp=nExp1+nExp2;
			addedNode.sBase=base;
			
			resList.addLast(addedNode);
			}else{
				LinkedList<Node> contList;
				Node newNode=new Node();
				contList=(lList1.peek()!=null)?lList1:lList2;

				while(contList.peek()!=null)
				{
					newNode=contList.pop();
					res=newNode.sCoEff+nCarry;
					newNode.sCoEff=res;
					nExp1=newNode.exp;
					nCarry=0;
					
					nCarry=res/base;
					//System.out.println("carry after addition : "+nCarry);
					res=res%base;
					resList.addLast(newNode);
				}
			}
		}
		//To insert the last carry of the addition
		if(nCarry!=0)
		{
			Node newNode=new Node();
			newNode.sCoEff=nCarry;
			newNode.exp=nExp1+1;
			newNode.sBase=nBase;
			
			resList.addLast(newNode);
			
		}
		while(resList.peek()!=null)
		{
			Node newNode12=new Node();
			newNode12=resList.pop();
			String formatted="";
			sData=Integer.toString(newNode12.sCoEff);
			if(sData.length()<noOfDigit)
			{
				formatted="%0"+noOfDigit+"d";
			    sData=String.format(formatted, newNode12.sCoEff);
			}
			sResult=sData+sResult;
		}
		return sResult;
	}

}
