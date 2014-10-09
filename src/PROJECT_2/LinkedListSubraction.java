/**
 * 
 */
package PROJECT_2;

import java.util.LinkedList;

/**
 * @author Dany
 *
 */
public class LinkedListSubraction {

	/**
	 * @param args
	 */
	static String _sNegative_Error="Negative number not supported";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String result=new LinkedListSubraction().subractNumber("000000697159826319905976801547198840968385286824909912336392", "9123476121289", 10000);
		System.out.println("Result : "+result);
	}
	public String subractNumber(String sNum1, String sNum2, int nBase)
	{
		long inTime=System.currentTimeMillis();
		int sLen1=sNum1.length();
		int sLen2=sNum2.length();
		if(sLen1<sLen2)
		{
			return _sNegative_Error;
		}
		else if(sLen1==sLen2)
		{
			if((sNum1.compareTo(sNum2))<0)
			{
				return _sNegative_Error;
			}
		}
		
		LinkedList<Node> res=new LinkedListPolynomialAddition().frameList(sNum1, nBase);
		LinkedList<Node> res1=new LinkedListPolynomialAddition().frameList(sNum2, nBase);

		String sRes=new LinkedListSubraction().subractHandler(res, res1, nBase);
		System.out.println("OUTPUT : "+sRes);
		long pTime=System.currentTimeMillis();
		System.out.println("Time in Secs "+(pTime-inTime));
		return sRes;
	}
	
	public String subractHandler(LinkedList<Node> oList1, LinkedList<Node> oList2, int nBase)
	{
		LinkedList<Node> oResList=new LinkedList<Node>();

		int nNum1=0;
		int nNum2=0;
		int nCarry=0;
		int resNum=0;
		int nExp=0;
		String resStr="";
		String sData="";
		
		if(oList1==null||oList2==null)
			return null;
		
		while((oList1.peek()!=null) || (oList2.peek()!=null))
		{

			if((oList1.peek()!=null) && (oList2.peek()!=null))
			{
			Node oNode1=oList1.pop();
			Node oNode2=oList2.pop();
			Node oResNode=new Node();
			nNum1=oNode1.sCoEff;
			nNum2=oNode2.sCoEff;
			nExp=oNode1.exp;

			
			nNum1=nNum1+nCarry;
			nCarry=0;
			if(nNum1<nNum2)
			{
				nNum1=nNum1+nBase;
				nCarry=-1;
				
			}
			resNum=nNum1-nNum2;
			resStr=addTrailingZeros(resNum, nBase);
			System.out.println("result test :"+resStr);
			oResNode.sCoEff=Integer.parseInt(resStr);
			oResNode.exp=nExp;
			
			oResList.addLast(oResNode);

		}else
		{

			LinkedList<Node> contList;
			Node newNode=new Node();
			contList=oList1;

			while(contList.peek()!=null)
			{
				newNode=contList.pop();
				resNum=newNode.sCoEff+nCarry;
				newNode.sCoEff=resNum;
				newNode.exp=newNode.exp;
				nCarry=0;

				oResList.addLast(newNode);
			}
		
			
		}
		}
		/*if(nCarry==-1)
		{
			Node negNode=new Node();
			negNode.sCoEff=-1;
			negNode.exp=nExp;	
			oResList.addLast(negNode);

		}*/
		while(oResList.peek()!=null)
		{
			Node res=oResList.pop();
			String resData=addTrailingZeros(res.sCoEff, nBase);
			sData=resData+sData;
		}
		return sData;
		
	}
	
	public String addTrailingZeros(int nNum, int nBase)
	{
			int noOfDigit=(int) Math.log10(nBase);
			String formatted="%0"+noOfDigit+"d";
		    String resData=String.format(formatted, nNum);
		    
		    return resData;
		
	}
	
}
