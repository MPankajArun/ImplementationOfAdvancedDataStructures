/**
 * 
 */
package _PROJECT_4_SKIPLIST;

/**
 * @author Dany
 *
 */
//BinarySearchTree class
//
// CONSTRUCTION: with a value at least as large as all others
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x (unimplemented)
// Comparable find( x )   --> Return item that matches x
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items


public class DSL
{
    /**
     * Construct the DSL.
     * @param inf the largest Comparable.
     */
    public DSL( Long key, Long value )
    {
        theKey = key;
        theValue=value;
        bottom = new SkipNode( null, null );
        bottom.right = bottom.down = bottom;
        tail   = new SkipNode( theKey, theValue );
        tail.right = tail;
        header = new SkipNode( theKey, theValue, tail, bottom );
    }

    /**
     * Insert into the DSL.
     * @param x the item to insert.
     */
    public void insert( Long x, Long v )
    {
        SkipNode current = header;

        bottom.key = x;
        bottom.value = v;

        while( current != bottom )
        {
            while( current.key.compareTo( x ) < 0 )
                current = current.right;

            // If gap size is 3 or at bottom level and
            // must insert, then promote middle element
            if( current.down.right.right.key.compareTo( current.key ) < 0 )
            {
                current.right = new SkipNode( current.key, current.value, current.right,
                                              current.down.right.right );
                current.key = current.down.right.key;
            }
            else
                current = current.down;
        }

        // Raise height of DSL if necessary
        if( header.right != tail )
            header = new SkipNode( theKey, theValue, tail, header );
    }

    /**
     * Remove from the DSL. Unimplemented.
     * @param x the item to remove.
     */
    public void remove( Long x )
    {
        System.out.println( "Sorry, remove unimplemented" );
    }

    /**
     * Find the smallest item in the DSL.
     * @return smallest item, or null if empty.
     */
    public Long findMin( )
    {
        if( isEmpty( ) )
            return null;

        SkipNode current = header;
        while( current.down != bottom )
            current = current.down;

        return elementAt( current );
    }

    /**
     * Find the largest item in the DSL.
     * @return the largest item, or null if empty.
     */
    public Long findMax( )
    {
        if( isEmpty( ) )
            return null;

        SkipNode current = header;
        for( ; ; )
             if( current.right.right != tail )
                 current = current.right;
             else if( current.down != bottom )
                 current = current.down;
             else
                 return elementAt( current );
    }

    /**
     * Find an item in the DSL.
     * @param x the item to search for.
     * @return the matching item, or null if not found.
     */
    public Long find( Long x )
    {
        SkipNode current = header;

        bottom.key = x;
        for( ; ; )
            if( x.compareTo( current.key ) < 0 )
                current = current.down;
            else if( x.compareTo( current.key ) > 0 )
                current = current.right;
            else
                return elementAt( current );
    }

    /**
     * Make the DSL logically empty.
     */
    public void makeEmpty( )
    {
        header.right = tail;
        header.down = bottom;
    }

    /**
     * Test if the DSL is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return header.right == tail && header.down == bottom;
    }

    /**
     * Internal method to get element field.
     * @param t the node.
     * @return the element field, or null if t is null.
     */
    private Long elementAt( SkipNode t )
    {
        return t == bottom ? 0 : t.value;
    }

    /**
     * Print the DSL.
     */
    private void printList( )
    {
        SkipNode current = header;
        System.out.println( "Test" );

        while( current.down != bottom )
             ;

        while( current.right != tail )
        {
            System.out.println( current.value );
            current = current.right;
        }
    }

      /** The DSL header. */
    private SkipNode header;
    private Long theKey;
    private Long theValue;
    private SkipNode bottom = null;
    private SkipNode tail   = null;
   

        // Test program
    public static void main( String [ ] args )
    {/*
        DSL t = new DSL( new MyInteger( 100000000 ) );
        
        
        final int NUMS = 4000;
        final int GAP  =   37;

        System.out.println( "Checking... (no more output means success)" );

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            t.insert( new MyInteger( i ) );

        System.out.println( "Checking  I... (no more output means success)" );

       // if( NUMS < 5000 )
            t.printList( );
            System.out.println( "Checking  II... (no more output means success)" );

        if( ((MyInteger)(t.findMin( ))).intValue( ) != 1 ||
            ((MyInteger)(t.findMax( ))).intValue( ) != NUMS - 1 )
            System.out.println( "FindMin or FindMax error!" );

        for( int i = 1; i < NUMS; i++ )
             if( ((MyInteger)(t.find( new MyInteger( i ) ))).intValue( ) != i )
                 System.out.println( "Find error1!" );
        if( t.find( new MyInteger( 0 ) ) != null )
            System.out.println( "Find error2!" );
        if( t.find( new MyInteger( NUMS + 10 ) ) != null )
            System.out.println( "Find error2!" );
        
       
*/}
}