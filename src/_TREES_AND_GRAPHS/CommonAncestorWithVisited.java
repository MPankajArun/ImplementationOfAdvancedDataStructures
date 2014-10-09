/**
 * 
 */
package _TREES_AND_GRAPHS;

/**
 * @author Dany
 *
 */
public class CommonAncestorWithVisited {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final TreeNode[] catchNode=new TreeNode[7];

		
		TreeNode first=new TreeNode(8);
		TreeNode res=first.insertBST(first, 7);
		res=res.insertBST(res, 19);
		res=res.insertBST(res, 25);
		res=res.insertBST(res, 18);
		res=res.insertBST(res, 3);
		res=res.insertBST(res, 4);
		res=res.insertBST(res, 2);
		res=res.insertBST(res, 23);
		res=res.insertBST(res, 17);




		//res.inOrderTraversal(res);
		
		res.getNodes(res, catchNode, 23, 0);
		res.getNodes(res, catchNode, 17, 1);

		System.out.println("Catch node : "+catchNode[0].data);
		System.out.println("Catch node : "+catchNode[1].data);


		TreeNode result=new CommonAncestorWithVisited().findCommonAncestor(catchNode[0], catchNode[1]);
		System.out.println("TreeNode common ancestor : "+result.data);
		
	}

	public TreeNode findCommonAncestor(TreeNode tNode1, TreeNode tNode2)
	{
		if(tNode1==null||tNode2==null)
			return null;
		while((tNode1.parent!=null)||(tNode2.parent!=null))
		{
			if(tNode1.parent==tNode2.parent)
			{
				return tNode1.parent;
			}else
			{
				tNode1.visited=true;
				tNode2.visited=true;
				if((tNode1.parent!=null)&&(tNode1.parent.visited==true))
				{
					System.out.println("Test1");
					return tNode1.parent;
				}
				if((tNode2.parent!=null)&&(tNode2.parent.visited==true))
				{
					System.out.println("Test2");

					return tNode2.parent;
				}	
				if(tNode1.parent!=null)
				tNode1=tNode1.parent;
				if(tNode2.parent!=null)
				tNode2=tNode2.parent;
			}
		}
		return null;
	}
}
