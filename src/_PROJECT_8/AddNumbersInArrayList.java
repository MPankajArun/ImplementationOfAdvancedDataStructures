/**
 * 
 */
package _PROJECT_8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;


/**
 * @author Dany
 *
 */
public class AddNumbersInArrayList {

	/**
	 * @param args
	 */
	public static Set<Integer> resultSet=new HashSet<Integer>();
	public static ArrayList<Integer>[] inList=(ArrayList<Integer>[])new ArrayList[5];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*ArrayList<Integer> list1=new ArrayList<Integer>();
		list1.add(2);
		list1.add(4);
		list1.add(5);
		ArrayList<Integer> list2=new ArrayList<Integer>();
		list2.add(1);
		list2.add(2);
		list2.add(7);
		ArrayList<Integer> list3=new ArrayList<Integer>();
		list3.add(3);
		list3.add(6);*/
		
		ArrayList<Integer> list1=new ArrayList<Integer>();
		list1.add(2);
		list1.add(4);
		list1.add(5);
		ArrayList<Integer> list2=new ArrayList<Integer>();
		list2.add(4);
		list2.add(5);
		list2.add(8);
		ArrayList<Integer> list3=new ArrayList<Integer>();
		/*list3.add(1);
		list3.add(2);
		list3.add(3);*/
		ArrayList<Integer> list4=new ArrayList<Integer>();
		list4.add(9);
		list4.add(10);
		list4.add(11);

		
		inList[0]=list4;
		inList[1]=list3;
		inList[2]=list2;

		inList[3]=list1;


		new AddNumbersInArrayList().addNumbersFromEachList(0, 3);
		
		System.out.println("size : "+resultSet.size());
		for(int i : resultSet)
		{
			System.out.print(" "+i);
		}
	}
	
	public void addNumbersFromEachList(int value, int pos)
	{
		if(pos<0)
		{
			resultSet.add(value);
			return;
		}
		ArrayList<Integer> intermediateList=inList[pos--];
		while(intermediateList.isEmpty())
			intermediateList=inList[pos--];
				for(int i : intermediateList)
				{
					int res=value+i;
					addNumbersFromEachList(res, pos);
				}
	}
}
