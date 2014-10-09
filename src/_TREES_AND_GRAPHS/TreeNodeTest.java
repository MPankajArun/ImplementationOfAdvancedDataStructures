/**
 * 
 */
package _TREES_AND_GRAPHS;

/**
 * @author Dany
 *
 */
public class TreeNodeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final TreeNode[] catchNode=new TreeNode[5];

		TreeNode first=new TreeNode(8);
		TreeNode res=first.insertBST(first, 7);
		res=res.insertBST(res, 19);
		res=res.insertBST(res, 25);
		res=res.insertBST(res, 18);
		res=res.insertBST(res, 3);
		res=res.insertBST(res, 4);
		//res.inOrderTraversal(res,res,"left");
		
		new BinTreeIterator();
		boolean result=BinTreeIterator.searchNumBinTree(res, 10);
		System.out.println("resu;t "+result);
		//System.out.println("Root data : "+res.data);
		//System.out.println("Root left Data : "+res.left.data);
		 
		 
		
		/**
		 * Well framed binary tree which intern have a BST
		 */
		
		/*TreeNode first=new TreeNode(35);
		TreeNode res=first.insertBT(first, 42, 35,"left");
		res=res.insertBT(first, 73, 35,"right");
		res=res.insertBT(first, 17, 42,"left");
		res=res.insertBT(first, 41, 17,"left");
		res=res.insertBT(first, 16, 17,"right");
		res=res.insertBT(first, 2, 41,"left");
		res=res.insertBT(first, 1, 41,"right");
		res=res.insertBT(first, 27, 73,"left");
		res=res.insertBT(first, 43, 73,"right");
		res=res.insertBT(first, 78, 43,"left");
		res=res.insertBT(first, 6, 43,"right");
		res=res.insertBT(first, 13, 6,"left");
		res=res.insertBT(first, 5, 6,"right");*/
		//TreeNode res=first.insertBT(first, 7, 8,"left");
		/*res=res.insertBT(first, 8, 42,"right");
		res=res.insertBT(first, 7, 8,"left");
		res=res.insertBT(first, 3, 7,"left");
		res=res.insertBT(first, 4, 3,"right");
		res=res.insertBT(first, 19, 8,"right");
		res=res.insertBT(first, 18, 19,"left");
		res=res.insertBT(first, 25, 19,"right");
*/		
		//res.preOrderTraversal(res);
		 
		
		
	}

}
