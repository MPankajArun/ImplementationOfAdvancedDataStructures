/**
 * 
 */
package _PROJECT_9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;


/**
 * @author Dany
 *
 */
public class MaximumFlow {

	public static int noOfVertices=0;
	public static int noOfEdges=0;
	public static Graph graph=null;
	public static int source=0;
	public static int dest=0;
	public static boolean[] visited;
	public static int[] parent;
	
	public static void main(String[] args) {
		
		new MaximumFlow().constructGraph("/users/dany/downloads/suma.txt");
		graph.printGraph();
		//boolean res=new MaximumFlow().doBFS();
		
		//System.out.println("Results : "+res);
		/*for(int i=0;i<noOfVertices;i++)
		{
			System.out.println("Parent of  : "+i+" is "+parent[i]);
		}*/
		System.out.println("result : "+new MaximumFlow().trackParentAndMinCapacity());
		
	}
	
	public void constructGraph(String inFile)
	{
		File infile=new File(inFile);
		int u,v,w;
		try {
			Scanner scanner=new Scanner(infile);
			noOfVertices=scanner.nextInt();
			noOfEdges=scanner.nextInt();
			source=scanner.nextInt();
			dest=scanner.nextInt();
			scanner.nextInt();
			graph=new Graph(noOfVertices);
			for(int i=0;i<noOfEdges;i++)
			{
			u=scanner.nextInt();
			v=scanner.nextInt();
			w=scanner.nextInt();
			scanner.nextInt();
			graph.addEdge(u,v,w);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean doBFS()
	{
		Queue<Integer> q= new LinkedList<Integer>();
		visited=new boolean[noOfVertices+1];
		parent=new int[noOfVertices];
		Arrays.fill(visited, false);
		q.add(source);
		visited[source]=true;
		while(!q.isEmpty())
		{
			int n = q.remove();
			ArrayList<Edge> outEdges=graph.getOutEdges(n);
			
			for(Edge e : outEdges)
			{
				//System.out.println("out : "+visited[e.v]);
				if(!visited[e.v])
				{
					
				parent[e.v]=n;
				visited[e.v]=true;
				System.out.println("Node start : "+e.v);
				q.add(e.v);
				if(e.v==dest)
					return true;
				}
			}
		}
		return false;
	}
	
	public String trackParentAndMinCapacity()
	{
		String result="";
		int minEdgeCapacity=Integer.MAX_VALUE;

		if(doBFS())
		{
			//For backtracking to the source node
			int src=dest;
			int dst=source;
			while(src!=dst)
			{
				int weightNodeAndParentNode=graph.findWeightWithUandV(parent[src], src);
				if(weightNodeAndParentNode<minEdgeCapacity)
					minEdgeCapacity=weightNodeAndParentNode;
				System.out.println("Minimum weight : "+minEdgeCapacity);
				result += "->"+Integer.toString(src);

				src=parent[src];

			}
		}
		return result;
		
	}
}
