/**
 * 
 */
package ARRAYS_AND_STRINGS;

/**
 * @author Dany
 *
 */
public class TreeNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root=new TreeNode(12);
		root.left=new TreeNode(7);
		root.right=new TreeNode(15);
		//TreeNode res=TreeNode.insertNode(root, 15);
		TreeNode.treeTraversal(root);
		
	}
	 TreeNode left;
	 TreeNode right;
	 int data;
	 public TreeNode(int data) {
		// TODO Auto-generated constructor stub
		 this.data=data;
	 }
	 
	 public static TreeNode treeTraversal(TreeNode root)
	 {
		if(root==null)
		{
			System.out.println("The tree is empty/reached end");
		return root;
		}
		System.out.println(root.data);
		 treeTraversal(root.left);
		System.out.println(root.data);
		return treeTraversal(root.right);
	 }
	 public static TreeNode insertNode(TreeNode root, int data)
	 {
		 TreeNode res=null;
		  if(data>root.data)
		  {
			  root=root.right;
		  }
		 return res;
	 }

}
