/**
 * 
 */
package ARRAYS_AND_STRINGS;

/**
 * @author Dany
 *
 */
public class StringRotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String res=new StringRotation().isRotation("waterbottle", "erbottlewat");
	System.out.println("Result: "+res);
	}
	
	public String isRotation(String s1, String s2)
	{
		String retString="";
		String sTemp=s1 + s1;
		retString=sTemp.substring(3, 3+s1.length());
		return retString;
	}
	

}
