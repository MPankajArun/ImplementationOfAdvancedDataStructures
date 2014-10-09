/**
 * 
 */
package _TREES_AND_GRAPHS;

import java.util.ArrayList;


/**
 * @author Dany
 *
 */
public class DepthFirstSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ArrayList<TreeList> adj=new ArrayList<TreeList>();
		TreeList newNode=new TreeList(15);
		newNode.data=15;
		//newNode.adjacent=adj;
		//ArrayList<TreeList> adj1=new ArrayList<TreeList>();
		TreeList newNode1=new TreeList(18);
		newNode1.data=18;
		//newNode1.adjacent=adj1;
		//ArrayList<TreeList> adj2=new ArrayList<TreeList>();
		TreeList newNode2=new TreeList(21);
		newNode2.data=21;
		//newNode2.adjacent=adj2;
		
		ArrayList<TreeList> adj3=new ArrayList<TreeList>();
		TreeList newNode3=new TreeList(20);
		newNode3.data=20;
		adj3.add(newNode);
		adj3.add(newNode1);
		adj3.add(newNode2);
		newNode3.adjacent=adj3;
		
		for(TreeList n :  newNode3.adjacent)
		{
			System.out.println("vale : "+n.data);
		}
		
		
		new DepthFirstSearch().doDepthFirstSearch(newNode3, 18);
		
		
	}
	
	public void doDepthFirstSearch(TreeList root, int searchData)
	{
		if(root==null)
			return ;
		if(root.data==searchData)
		{
			root.visited=true;
			System.out.println("Data Found : "+root.data);	
			return;
		}else
		{
		root.visited=true;
		//if(root.adjacent!=null)
		//{
		for(TreeList node : root.adjacent)
		{
			if(node.visited!=true)
			{
				  doDepthFirstSearch(node, searchData);
			}		
		}
		//}
		}
	}

}
