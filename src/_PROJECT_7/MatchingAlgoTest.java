package _PROJECT_7;

import java.awt.Adjustable;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
 
/** Class Hopcroft **/
public class MatchingAlgoTest
{    
    private final int NIL = 0;
    private final int INF = Integer.MAX_VALUE;
    private ArrayList<Integer>[] Adj; 
    int[] Pair;
    int[] Dist;
    int cx, cy;
 
     /** Function BFS **/
    public boolean BFS() 
    {
    	//System.out.println("CX :"+cx+" CY : "+cy);
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int v = 1; v <= cx; ++v) 
            if (Pair[v] == NIL) 
            { 
                Dist[v] = 0; 
                queue.add(v); 
            }
            else 
                Dist[v] = INF;
 
        Dist[NIL] = INF;
 
        while (!queue.isEmpty()) 
        {
            int v = queue.poll();
            if (Dist[v] < Dist[NIL]) 
                for (int u : Adj[v]) 
                    if (Dist[Pair[u]] == INF) 
                    {
                        Dist[Pair[u]] = Dist[v] + 1;
                        queue.add(Pair[u]);
                    }           
        }
        return Dist[NIL] != INF;
    }    
     /** Function DFS **/
    public boolean DFS(int v) 
    {
        if (v != NIL) 
        {
            for (int u : Adj[v]) 
                if (Dist[Pair[u]] == Dist[v] + 1)
                    if (DFS(Pair[u])) 
                    {
                        Pair[u] = v;
                        Pair[v] = u;
                        return true;
                    }               
 
            Dist[v] = INF;
            return false;
        }
        return true;
    }
     /** Function to get maximum matching **/
    public int HopcroftKarp() 
    {
        Pair = new int[cx + cy + 1];
        Dist = new int[cx + cy + 1];
        int matching = 0;
        while (BFS())
            for (int v = 1; v <= cx; ++v)
                if (Pair[v] == NIL)
                    if (DFS(v))
                        matching = matching + 1;
        return matching;
    }
    /** Function to make graph with vertices x , y **/
    public void makeGraph(int[] x, int[] y, int E)
    {
        Adj = new ArrayList[cx + cy + 1];
        for (int i = 0; i < Adj.length; ++i)
            Adj[i] = new ArrayList<Integer>();        
        /** adding edges **/    
        for (int i = 0; i < E; ++i) 
            addEdge(x[i] , y[i] ); 
        
        for(int i=0;i<(cx+cy);i++)
        {
        	ArrayList<Integer> al=Adj[i];
        	for(int j : al)
        	{
				//System.out.println("u  :"+i+" v  :"+j);

        	}
        }
    }
    /** Function to add a edge **/
    public void addEdge(int u, int v) 
    {
        Adj[u].add(cx + v);
        Adj[cx + v].add(u);
    }    
    /** Main Method **/
    public static void main (String[] args) 
    {
		File infile=new File("/users/dany/downloads/matching/matching-10k.txt");

        Scanner scan;
		try {
			scan = new Scanner(infile);
		
        MatchingAlgoTest hc = new MatchingAlgoTest();
 
        /** Accept number of edges **/
        hc.cx = scan.nextInt();
        hc.cy = scan.nextInt();
        int E = scan.nextInt();
        int[] x = new int[E];
        int[] y = new int[E];
       
 
        for (int i = 0; i < E; i++)
        {
            x[i] = scan.nextInt();
            y[i] = scan.nextInt();
            scan.nextInt();
            //hc.cx = Math.max(hc.cx, x[i]);
            //hc.cy = Math.max(hc.cy, y[i]);
        }
        //hc.cx += 1;
        //hc.cy += 1;
        
		
 
        int noOvertices=hc.cx+hc.cy;
        /** make graph with vertices **/
        hc.makeGraph(x, y, E);            
 
        
        
        System.out.println("\nMatches : "+ hc.HopcroftKarp()); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    } 
    

}