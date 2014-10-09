/**
 * 
 */
package _TREES_AND_GRAPHS;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Dinesh
 *
 */
public class OutputInLevelOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<TreeList> adj=new ArrayList<TreeList>();
		TreeList newNode01=new TreeList(2332);
		TreeList newNode02=new TreeList(2453);
		TreeList newNode03=new TreeList(2656);
		adj.add(newNode01);
		adj.add(newNode02);
		adj.add(newNode03);

		TreeList newNode=new TreeList(15);
		newNode.adjacent=adj;
		
		
		ArrayList<TreeList> adj1=new ArrayList<TreeList>();
		TreeList newNode1=new TreeList(18);
		
		TreeList newNode11=new TreeList(3434);
		TreeList newNode12=new TreeList(3749);
		TreeList newNode13=new TreeList(3088);
		
		adj1.add(newNode11);
		adj1.add(newNode12);
		adj1.add(newNode13);
		newNode1.adjacent=adj1;
		
		ArrayList<TreeList> adj2=new ArrayList<TreeList>();
		TreeList newNode2=new TreeList(21);
		
		TreeList newNode21=new TreeList(4345);
		TreeList newNode22=new TreeList(4676);
		TreeList newNode23=new TreeList(4767);
		adj2.add(newNode21);
		adj2.add(newNode22);
		adj2.add(newNode23);
		
		newNode2.adjacent=adj2;



		
		
		ArrayList<TreeList> adj3=new ArrayList<TreeList>();
		TreeList newNode3=new TreeList(20);
		newNode3.data=20;
		adj3.add(newNode);
		adj3.add(newNode1);
		adj3.add(newNode2);
		newNode3.adjacent=adj3;
		
		new OutputInLevelOrder().doPrintInLevelOrder(newNode3);
	}
	
	public void doPrintInLevelOrder(TreeList root)
	{
		if(root==null)
			return;
		TreeList dataVal;
		//System.out.println("Node value root : "+root.data);
		root.visited=true;
		LinkedList<TreeList> lList=new LinkedList<TreeList>();
		lList.addFirst(root);
		while(!lList.isEmpty())
		{
			 dataVal=lList.removeLast();
			 System.out.println("Node Value : "+dataVal.data);

			 for(TreeList node : dataVal.adjacent)
			 {
				 if(node.visited!=true)
				 {
					 node.visited=true;
					 lList.addFirst(node);
				 }
			 }

		}
		
	}

}
