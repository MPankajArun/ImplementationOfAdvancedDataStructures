/**
 * 
 */
package _PROJECT_4_SPLAY;

/**
 * @author Dany
 *
 */
class BinaryNode
{
    BinaryNode(Long theKey, Long theValue) {
        key = theKey;
        value=theValue;
        left = right = null;
    }

    Long key;          // The key in the node
    Long value;			//The value associated for the key
    BinaryNode left;         // Left child
    BinaryNode right;        // Right child
}