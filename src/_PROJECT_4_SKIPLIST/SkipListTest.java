/**
 * 
 */
package _PROJECT_4_SKIPLIST;

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

		
		/*DSL sList=new DSL(22L,  47L);
		sList.insert(12L, 96L);*/
		
		SkipList<Long, Long> sl=new SkipList<Long, Long>();
		sl.add(22L, 96L);
		sl.add(67L, 96L);
		sl.add(34L, 46787L);
		sl.add(5454500534535465465L, 2842374237428L);
		sl.add(254L, 455757L);
		sl.add(1657L, 96L);
		sl.add(5456L, 284L);
		sl.add(242L, 46757L);
		sl.add(6754L, 96L);


		//sl.add(04541657565L, 96L);
		//System.out.println("Value  : "+sl.get(5454500565465L));
		System.out.println("Value I : "+sl.findMin());
		System.out.println("Max Value : "+sl.findMax());
		System.out.println("size : "+sl.size());

		System.out.println("remove Count : "+sl.removeValue(96L));
		System.out.println("size : "+sl.size());
		System.out.println("find value : "+sl.get(96L));



	}

}
