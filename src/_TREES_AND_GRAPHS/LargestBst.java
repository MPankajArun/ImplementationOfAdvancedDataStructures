/**
 * 
 */
package _TREES_AND_GRAPHS;

/**
 * @author Dany
 *
 */
public class LargestBst{
	
	
	public static void main(String args[])
	{
		
		
		TreeNode first=new TreeNode(55);
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
		res=res.insertBT(first, 5, 6,"right");
		//TreeNode res=first.insertBT(first, 7, 8,"left");
		/*res=res.insertBT(first, 8, 42,"right");
		res=res.insertBT(first, 7, 8,"left");
		res=res.insertBT(first, 3, 7,"left");
		res=res.insertBT(first, 4, 3,"right");
		res=res.insertBT(first, 19, 8,"right");
		res=res.insertBT(first, 18, 19,"left");
		res=res.insertBT(first, 25, 19,"right");*/
		
		
		
		TreeNodeHelper result=getLargestBST(res);
		TreeNode res1=result.node;
		//res1.inOrderTraversal(res1);
        System.out.println("7 - Largest BST: \n" + result.node.data);

		
	}

    
    public static class TreeNodeHelper {
        TreeNode node;
        int nodes;
        Integer maxValue;
        Integer minValue;
        boolean isBST;
 
        public TreeNodeHelper() {}
 
        public TreeNodeHelper(TreeNode node, int nodes, Integer maxValue, Integer minValue, boolean isBST) {
            this.node = node;
            this.nodes = nodes;
            this.maxValue = maxValue;
            this.minValue = minValue;
            this.isBST = isBST;
        }      
    }
 
    public static TreeNodeHelper getLargestBST(TreeNode tree) {
        if (tree == null) {
            return new TreeNodeHelper(null, 0, null, null, false);
        }
        if (tree.left == null && tree.right == null) {
            TreeNodeHelper helper = new TreeNodeHelper(tree, 1, tree.data, tree.data, true);
            return helper;
        } else {
            TreeNodeHelper leftBst = getLargestBST(tree.left);
            TreeNodeHelper rightBst = getLargestBST(tree.right);            
 
            if (!(rightBst.isBST && rightBst.minValue > tree.data)) {
                rightBst.isBST = false;
            }
 
            if (!(leftBst.isBST && leftBst.maxValue < tree.data)) {
                leftBst.isBST = false;
            }
 
            if (leftBst.isBST && rightBst.isBST) { 
                return new TreeNodeHelper(tree, rightBst.nodes + leftBst.nodes + 1, rightBst.maxValue, leftBst.minValue, true);
            } else if (tree.left == null && rightBst.isBST) {
                return new TreeNodeHelper(tree, ++rightBst.nodes, rightBst.maxValue, tree.data, true);
            } else if (tree.right == null && leftBst.isBST) {
                return new TreeNodeHelper(tree, ++leftBst.nodes, tree.data, leftBst.minValue, true);
            } else { 
                return leftBst.nodes >= rightBst.nodes ? leftBst : rightBst;
            }
        }
    }
    
}