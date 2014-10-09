/**
 * 
 */
package _TREES_AND_GRAPHS;

import java.util.HashMap;




/**
 * @author Dany
 *
 */
public class LargestBSTSubTree {

	/**
	 * @param args
	 */
	private static HashMap<Integer, WrapTree> hMap=new HashMap<Integer, WrapTree>();
    public static class TreeNode {
    	 
        int data;
        TreeNode left;
        TreeNode right;
 
        /**
         * Not implementing constructor, getters or setters for simplicity in
         * this case Following OO value, left and right should be private and be
         * accessed only through getters and setters.
         *
         * Some methods it would have:
         *  - Constructors (default and with parameters)
         *  - Getters and setters
         *  - AddNode (it will depend on how is suppose to behave this tree, if it going to be balanced or not for example)
         *  - DeleteNode (by value (if assumption of repeated values is removed or deleting all nodes with that value) or giving a TreeNode)
         *  - Implementation of equals and hashCode.
         *  - GetNode (by value (if assumption of repeated values is removed or returning a list of nodes with that value) or giving a TreeNode)
         */
        
        /**
         * This Method creates a Tree from an array assuming each value
         * i in the array will have its children in positions
         * 2*i + 1 and 2*i +2. The array can contain null values.
         * 
         * @param nodes Array with node values.         
         * @return A complete tree.
         */
        public static TreeNode createTree(Integer[] nodes) {
            return createTree(nodes, 0);
        }
        
        /**
         * This method implements the createTree method recursively and 
         * prevents the first to be called with bad arguments. 
         * @param nodes Array with node values.
         * @param i Position of current node.
         * @return A complete tree for node i.
         * 
         * This method has O(n) time complexity (since it traverse the whole array)
         * and O(n) space complexity because it is implemented recursively. 
         */
        private static TreeNode createTree(Integer[] nodes, int i) {
            if (nodes == null || i >= nodes.length || nodes[i] == null) { //Possible wrong cases.
                return null;
            }
            TreeNode node = new TreeNode();
            node.data = nodes[i];
            node.left = createTree(nodes, 2 * i + 1);
            node.right = createTree(nodes, 2 * i + 2);
 
            return node;
        }
 
        /**
         * Just for testing and debugging purposes
         */
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            this.toString(sb, 0, "");
            return sb.toString();
        }
 
        /**
         * The next two methods help printing the tree nicely on console.         
         */
        private void toString(StringBuilder sb, int level, String branch) {
            for (int i = 0; i < level; i++) {
                sb.append("-");
            }
            sb.append(data);
            sb.append(branch);
            if (left != null) {
                printNode(sb, left, level, "(L)");
            }
 
            if (right != null) {
                printNode(sb, right, level, "(R)");
            }
        }
 
        private void printNode(StringBuilder sb, TreeNode node, int level, String branch) {
            sb.append("\n");
            for (int i = 0; i < level * 3; i++) {
                sb.append(" ");
            }
            sb.append("|\n");
            for (int i = 0; i < level * 3; i++) {
                sb.append(" ");
            }
            sb.append("|");
            node.toString(sb, level + 1, branch);
        }
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
 
    public static TreeNodeHelper[] getLargestBST(TreeNode root) {
        
    	
    	if (root == null) {
        	TreeNodeHelper[] beanArray=new TreeNodeHelper[2];
        	beanArray[0]=new TreeNodeHelper(null, 0, null, null, false);
            return beanArray;
        }
       
    	if (root.left == null && root.right == null) {
        	TreeNodeHelper[] beanArray=new TreeNodeHelper[2];
        	beanArray[0] = new TreeNodeHelper(root, 1, root.data, root.data, true);
        	hMap.put(root.data, new WrapTree(null, null));
            return beanArray;
        } else {
           
        	//Post order traversal
        	TreeNodeHelper[] leftBst = getLargestBST(root.left);
            TreeNodeHelper[] rightBst = getLargestBST(root.right);            
 
            //Put Data to the hash map
            
            hMap.put(root.data, new WrapTree(root.left!=null?root.left.data:null, root.right!=null?root.right.data:null));
            
            //Right tree validation with root
            if (!(rightBst[0].isBST && rightBst[0].minValue > root.data)) {
            	//Hashmap calling code
            	int[] countMinMax=new CountBSTBackTrackHashMap().getCountAndMinMax(hMap, root.data);
            	if(countMinMax[0]>0)
            	{
            		rightBst[0].isBST=true;
            		rightBst[0].maxValue=countMinMax[2];
            	}else
            	{
                rightBst[0].isBST = false;
            	}
            }
 
            
            //Left tree validation with root
            if (!(leftBst[0].isBST && leftBst[0].maxValue < root.data)) {
            	
            	//Hashmap calling code
            	int[] countMinMax=new CountBSTBackTrackHashMap().getCountAndMinMax(hMap, root.data);
            	if(countMinMax[0]>0)
            	{
            		leftBst[0].isBST=true;
            		leftBst[0].minValue=countMinMax[1];
            	}else
            	{
                leftBst[0].isBST = false;
            	}
            }
            
            
            //Right and left BST satisfies the BST condition with root
            if (leftBst[0].isBST && rightBst[0].isBST) { 
            	
            	leftBst[0]=new TreeNodeHelper(root, rightBst[0].nodes + leftBst[0].nodes + 1, rightBst[0].maxValue, leftBst[0].minValue, true);
            	if((leftBst[1]!=null)&&(rightBst[1]!=null)){
            		leftBst[1]=leftBst[1].nodes>rightBst[1].nodes?leftBst[1]:rightBst[1];
            	}else if((leftBst[1]!=null)||(rightBst[1]!=null))
            	{
            		leftBst[1]=leftBst[1]!=null?leftBst[1]:rightBst[1];
            	}
                return leftBst;
                
                
            } else if (root.left == null && rightBst[0].isBST) {
                rightBst[0] = new TreeNodeHelper(root, ++rightBst[0].nodes, rightBst[0].maxValue, root.data, true);
                return rightBst;
            } else if (root.right == null && leftBst[0].isBST) {
                leftBst[0] = new TreeNodeHelper(root, ++leftBst[0].nodes, root.data, leftBst[0].minValue, true);
                return leftBst;
            } else if ( (leftBst[0].isBST) && (!(rightBst[0].isBST)) ){ 
            	
            	if(leftBst[0].nodes > rightBst[0].nodes)
            	{
                    leftBst[0] = new TreeNodeHelper(root, ++leftBst[0].nodes, root.data, leftBst[0].minValue, true);
                    //TreeNodeHelper bstHelper=rightBst[0].nodes>rightBst[1].nodes?rightBst[0]:rightBst[1];
                    leftBst[1]=leftBst[1].nodes>rightBst[1].nodes?leftBst[1]:rightBst[1];
                    return leftBst;

            	}else if (leftBst[0].nodes < rightBst[0].nodes)
            	{
            		leftBst[0] = new TreeNodeHelper(root, ++leftBst[0].nodes, root.data, leftBst[0].minValue, true);
                    TreeNodeHelper bstHelper=rightBst[0].nodes>rightBst[1].nodes?rightBst[0]:rightBst[1];
                    leftBst[1]=leftBst[1].nodes>bstHelper.nodes?leftBst[1]:bstHelper;
            		leftBst[1] = rightBst[0];

                    return leftBst;
            		
            	}else //if (leftBst[0].nodes == rightBst[0].nodes)
            	{
            		leftBst[0] = new TreeNodeHelper(root, ++leftBst[0].nodes, root.data, leftBst[0].minValue, true);
            		leftBst[1]=leftBst[1].nodes>rightBst[1].nodes?leftBst[1]:rightBst[1];
                    return leftBst;


            	}
            	
            } else if ( (!(leftBst[0].isBST)) && ((rightBst[0].isBST)) ){ 
            	
            	if(leftBst[0].nodes > rightBst[0].nodes)
            	{
            		
            		rightBst[0]=new TreeNodeHelper(root, ++rightBst[0].nodes, rightBst[0].maxValue, root.data, true);
                    TreeNodeHelper bstHelper=leftBst[0].nodes>leftBst[1].nodes?leftBst[0]:leftBst[1];
            		rightBst[1]=rightBst[1].nodes>bstHelper.nodes?rightBst[1]:bstHelper;
            		return rightBst;
            		
            	}else if (leftBst[0].nodes < rightBst[0].nodes)
            	{
            		rightBst[0]=new TreeNodeHelper(root, ++rightBst[0].nodes, rightBst[0].maxValue, root.data, true);
            		rightBst[1]=rightBst[1].nodes>leftBst[1].nodes?rightBst[1]:leftBst[1];
            		return rightBst;

            		
            	}else //if (leftBst[0].nodes == rightBst[0].nodes)
            	{
            		rightBst[0]=new TreeNodeHelper(root, ++rightBst[0].nodes, rightBst[0].maxValue, root.data, true);
            		rightBst[1]=rightBst[1].nodes>leftBst[1].nodes?rightBst[1]:leftBst[1];
            		return rightBst;
            	}
            	
            } else {
            	
            	//Start the count from 1
            	leftBst[0]= new TreeNodeHelper(root, 1, root.data, root.data, true);
                TreeNodeHelper bstHelper=rightBst[0].nodes>rightBst[1].nodes?rightBst[0]:rightBst[1];
            	leftBst[1] = leftBst[1].nodes > bstHelper.nodes ? leftBst[1] : bstHelper;
            	
            	return leftBst;
            }
        }
    }
	
    public static void main(String[] args) {
/*        Integer[] treeA = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        TreeNode tree = TreeNode.createTree(treeA);
        System.out.println("\n-TREE--\n" + tree);
        TreeNodeHelper result = getLargestBST(tree);
        System.out.println("1 - Largest BST: \n" + result.node);*/
 
 
        Integer[] treeA = new Integer[]{8, 3, 4, 2, 9, 7, 1, null, null, null, 8, 9};
        TreeNode tree = TreeNode.createTree(treeA);
        System.out.println("\n-TREE--\n" + tree);
        TreeNodeHelper[] result = getLargestBST(tree);
        System.out.println("2 - Largest BST: \n" + result[0].node);
        System.out.println("2 - --------------Largest BST: \n" +(result[1]!=null?result[1].node:0));

        
        treeA = new Integer[]{55, null, 75,26,null,95,23,null,105,20,null,210,115,98,null,175,128,null,null,300,null};
        tree = TreeNode.createTree(treeA);
        System.out.println("\n-TREE--\n" + tree);
        result = getLargestBST(tree);
        System.out.println("3 - Largest BST: \n" + result[0].node);
 
        /*treeA = new Integer[]{null};
        tree = TreeNode.createTree(treeA);
        System.out.println("\n-TREE--\n" + tree);
        result = getLargestBST(tree);
        System.out.println("3 - Largest BST: \n" + result.node);
 
        treeA = null;
        tree = TreeNode.createTree(treeA);
        System.out.println("\n-TREE--\n" + tree);
        result = getLargestBST(tree);
        System.out.println("3.1 - Largest BST: \n" + result.node);
 
        treeA = new Integer[]{1};
        tree = TreeNode.createTree(treeA);
        System.out.println("\n-TREE--\n" + tree);
        result = getLargestBST(tree);
        System.out.println("4 - Largest BST: \n" + result.node);
 
        treeA = new Integer[]{9, 4, 14, 2, 6, 12, 16, 1, 3, 5, 7, 10, 15, 22, 15, -1, null, null, null, null, null, null, 8};
        tree = TreeNode.createTree(treeA);
        System.out.println("\n-TREE--\n" + tree);
        result = getLargestBST(tree);
        System.out.println("5 - Largest BST: \n" + result.node);
 
        treeA = new Integer[]{14, 12, 16, 10, 15, 22, 15};
        tree = TreeNode.createTree(treeA);
        System.out.println("\n-TREE--\n" + tree);
        result = getLargestBST(tree);
        System.out.println("6 - Largest BST: \n" + result.node);
 
 
        treeA = new Integer[]{35,42,73,17,27,43,41,16,78,6,2,1,13,5};
        tree = TreeNode.createTree(treeA);
        System.out.println("\n-TREE --\n" + tree);
        result = getLargestBST(tree);
        System.out.println("7 - Largest BST: \n" + result.node);*/
 
 
 
    }
    
}
