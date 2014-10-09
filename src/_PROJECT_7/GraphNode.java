/**
 * 
 */
package _PROJECT_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * @author Dany
 *
 */
public class GraphNode {

	/**
	 * @param args
	 */
	public static int noOfVerticesLeft=0;
	public static int noOfVerticesRight=0;
	public static int arrLen=0;
	public final int NIL=0;
	public final int INF=1<<28;
	public final int MAX=100001;
	public ArrayList<Integer> matchList=new ArrayList<Integer>(0);
	public ArrayList<Integer> distanceList=new ArrayList<Integer>(0);
	//public int[] matchList=new int[MAX];
	//public int[] distanceList=new int[MAX];
	public static ArrayList<ArrayList<Integer>> graphArray=null;
	//public static ArrayList<Integer>[] graphArray=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<ArrayList<Integer>> result=new GraphNode().constructBiPartiteGraph("/users/dany/downloads/matching/matching-10k.txt");
		//ArrayList<Integer>[] result=new GraphNode().constructBiPartiteGraphArray("/users/dany/downloads/matching/matching-100k.txt");

		/*int i=0;
		System.out.println("result size :"+result.size());
		for(ArrayList<Integer> aList : result)
		{
			System.out.println("List : "+(i++));
			if(aList!=null)
			{
			for(Integer v: aList)
			{
				System.out.println(" v "+v);
			}
			}
		}*/
		
		long inTime=System.currentTimeMillis();

		int maxMatch=new GraphNode().findMaxMatching();
		System.out.println("Max match : "+maxMatch);
		long pTime=System.currentTimeMillis();
		System.out.println("Time taken in Milli Secs "+(pTime-inTime));
	}
	
	public ArrayList<ArrayList<Integer>> constructBiPartiteGraph(String inFile)
	{
		File infile=new File(inFile);

		int u=-1;
		int v=-1;
		int w=-1;
		ArrayList<Integer> c=null;

		try {
			Scanner scanner=new Scanner(infile);
			while(scanner.hasNext())
			{
				noOfVerticesLeft=scanner.nextInt();
				noOfVerticesRight=scanner.nextInt();
				arrLen=scanner.nextInt();
				graphArray=new ArrayList<ArrayList<Integer>>(Collections.nCopies(arrLen, c));
				for(int i=0;i<arrLen;i++)
				{
				u=scanner.nextInt();
				v=scanner.nextInt();
				w=scanner.nextInt();
				ArrayList<Integer> adjList = graphArray.get(u);
					if(adjList==null)
					{
						adjList=new ArrayList<Integer>();
						adjList.add(v);
						graphArray.set(u,adjList);
					}else
					{
						adjList.add(v);
						graphArray.set(u,adjList);
					}
				}
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return graphArray;
	}

	
/*	public ArrayList<Integer>[] constructBiPartiteGraphArray(String inFile)
	{

		File infile=new File(inFile);

		int u=-1;
		int v=-1;
		int w=-1;
		ArrayList<Integer> c=null;

		try {
			Scanner scanner=new Scanner(infile);
			while(scanner.hasNext())
			{
				noOfVerticesLeft=scanner.nextInt();
				noOfVerticesRight=scanner.nextInt();
				arrLen=scanner.nextInt();
				for(int i=1;i<=arrLen;i++)
				{
				u=scanner.nextInt();
				v=scanner.nextInt();
				w=scanner.nextInt();
				graphArray=new ArrayList[noOfVerticesLeft];
				for(int k=1;k<=arrLen;k++)
				{
					ArrayList<Integer> temp=null;
					graphArray[k]=new ArrayList<Integer>();
				}
				
				ArrayList<Integer> adjList = graphArray[i];
					if(adjList==null)
					{
						adjList=new ArrayList<Integer>();
						adjList.add(v);
						graphArray[u]=adjList;
					}else
					{
						adjList.add(v);
						graphArray[u]=adjList;
					}
				}
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return graphArray;
	
	}*/
	public boolean doBfs()
	{
	    int i, u, v, len;
	    Queue<Integer> q = new LinkedList<Integer>();
	    for(i=1; i<=noOfVerticesLeft; i++) {
	    	if(matchList.get(i)==NIL){
	       //if(matchList[i]==NIL) {
	            distanceList.set(i, 0);
	    		//distanceList[i]=0;
	            q.add(i);
	        }else 
	        	distanceList.set(i, INF);
	        	//distanceList[i]=INF;
	    }
	    distanceList.set(NIL, INF);
	    //distanceList[NIL]=INF;
	    while(!q.isEmpty()) {
	        u = q.remove(); //q.poll();
	        if(u!=NIL) {
	            len=graphArray.get(u)==null?0:(graphArray.get(u).size());
	        	//len = G[u].size();
	            for(i=0; i<len; i++) {
	                v=graphArray.get(u).get(i);
	            	//v = G[u][i];
	                if(distanceList.get(matchList.get(v))==INF)
	                {
	                	distanceList.set(matchList.get(v), distanceList.get(u)+1);
	                	q.add(matchList.get(v));
	                }
	                /*if(distanceList[matchList[v]]==INF) {
	                    distanceList[matchList[v]] = distanceList[u] + 1;
	                    q.add(matchList[v]);
	                }*/
	            }
	        }
	    }
	    return (distanceList.get(NIL)!=INF);
	    //return (distanceList[NIL]!=INF);

	}
	
	public boolean doDFS(int u)
	{
		int i, v, len;
	    if(u!=NIL) {
            len=graphArray.get(u)==null?0:(graphArray.get(u).size());
	        for(i=0; i<len; i++) {
	            v = graphArray.get(u).get(i);
	            if(distanceList.get(matchList.get(v))==distanceList.get(u)+1)
	            {
	            	if(doDFS(matchList.get(v)))
	            	{
	            		matchList.set(v, u);
	            		matchList.set(u, v);
	            		return true;
	            	}
	            }
	            
	            /*if(distanceList[matchList[v]]==distanceList[u]+1) {
	                if(doDFS(matchList[v])) {
	                	matchList[v] = u;
	                	matchList[u] = v;
	                    return true;
	                }
	            }*/
	        }
	        distanceList.set(u, INF);
	        //distanceList[u]=INF;
	        //dist[u] = INF;
	        return false;
	    }
	    return true;
	}
	
	public int findMaxMatching()
	{
		int matching = 0, i;
	    // match[] is assumed NIL for all vertex in G
	    while(doBfs())
	        for(i=1; i<=noOfVerticesLeft; i++)
	            
	        	//if(match[i]==NIL && dfs(i))
	        	if(matchList.get(i)==NIL&&doDFS(i))
	                matching++;
	    return matching;
	}
	
	
}
