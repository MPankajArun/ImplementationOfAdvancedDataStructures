/**
 * 
 */
package PROJECT_2;

import java.util.HashMap;


/**
 * @author Dany
 *
 */
public class LinkedListExponantial {

	/**
	 * @param args
	 */
	static HashMap<Integer, String> hDynamicMap=new HashMap<Integer, String>();
	static String m="4";
	static int n=1000000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long inTime=System.currentTimeMillis();
		hDynamicMap.put(1, m);
		String res=new LinkedListExponantial().mPowerN(m, n);
		System.out.println("m power n "+res);
		long pTime=System.currentTimeMillis();
		System.out.println("Time in  Milli Secs "+(pTime-inTime));
		
	}
	public String mPowerN(String m, int n)
	{
		String mapEntry;
		
		if(     ( mapEntry = hDynamicMap.get(n)   )!=null )
		{
			return mapEntry;
		}
		if(n==0)
			return m;
		
		if((n&1)==0)
		{
			hDynamicMap.put(n, new LinkedListMultiplication().multiplicationHandler(mPowerN(m, n/2), mPowerN(m, n/2), 10000));
		}else
		{
			hDynamicMap.put(n, new LinkedListMultiplication().multiplicationHandler(m, new LinkedListMultiplication().multiplicationHandler(mPowerN(m, n/2), mPowerN(m, n/2), 10000), 10000));

		}
		return hDynamicMap.get(n);

	}
	

}
