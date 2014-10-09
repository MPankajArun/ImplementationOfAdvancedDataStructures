/**
 * 
 */
package _PROJECT_6_MST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

import _PROJECT_6.Edge;
import _PROJECT_6.Graph;

/**
 * @author Dany
 *
 */
public class DirectedMST {

	/**
	 * @param args
	 */
	public static int noOfVertices=0;
	public static int noOfEdges=0;
	public static int arrLen=0;
	public static Graph graph=null;
	Integer[] in=new Integer[noOfVertices+1];
	int[] constant=new int[noOfVertices+1];
	Integer[] prev=new Integer[noOfVertices+1];
	Integer[] parent=new Integer[noOfVertices+1];
	Integer[] children=new Integer[noOfVertices+1];
	public PriorityQueue<Edge>[] pQueue=(PriorityQueue<Edge>[])new PriorityQueue[noOfVertices+1];

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	
	public void constructGraph(String inFile)
	{
		File infile=new File(inFile);

		try {
			Scanner scanner=new Scanner(infile);
			noOfVertices=scanner.nextInt();
			noOfEdges=scanner.nextInt();
			graph=new Graph(noOfVertices);
			for(int i=0;i<noOfEdges;i++)
			graph.addEdge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			graph.printGraph();
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void initialize()
	{
		for(int i=0;i<=noOfVertices;i++)
		{
			initVertex(i);
		}
		
		
		
		
	}
	
	public void initVertex(int u)
	{
		in[u]=null;
		constant[u]=0;
		prev[u]=null;
		parent[u]=null;
		children[u]=null;
		pQueue[u]=new GraphMinHeap().implementMinHeapPriorityQueue();
	}

}
