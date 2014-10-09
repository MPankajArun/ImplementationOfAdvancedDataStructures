/**
 * 
 */
package _TREES_AND_GRAPHS;

/**
 * @author Dany
 *
 */
public class CheckBTasBSTMinMax {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode first=new TreeNode(8);
		TreeNode res=first.insertBST(first, 7);
		res=res.insertBST(res, 19);
		res=res.insertBST(res, 25);
		res=res.insertBST(res, 18);
		res=res.insertBST(res, 3);
		res=res.insertBST(res, 4);
		
		
	/*	TreeNode first=new TreeNode(55);
		TreeNode res=first.insertBT(first, 42, 55,"left");
		res=res.insertBT(first, 73, 55,"right");
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
		
		boolean result=new CheckBTasBSTMinMax().checkBTasBST(res, -1, 9999);
		if(result)
			System.out.println("Tree is BST");
		else
			System.out.println("Tree is not BST");
	}
	
	public boolean checkBTasBST(TreeNode root, int min, int max)
	{
		if(root==null)
			return true;
		if(root.data<min||root.data>max)
			return false;
		if((!checkBTasBST(root.left, min, root.data)))
			return false;
		if((!checkBTasBST(root.right, root.data, max)))
			return false;

		return true;
	}

}
