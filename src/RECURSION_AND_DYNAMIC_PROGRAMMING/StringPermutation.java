/**
 * 
 */
package RECURSION_AND_DYNAMIC_PROGRAMMING;

import STACKS_QUEUES.Stack;

/**
 * @author Dinesh
 *
 */
public class StringPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Stack permuteString(String sValue)
	{
		Stack firstStack=new Stack(24);
		Stack secondStack=new Stack(24);
		firstStack.push("");
		Stack res=permStrings(sData, sourceStack, destStack);
		
	}
	
	
	public Stack permStrings(String sData, Stack sourceStack, Stack destStack)
	{
		for(int i=0;i<sData.length();i++)
		{
			char chr=sData.charAt(i);
			while((sourceStack.peek()!=null)&&(sourceStack.top!=-1))
			{
				String value=sourceStack.pop();
				for(int j=0;j<=value.length();j++)
				{
					String sTemp=strPerm(value, chr, j);
					destStack.push(sTemp);
					
				}
				
			}
			sData=sData.substring(1, sData.length());
			//permStrings(sData, destStack, sourceStack);
			}
		return destStack;
	}
	public static String strPerm(String strVal, char ch, int pos)
	{
		String sBegin=strVal.substring(0,  pos);
		String sEnd=strVal.substring(pos);
		return sBegin+ch+sEnd;
	}
	

}
