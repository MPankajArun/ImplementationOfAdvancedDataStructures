/**
 * 
 */
package _TREES_AND_GRAPHS;

/**
 * @author Dany
 *
 */
public class CountBSTNodes {

	static int countTotal=1;

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
		res=res.insertBST(res, 13);
		res=res.insertBST(res, 9);
		res=res.insertBST(res, 28);
		res=res.insertBST(res, 30);
		res=res.insertBST(res, 32);

		//res.inOrderTraversal(res);
		new CountBSTNodes().getCountOfBSTNodes(res, 1);
		System.out.println("Total nodes : "+countTotal);

	}
	
	
	public maxBSTCount()
	
	
	public void getCountOfBSTNodes(TreeNode root, int count)
	{
		if((root==null)||((root.left==null)&&(root.right==null)))
			return;
		if(root.left!=null)
		{
			if(root.left.data>root.data)
			{
				return;
			}else
			{
			countTotal++;
			}
		}
		if(root.right!=null)
		{
			if(root.right.data<root.data)
			{
				return;
			}else
			{
				countTotal++;
			}
		}
		
		 getCountOfBSTNodes(root.left, countTotal);
		 getCountOfBSTNodes(root.right, countTotal); 
	}

}
