/**
 * 
 */
package _TREES_AND_GRAPHS;

import java.util.HashMap;

/**
 * @author Dany
 *
 */

public class CountBSTBackTrackHashMap {


	private static int nBSTCount=0;
	private static int nMaximum=Integer.MIN_VALUE;
	private static int nMinimum=Integer.MAX_VALUE;
	
	public int[] getCountAndMinMax(HashMap<Integer, WrapTree> hMap, int nodeValue)
	{
		int[] countMinMax=new int[3];
		new CountBSTBackTrackHashMap().countBstNodesHashMap(hMap, nodeValue, Integer.MIN_VALUE, Integer.MAX_VALUE);
		countMinMax[0]=nBSTCount;
		countMinMax[1]=nMinimum;
		countMinMax[2]=nMaximum;
		nBSTCount=0;
		nMaximum=Integer.MIN_VALUE;
		nMinimum=Integer.MAX_VALUE;
		return countMinMax;
		
	}
	
	public boolean countBstNodesHashMap(HashMap<Integer, WrapTree> hMap, Integer key, int min, int max)
	{
		if(key==null)
		{
			return true;
		}
		if(key<min||key>max)
		{
			return false;
		}else
		{
			if(key>nMaximum)
				nMaximum=key;
			if(key<nMinimum)
				nMinimum=key;
			nBSTCount++;
		}
		 countBstNodesHashMap(hMap, hMap.get(key).left, min, key);
		 countBstNodesHashMap(hMap, hMap.get(key).right, key, max);
		return true;
	}

	
	public static void main(String[] args) {

		HashMap<Integer, WrapTree> hMap=new HashMap<Integer, WrapTree>();
		hMap.put(128, new WrapTree(null, null));
		hMap.put(175, new WrapTree(128, null));
		hMap.put(98, new WrapTree(null, null));
		hMap.put(115, new WrapTree(98, 175));
		hMap.put(210, new WrapTree(115, 300));
		hMap.put(300, new WrapTree(null, null));
		hMap.put(105, new WrapTree(20, 210));
		hMap.put(20, new WrapTree(null, null));
		hMap.put(95, new WrapTree(23, 105));
		hMap.put(23, new WrapTree(null, null));
		hMap.put(75, new WrapTree(26, 95));
		hMap.put(26, new WrapTree(null, null));
		hMap.put(55, new WrapTree(null, 75));

		//int[] output1=new CountBSTBackTrackHashMap().getCountAndMinMax(hMap, 55);
		//int[] output2=new CountBSTBackTrackHashMap().getCountAndMinMax(hMap, 55);
		int[] output=new CountBSTBackTrackHashMap().getCountAndMinMax(hMap, 55);

		//System.out.println("Boolean result : "+result);
		System.out.println("Total BST nodes : "+output[0]);
		System.out.println("Maximum : "+output[2]);
		System.out.println("Minimum : "+output[1]);
	}
	
}
