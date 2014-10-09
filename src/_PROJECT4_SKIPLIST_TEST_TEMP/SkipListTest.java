/**
 * 
 */
package _PROJECT4_SKIPLIST_TEST_TEMP;

import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author Dany
 *
 */
public class SkipListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		DSL sList=new DSL(9223372036854775807L);
		long max = 9223372036854775807L;
		sList.insert(23L);
		
		//sList.insert(47L);
		System.out.println("find : "+sList.find(23L));
		//sList.insert(37L, 47L);
		//System.out.println("Value  : "+sList.findMin());

	}

}
