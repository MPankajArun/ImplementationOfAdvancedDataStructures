/**
 * 
 */
package PROJECT_2;

import java.util.HashMap;

/**
 * @author Dany
 *
 */
public class ExponentialTest {
	


	/**
	 * @param args
	 */
	static HashMap<Integer, Integer> hDynamicMap=new HashMap<Integer, Integer>();
	static int m=2;
	static int n=100;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hDynamicMap.put(1, m);
		int res=new ExponentialTest().mPowerN(m, n);
		
		System.out.println("m power n "+res);
		
	}
	public int mPowerN(int m, int n)
	{
		Integer mapEntry;
		
		if(     ( mapEntry = hDynamicMap.get(n)   )!=null )
		{
			return mapEntry;
		}
		
		if((n&1)==0)
		{
			hDynamicMap.put(n, mPowerN(m, n/2) * mPowerN(m, n/2));
		}else
		{
			hDynamicMap.put(n, m * mPowerN(m, n/2) * mPowerN(m, n/2));

		}
		System.out.println("m value  "+m+" n  value "+n);
		return hDynamicMap.get(n);

	}
	


	
}
