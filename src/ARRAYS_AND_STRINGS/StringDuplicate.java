/**
 * 
 */
package ARRAYS_AND_STRINGS;

/**
 * @author Dany
 *
 */
public class StringDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean res=new StringDuplicate().findDuplicate("danh");

		System.out.println("result: "+res);
		
	}
	
	public boolean findDuplicate(String inString)
	{
		boolean dupFlag=true;
		if(inString.length()>256)
			return false;
		boolean[] bArray = new boolean[256];
		for(int i=0;i<inString.length();i++)
		{
			int c=inString.charAt(i);
			if(bArray[c])
				return false;
			bArray[c]=true;
			
		}
		
		return dupFlag;
	}

}
