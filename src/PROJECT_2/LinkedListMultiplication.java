/**
 * 
 */
package PROJECT_2;

import java.util.LinkedList;

/**
 * @author Dany
 *
 */
public class LinkedListMultiplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long inTime=System.currentTimeMillis();
		String result=new LinkedListMultiplication().multiplicationHandler("87675673456", "5432432321", 10000);
		System.out.println("OUTPUT : "+result);
		long pTime=System.currentTimeMillis();
		System.out.println("Time in Secs "+(pTime-inTime));

	}
	
	public String multiplicationHandler(String sNum1, String sNum2, int nBase)
	{		
		LinkedList<Node> oList1=new LinkedListPolynomialAddition().frameList(sNum1, 10000);
		LinkedList<Node> oList2=new LinkedListPolynomialAddition().frameList(sNum2, 10000);
		String resl=new LinkedListMultiplication().multiplyNumber(oList1, oList2, 10000);
		
		/*int noOfDigit=(int) Math.log10(nBase);
		String formatted="";
		String sData="";
		String strData="";
		int result=0;
		int carry=0;
		int addedData=0;
		for(int i=0;i<resl.length;i++)
		{
			addedData=carry+resl[i];
			result=addedData%nBase;
			carry=addedData/nBase;
			
			if((Integer.toString(result).length())<noOfDigit)
			{
				formatted="%0"+noOfDigit+"d";
			    strData=String.format(formatted, result);
			}else
			{
			strData=Integer.toString(result);
			}
			
			sData=strData+sData;
		}*/
		return resl.replaceFirst("^0+(?!$)", "");
		
	}
	
	public String multiplyNumber(LinkedList<Node> lList1, LinkedList<Node> lList2, int nBase)
	{
		int inFirstLeng=lList1.size();
		int inSecondLen=lList2.size();
		int[] nBuffer=new int[inFirstLeng+inSecondLen];
		int[] nCarryBuffer=new int[inFirstLeng+inSecondLen];
		
		int nBuffCoEff=0;
		int nBuffCarry=0;
		
		int additionCarry=0;
		

		int resCoEff=0;
		int resExp=0;
		
		String sData="";
		int nResNum=0;
		
		if(lList1==null||lList2==null)
			return null;
			for(Node oNode1 : lList1)
			{
			for(Node oNode2 : lList2)	
			{
				resCoEff=oNode1.sCoEff*oNode2.sCoEff;
				resExp=oNode1.exp+oNode2.exp;
				if(resExp==0)
				{
					nBuffCoEff=resCoEff%nBase;
					nBuffCarry=resCoEff/nBase;
					
					nBuffer[resExp]=nBuffCoEff;
					nCarryBuffer[resExp]=nBuffCarry;
				}else
				{
					
					resCoEff=resCoEff+nBuffer[resExp];
					
					nBuffCoEff=resCoEff%nBase;
					nBuffCarry=resCoEff/nBase;
					
					nBuffer[resExp]=nBuffCoEff;
					nCarryBuffer[resExp]+=nBuffCarry;
				}
				
			}
		}
			
			for(int i=0;i<nBuffer.length;i++)
			{
				if(i==0)
				{
					sData=addTrailingZeros(nBuffer[i], nBase)+sData;
				}else
				{
				nResNum=nBuffer[i]+nCarryBuffer[i-1];
				additionCarry=nResNum/nBase;
				nResNum=nResNum%nBase;
				nCarryBuffer[i]+=additionCarry;
				sData=addTrailingZeros(nResNum, nBase)+sData;
				}
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
