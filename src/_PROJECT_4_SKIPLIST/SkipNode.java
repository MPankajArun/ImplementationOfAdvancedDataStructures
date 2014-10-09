package _PROJECT_4_SKIPLIST;

// Basic node stored in skip lists
// Note that this class is not accessible outside
// of package DataStructures

class SkipNode
{
        // Constructors
    SkipNode( Long theKey ,Long theValue)
    {
        this( theKey, theValue, null, null );
    }

    SkipNode( Long theKey, Long value, SkipNode rt, SkipNode dt )
    {
    	key  = theKey;
        right    = rt;
        down     = dt;
    }

        // Friendly data; accessible by other package routines
    Long key;      // The data in the node
    Long value;      // The data in the node
    SkipNode   right;        // Right link 
    SkipNode   down;         // Down link
}