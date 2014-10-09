/**
 * 
 */
package _TREES_AND_GRAPHS;

/**
 * @author Dany
 *
 */
public class CheckBTAsBST {

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
		
		boolean result=new CheckBTAsBST().CheckBST(res);
		if(result)
			System.out.println("Tree is BST");
		else
			System.out.println("Tree is not BST");

	}
	
	public boolean CheckBST(TreeNode root)
	{
		
		if((root==null)||((root.left==null)&&(root.right==null)))
			return true;
		if(root.left!=null)
		{
		if(root.left.data>root.data)
				return false;
		}
		if(root.right!=null)
		{
			if(root.right.data<root.data)
			return false;
		}
		
				
		return CheckBST(root.left) & CheckBST(root.right); 
					
	}

}
