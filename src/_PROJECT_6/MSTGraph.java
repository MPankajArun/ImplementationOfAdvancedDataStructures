/**
 * 
 */
package _PROJECT_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

import _PROJECT_5.SeperateChainingWithTwoChoice;

/**
 * @author Dany
 *
 */
public class MSTGraph {

	/**
	 * @param args
	 */
	//ArrayList<Edge> mstGraph=new ArrayList<Edge>();
	public static Set<Integer> bCheck=new HashSet<Integer>();
	static int noOfVertices=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long inTime=System.currentTimeMillis();

	ArrayList<Edge> nodeArray = new MSTGraph().constructGraph("/users/dany/downloads/suma.txt");
	bCheck.add(1);
	int mstGraphWeight = new MSTGraph().implementMST(nodeArray, 1, 0, null);
	//int mstDiGraphWeight = new MSTGraph().implementMSTForDiGraph(nodeArray, 1, 0, null);

	/*for(Edge oNode : mstGraphList)
	{
		System.out.println("u "+oNode.u+"  v  "+oNode.v+"  w  "+oNode.w);
	}*/
	
	System.out.println("Total Weight : "+mstGraphWeight);
	
	//System.out.println("Total Di graph Weight : "+mstDiGraphWeight);
	long pTime=System.currentTimeMillis();
	System.out.println("Time taken in Milli Secs "+(pTime-inTime));
	
		
	}
	
	public ArrayList<Edge> constructGraph(String inFile)
	{
		File infile=new File(inFile);
		int arrLen=0;
		ArrayList<Edge> nodeArray=null;
		try {
			Scanner scanner=new Scanner(infile);
			while(scanner.hasNext())
			{
				noOfVertices=scanner.nextInt();
				arrLen=scanner.nextInt();
				nodeArray=new ArrayList<Edge>();
				for(int i=0;i<arrLen;i++)
				{
					Edge oNode = new Edge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
					nodeArray.add(oNode);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return nodeArray;
	}

	
	public PriorityQueue<Edge> constructMinHeap(String inFile)
	{

		File infile=new File(inFile);
		int arrLen=0;
		int vertices=0;
		PriorityQueue<Edge> minHeap=null;
		try {
			Scanner scanner=new Scanner(infile);
			while(scanner.hasNext())
			{
				vertices=scanner.nextInt();
				arrLen=scanner.nextInt();
				minHeap=new GraphMinHeap().implementMinHeapPriorityQueue();
				for(int i=0;i<arrLen;i++)
				{
					minHeap.add(new Edge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return minHeap;
	}
	
	public PriorityQueue<Edge> modifyMinHeapAndAdd(Edge[] graph, int startNode, PriorityQueue<Edge> minHeap)
	{
		for(Edge oNode: graph)
		{
			if(oNode.u==startNode)
			{
				minHeap.add(oNode);
			}
		}
		return minHeap;
	}
	
	public int implementMST(ArrayList<Edge> graph, int startNode, int mstGraphWeight, PriorityQueue<Edge> minHeap)
	{
		
		if(bCheck.size()==noOfVertices-1)
			return mstGraphWeight;
		
		if(minHeap==null)
		minHeap=new GraphMinHeap().implementMinHeapPriorityQueue();
		//System.out.println("size"+minHeap.size());
		ArrayList<Edge> newGraphList=new ArrayList<Edge>();
		int i=0;
		int j=0;

		for(Edge oNode : graph)
		{
			
			if(((oNode.u==startNode)||(oNode.v==startNode))&&(!(bCheck.contains(oNode.v))))
			{
				
				minHeap.add(oNode);
				System.out.println("size"+minHeap.size());
				System.out.println("count "+i++);


			}else
			{
				newGraphList.add(oNode);
				System.out.println("Array count "+j++);

			}
		}
		//System.out.println("MST size : "+minHeap.size());
		Edge resultNode=minHeap.poll();

		while(bCheck.contains(resultNode.u)&&bCheck.contains(resultNode.v))
		{
			resultNode=minHeap.poll();
		}
		
		if(!(bCheck.contains(resultNode.u))&&(bCheck.contains(resultNode.v)))
		{
				bCheck.add(resultNode.u);
				startNode=resultNode.u;
				mstGraphWeight+=resultNode.w;
			

		}else if((bCheck.contains(resultNode.u))&&!(bCheck.contains(resultNode.v)))
		{
			bCheck.add(resultNode.v);
			startNode=resultNode.v;
			mstGraphWeight+=resultNode.w;
		}
		
		return implementMST(newGraphList, startNode, mstGraphWeight, minHeap);
	}
	
	public int implementMSTForDiGraph(ArrayList<Edge> graph, int startNode, int mstGraphWeight, PriorityQueue<Edge> minHeap)
	{

		
		if(bCheck.size()==noOfVertices)
			return mstGraphWeight;
		else
		{
		if(minHeap==null)
		minHeap=new GraphMinHeap().implementMinHeapPriorityQueue();
		
		ArrayList<Edge> newGraphList=new ArrayList<Edge>();
		for(Edge oNode : graph)
		{
			if(oNode.u==startNode||oNode.v==startNode)
			{
				minHeap.add(oNode);
			}else
			{
				newGraphList.add(oNode);
			}
		}
		
		Edge resultNode=minHeap.poll();
		if((bCheck.contains(resultNode.u)&&bCheck.contains(resultNode.v)))
		{
			;
		}else if((bCheck.contains(resultNode.u)||bCheck.contains(resultNode.v)))
		{
			if(bCheck.contains(resultNode.u))
			{
				bCheck.add(resultNode.v);
				startNode=resultNode.v;
			}else
			{
				bCheck.add(resultNode.u);
 
			}
			mstGraphWeight+=resultNode.w;

		}
		
		
		return implementMST(newGraphList, startNode, mstGraphWeight, minHeap);
		}
	
	}
	
}
