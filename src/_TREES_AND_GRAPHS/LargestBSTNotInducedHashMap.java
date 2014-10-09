/**
 * 
 */
package _TREES_AND_GRAPHS;

import java.util.HashMap;


/**
 * @author Dany
 *
 */
public class LargestBSTNotInducedHashMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode res=new TreeNode(35);
		res.insertBT(res, 33, 35,"left");
		res.insertBT(res, 73, 35,"right");
		res.insertBT(res, 17, 33,"left");
		res.insertBT(res, 41, 17,"left");
		res.insertBT(res, 16, 17,"right");
		res.insertBT(res, 2, 41,"left");
		res.insertBT(res, 1, 41,"right");
		res.insertBT(res, 27, 73,"left");
		res.insertBT(res, 43, 73,"right");
		res.insertBT(res, 78, 43,"left");
		res.insertBT(res, 6, 43,"right");
		res.insertBT(res, 13, 6,"left");
		res.insertBT(res, 5, 6,"right");
		
		res.insertBT(res, 8, 33,"right");
		res.insertBT(res, 7, 8,"left");
		res.insertBT(res, 3, 7,"left");
		res.insertBT(res, 4, 3,"right");
		res.insertBT(res, 19, 8,"right");
		res.insertBT(res, 18, 19,"left");
		res.insertBT(res, 25, 19,"right");
		
		
/*		TreeNode res=new TreeNode(55);
		res.insertBT(res, 75, 55,"right");
		res.insertBT(res, 27, 75,"left");
		res.insertBT(res, 89, 75,"right");
		res.insertBT(res, 95, 89,"right");
		res.insertBT(res, 26, 89,"left");
		res.insertBT(res, 105, 95,"right");
		res.insertBT(res, 23, 95,"left");
		res.insertBT(res, 110, 105,"right");
		res.insertBT(res, 20, 105,"left");*/

		
		
		
		TreeNodeHelper[] result=getLargestBST(res);
		System.out.println("Root Node : "+result[0].node.data+ " Minimum "+result[0].minValue + " Maximum  "+result[0].maxValue);
		if(result[1]!=null)
		System.out.println("Root Node : "+result[1].node.data+ " Minimum "+result[1].minValue + " Maximum  "+result[1].maxValue);
		
		System.out.println("FINAL MAX SUBTREE");
		result[0]=result[1]==null?result[0]:(result[0].nodes>result[1].nodes?result[0]:result[1]);
		System.out.println("Root Node : "+result[0].node.data+ " Minimum "+result[0].minValue + " Maximum  "+result[0].maxValue);
		System.out.println("INORDER TRAVERSAL OF BST");
		new MaxBSTinBT().printBST(result[0].node, Integer.MIN_VALUE, Integer.MAX_VALUE);


		
		
	}
	
	private static HashMap<Integer, WrapTree> hMap=new HashMap<Integer, WrapTree>();

	
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
	 
	            //Add Data to the hash map
	            hMap.put(root.data, new WrapTree(root.left!=null?root.left.data:null, root.right!=null?root.right.data:null));
	            
	            //Right tree validation with root
	            if (!(rightBst[0].isBST && rightBst[0].minValue > root.data)) {
	            	if(rightBst[0].node!=null)
	            	{
	            		hMap.put(root.data, new WrapTree(null, root.right!=null?root.right.data:null));
	            	int[] countMinMax=new MaxBSTinBT().getCountAndMinMax(hMap, root.data);
					if(countMinMax[0]>1)
					{
						rightBst[0].isBST=true;
						rightBst[0].nodes=countMinMax[0];
						rightBst[0].maxValue=countMinMax[2];
					}else
						rightBst[0].isBST=false;
            		hMap.put(root.data, new WrapTree(root.left!=null?root.left.data:null, root.right!=null?root.right.data:null));
	            	}
					else
						rightBst[0].isBST=false;
	            }
	 
	            
	            //Left tree validation with root
	            if (!(leftBst[0].isBST && leftBst[0].maxValue < root.data)) {
	            	if(leftBst[0].node!=null)
	            	{
	            		hMap.put(root.data, new WrapTree(root.left!=null?root.left.data:null, null));

	            	int[] countMinMax=new MaxBSTinBT().getCountAndMinMax(hMap, root.data);
	            	if(countMinMax[0]>1)
	            	{
	            		leftBst[0].isBST=true;
	            		leftBst[0].nodes=countMinMax[0];
	            		leftBst[0].minValue=countMinMax[1];

	            	}else
	            		leftBst[0].isBST=false;
            		hMap.put(root.data, new WrapTree(root.left!=null?root.left.data:null, root.right!=null?root.right.data:null));

	            	}else
	            		leftBst[0].isBST=false;
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
	            
	            }else if (root.left == null && (!(rightBst[0].isBST)) ){
	            	
	                TreeNodeHelper bstHelper = new TreeNodeHelper(root, 1, root.data, root.data, true);
	                rightBst[1]=rightBst[1]==null?rightBst[0]:(rightBst[0].nodes>rightBst[1].nodes?rightBst[0]:rightBst[1]);
	                rightBst[0]=bstHelper;
	                return rightBst;
	                
	            }else if (root.right == null && leftBst[0].isBST) {
	            	
	                leftBst[0] = new TreeNodeHelper(root, ++leftBst[0].nodes, root.data, leftBst[0].minValue, true);
	                return leftBst;
	                
	            }else if (root.right == null && (!(leftBst[0].isBST))  ){
	            	
	                TreeNodeHelper bstHelper = new TreeNodeHelper(root, 1, root.data, root.data, true);
	                leftBst[1]=leftBst[1]==null?leftBst[0]:(leftBst[0].nodes>leftBst[1].nodes?leftBst[0]:leftBst[1]);
	                leftBst[0]=bstHelper;
	                return leftBst;
	                
	            }else if ( (leftBst[0].isBST) && (!(rightBst[0].isBST)) ){ 
	            	
	            	if(leftBst[0].nodes > rightBst[0].nodes)
	            	{
	                    leftBst[0] = new TreeNodeHelper(root, ++leftBst[0].nodes, root.data, leftBst[0].minValue, true);
	                    if(leftBst[1]!=null&&rightBst[1]!=null)
	                    {
	                    leftBst[1]=leftBst[1].nodes>rightBst[1].nodes?leftBst[1]:rightBst[1];
	                    }else
	                    {
	                    	leftBst[1]=leftBst[1]!=null?leftBst[1]:rightBst[1];
	                    }
	                    return leftBst;

	            	}else if (leftBst[0].nodes < rightBst[0].nodes)
	            	{
	            		leftBst[0] = new TreeNodeHelper(root, ++leftBst[0].nodes, root.data, leftBst[0].minValue, true);
	            		
	            		if(rightBst[1]==null)
	            		{
	            			
	            			leftBst[1]=leftBst[1]==null?rightBst[0]:(leftBst[1].nodes>rightBst[0].nodes?leftBst[1]:rightBst[0]);
	            			
	            		}
	            		else
	            		{
	                    TreeNodeHelper bstHelper=rightBst[0].nodes>rightBst[1].nodes?rightBst[0]:rightBst[1];
	                    leftBst[1]=leftBst[1]==null?bstHelper:(leftBst[1].nodes>bstHelper.nodes?leftBst[1]:bstHelper);
	            		}

	                    return leftBst;
	            		
	            	}else //if (leftBst[0].nodes == rightBst[0].nodes)
	            	{
	            		leftBst[0] = new TreeNodeHelper(root, ++leftBst[0].nodes, root.data, leftBst[0].minValue, true);
	            		
	            		if((leftBst[1]!=null)&&(rightBst[1]!=null)){
		            		leftBst[1]=leftBst[1].nodes>rightBst[1].nodes?leftBst[1]:rightBst[1];
		            	}else if((leftBst[1]!=null)||(rightBst[1]!=null))
		            	{
		            		leftBst[1]=leftBst[1]!=null?leftBst[1]:rightBst[1];
		            	}
	            		
	                    return leftBst;

	            	}
	            	
	            } else if ( (!(leftBst[0].isBST)) && ((rightBst[0].isBST)) ){ 
	            	
	            	if(leftBst[0].nodes > rightBst[0].nodes)
	            	{
	            		
	            		rightBst[0]=new TreeNodeHelper(root, ++rightBst[0].nodes, rightBst[0].maxValue, root.data, true);
	            		
	            		if(leftBst[1]==null)
	            		{
	            			rightBst[1]=rightBst[1]==null?leftBst[0]:(leftBst[0].nodes>rightBst[1].nodes?leftBst[0]:rightBst[1]);
	            		}else
	            		{
		                    TreeNodeHelper bstHelper=leftBst[0].nodes>leftBst[1].nodes?leftBst[0]:leftBst[1];
		            		rightBst[1]=rightBst[1]==null?bstHelper:(rightBst[1].nodes>bstHelper.nodes?rightBst[1]:bstHelper);

	            			
	            		}
	            		return rightBst;
	            		
	            	}else if (leftBst[0].nodes < rightBst[0].nodes)
	            	{
	            		rightBst[0]=new TreeNodeHelper(root, ++rightBst[0].nodes, rightBst[0].maxValue, root.data, true);
	            		
	            		if(leftBst[1]!=null&&rightBst[1]!=null)
	                    {
	                    rightBst[1]=leftBst[1].nodes>rightBst[1].nodes?leftBst[1]:rightBst[1];
	                    }else
	                    {
	                    	rightBst[1]=rightBst[1]!=null?rightBst[1]:leftBst[1];
	                    }
	            		
	            		return rightBst;

	            		
	            	}else //if (leftBst[0].nodes == rightBst[0].nodes)
	            	{
	            		rightBst[0]=new TreeNodeHelper(root, ++rightBst[0].nodes, rightBst[0].maxValue, root.data, true);
	            		
	            		if((leftBst[1]!=null)&&(rightBst[1]!=null)){
		            		rightBst[1]=leftBst[1].nodes>rightBst[1].nodes?leftBst[1]:rightBst[1];
		            	}else if((leftBst[1]!=null)||(rightBst[1]!=null))
		            	{
		            		rightBst[1]=rightBst[1]!=null?rightBst[1]:leftBst[1];
		            	}
	            		
	            		return rightBst;
	            	}
	            	
	            } else {
	            	
	            	//Start the count from 1
	            	TreeNodeHelper falseHelper= new TreeNodeHelper(root, 1, root.data, root.data, true);
	                TreeNodeHelper bstHelper=rightBst[0].nodes>leftBst[0].nodes?rightBst[0]:leftBst[0];

	                TreeNodeHelper bstHelper1=null;
	                if((leftBst[1]!=null)&&(rightBst[1]!=null)){
	            		 bstHelper1=leftBst[1].nodes>rightBst[1].nodes?leftBst[1]:rightBst[1];
	            	}else if((leftBst[1]!=null)||(rightBst[1]!=null))
	            	{
	            		 bstHelper1=leftBst[1]!=null?leftBst[1]:rightBst[1];
	            	}
            		
	                leftBst[1]=bstHelper1==null?bstHelper:(bstHelper.nodes>bstHelper1.nodes?bstHelper:bstHelper1);
	                leftBst[0]=falseHelper;
	                
            		return leftBst;

	            }
	        }
	    }
	
}
