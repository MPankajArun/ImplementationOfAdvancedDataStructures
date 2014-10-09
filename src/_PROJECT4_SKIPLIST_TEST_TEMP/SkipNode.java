    package _PROJECT4_SKIPLIST_TEST_TEMP;

    // Basic node stored in skip lists
    // Note that this class is not accessible outside
    // of package DataStructures

    class SkipNode
    {
            // Constructors
        SkipNode( Long theElement )
        {
            this( theElement, null, null, null );
        }

        SkipNode( Long theElement, Long theValue, SkipNode rt, SkipNode dt )
        {
            key  = theElement;
            value = theValue;
            right    = rt;
            down     = dt;
        }

            // Friendly data; accessible by other package routines
        Long key;      // The data in the node
        Long value;
        SkipNode   right;        // Right link 
        SkipNode   down;         // Down link
    }