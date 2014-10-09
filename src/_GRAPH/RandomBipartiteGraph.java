/**
 * 
 */
package _GRAPH;

import java.util.Random;

/**
 * @author Dany
 *
 */
public class RandomBipartiteGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1 = 15; 
		int n2 = 20; 
		int m = 25;
		
		
		long seed = 1;
		int nodei[] = new int[m+1];
		int nodej[] = new int[m+1];

		randomBipartiteGraph(n1,n2,m,seed,nodei,nodej); 
		System.out.println("List of edges:\n from to");
		for (int k=1; k<=nodei[0]; k++)
		System.out.println(" " + nodei[k] + " " + nodej[k]);

	}
	
	public static void randomBipartiteGraph(int n1, int n2, int m,
			long seed, int nodei[], int nodej[])
			{
			int n,nodea,nodeb,nodec,numedges;
			boolean adj[][] = new boolean[n1+n2+1][n1+n2+1]; boolean temp;
			Random ran = new Random(seed);
			n = n1 + n2;
			// initialize the adjacency matrix 
			for (nodea=1; nodea<=n; nodea++)
			for (nodeb=1; nodeb<=n; nodeb++) 
				adj[nodea][nodeb] = false;
			if (m != 0) {
			if (m > n1 * n2) m = n1 * n2;
			numedges = 0;
			// generate a simple bipartite graph with exactly m edges 
			while (numedges < m) {
			// generate a random integer in interval [1, n1] 
				nodea = (int)(1 + ran.nextDouble() * n1);
			// generate a random integer in interval [n1+1, n] 
				nodeb = (int)(n1 + 1 + ran.nextDouble() * n2);
			if (!adj[nodea][nodeb]) {
			// add the edge (nodei,nodej) 
				adj[nodea][nodeb] = adj[nodeb][nodea] = true; 
				numedges++;
			} }
			} else {
			// generate a random adjacency matrix with edges from // nodes of group [1, n1] to nodes of group [n1+1, n] 
			for (nodea=1; nodea<=n1; nodea++)
			for (nodeb=n1+1; nodeb<=n; nodeb++)
				adj[nodea][nodeb] = adj[nodeb][nodea] = (ran.nextInt(2) == 0) ? false : true;
			}
			// random permutation of rows and columns 
			for (nodea=1; nodea<=n; nodea++) {
			nodec = (int)(nodea + ran.nextDouble() * (n + 1 - nodea)); 
			for (nodeb=1; nodeb<=n; nodeb++) {
			
			temp = adj[nodec][nodeb]; 
			adj[nodec][nodeb] = adj[nodea][nodeb]; 
			adj[nodea][nodeb] = temp;
			}
			for (nodeb=1; nodeb<=n; nodeb++) {
			temp = adj[nodeb][nodec]; 
			adj[nodeb][nodec] = adj[nodeb][nodea]; 
			adj[nodeb][nodea] = temp;
			} 
			}
			numedges = 0;
			for (nodea=1; nodea<=n; nodea++)
			for (nodeb=nodea+1; nodeb<=n; nodeb++) 
			if (adj[nodea][nodeb]) {
			numedges++; 
			nodei[numedges] = nodea; 
			nodej[numedges] = nodeb;
			}
			nodei[0] = numedges;
			}
	
}
