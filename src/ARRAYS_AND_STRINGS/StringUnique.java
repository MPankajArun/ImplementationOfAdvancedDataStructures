/**
 * 
 */
package ARRAYS_AND_STRINGS;

import java.util.Hashtable;

/**
 * @author Dany
 *
 */
public class StringUnique {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str="DineshApvo";
		boolean res=new StringUnique().strUnique(str);
		System.out.println("Result : "+res);
		System.out.println("2 power 100 : "+Math.pow(2, 100));
	}
	
	public boolean stringUnique(String str)
	{
		Hashtable<Character, Boolean> hTable=new Hashtable<Character, Boolean>();
		for(int i=0;i<str.length();i++)
		{
			char cVal=str.charAt(i);
			if(hTable.get(cVal))
			{
				return false;
			}
			hTable.put(cVal,true);
		}
		return true;
	}
	
	public boolean strUnique(String str)
	{
		int check=0;
		int arrVal;
		for(int i=0;i<str.length();i++)
		{
			arrVal=str.charAt(i)-'a';
			if((check&(1<<arrVal))!=0)
			{
				return false;
			}
			check|=(1<<arrVal);
		}
		return true;
	}

}
