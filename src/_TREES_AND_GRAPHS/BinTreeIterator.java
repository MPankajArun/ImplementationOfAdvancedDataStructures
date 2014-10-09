/**
 * 
 */
package _TREES_AND_GRAPHS;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author Dany
 *
 */
class BinTreeIterator implements Iterator<TreeNode> {
    Stack<TreeNode> stack;
    boolean leftToRight;

    public boolean hasNext() {
        return !stack.empty();
    }

    public TreeNode next() {
        return stack.peek();
    }

    public void remove() {
        TreeNode node = stack.pop();
        if (leftToRight) {
        	if(node.right!=null)
            node = node.right;
            while (node.right != null) {
                stack.push(node);
                node = node.right;
            }
        } else {
        	if(node.left!=null)
            node = node.left;
            while (node.left != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }

    public BinTreeIterator(TreeNode node, boolean leftToRight) {
        stack = new Stack<TreeNode>();
        this.leftToRight = leftToRight;

        if (leftToRight) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        } else {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
        }            
    }
//}

public BinTreeIterator()
{
	
}

public static boolean searchNumBinTree(TreeNode node, int num) {
    if (node == null)
        return false;

    BinTreeIterator leftIter = new BinTreeIterator(node,true);
    BinTreeIterator rightIter = new BinTreeIterator(node,false);

    while (leftIter.hasNext() && rightIter.hasNext()) {
        TreeNode left = leftIter.next();
        TreeNode right = rightIter.next();
        int sum = left.data + right.data;
        if (sum == num) {
            return true;
        } else if (sum > num) {
            rightIter.remove();
            if (!rightIter.hasNext() || rightIter.next() == left) {
                return false;
            }
        } else {
            leftIter.remove();
            if (!leftIter.hasNext() || leftIter.next() == right) {
                return false;
            }
        }
    }

    return false;
}
}