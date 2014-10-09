/**
 * 
 */
package _PROJECT_6_MST;

/**
 * @author Dany
 *
 */
public class dirMST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	public  DirectedConnectedGraph spanningTree(
	    DirectedConnectedGraph g, Vertex focus) {
	  DirectedConnectedGraph span = new DirectedConnectedGraph();

	  // remove all edges entering the root; we clone g first so that we do not
	  // affect
	  // the input graph
	  DirectedConnectedGraph gClone = (DirectedConnectedGraph) g
	      .clone();
	  for (Edge edgeToRoot : gClone.getEdgesEntering(focus)) {
	    gClone.removeEdge(edgeToRoot);
	  }

	  // for each vertex, select the edge entering it with smallest weight
	  for (Vertex vertex : gClone.getVertices()) {
	    Collection<Edge> inEdges = gClone.getEdgesEntering(vertex);
	    if (inEdges.isEmpty())
	      continue;
	    float minWeight = Float.POSITIVE_INFINITY;
	    Edge min = null;
	    for (Edge e : inEdges) {
	      if (e.getWeight() <= minWeight) {
	        min = e;
	        minWeight = e.getWeight();
	      }
	    }
	    span.addEdge(new Edge(min.getTarget(), min.getSource(), min
	        .getWeight()));
	  }

	  // if no cycle is formed, we have a minimum spanning tree; otherwise,
	  // continue.
	  Collection<DirectedConnectedGraph> cycles;
	  while ((cycles = cyclesAlgorithm.findCycles(span)).size() > 0) {
	    // for each cycle formed, contract the nodes in the cycle into a
	    // pseudo-node (k), and modify the cost of each arc which enters a node
	    // (j) in the cycle from some node (i) outside the cycle according to
	    // the following equation:
	    // c(i,k)=c(i,j)-(c(x(j),j)-min_{j}(c(x(j),j))
	    // where c(x(j),j) is the cost of the arc in the cycle which enters j.
	    for (DirectedConnectedGraph cycle : cycles) {
	      Collection<Edge> edgesEnteringCycle = findEdgesEnteringCycle(
	          cycle, gClone);

	      float minEdgeWeightInCycle = Float.POSITIVE_INFINITY; // =
	      // min_{j}(c(x(j),j))
	      for (Edge edgeInCycle : cycle.getEdges()) {
	        if (edgeInCycle.getWeight() < minEdgeWeightInCycle)
	          minEdgeWeightInCycle = edgeInCycle.getWeight();
	      }

	      float minAdjustedEnteringWeight = Float.POSITIVE_INFINITY;
	      Edge minAdjustedEdge = null;
	      Edge edgeInCycleToRemove = null;

	      for (Edge edgeEnteringCycle : edgesEnteringCycle) {
	        // edgeEnteringCycle.getWeight() = c(i,k)
	        for (Edge edgeInCycle : cycle.getEdges()) {
	          if (edgeEnteringCycle.getTarget().equals(
	              edgeInCycle.getTarget())) {
	            // edgeInCycle.getWeight() = c(x(j),j)
	            float adjustedWeight = edgeEnteringCycle.getWeight()
	                - edgeInCycle.getWeight() + minEdgeWeightInCycle;

	            if (adjustedWeight <= minAdjustedEnteringWeight) {
	              minAdjustedEnteringWeight = adjustedWeight;
	              minAdjustedEdge = edgeEnteringCycle;
	              edgeInCycleToRemove = edgeInCycle;
	            }

	            break;
	          }
	        }
	      }

	      span.removeEdge(edgeInCycleToRemove);
	      span.addEdge(minAdjustedEdge);
	    }
	  }

	  return span;
	}

	private  Collection<Edge> findEdgesEnteringCycle(
	    DirectedConnectedGraph cycle,
	    DirectedConnectedGraph fullGraph) {
	  Set<Edge> edgesEnteringCycle = new HashSet<Edge>();

	  for (Vertex vertexInCycle : cycle.getVertices()) {
	    edgesEnteringCycle.addAll(fullGraph
	        .getEdgesEntering(vertexInCycle));
	  }
	  edgesEnteringCycle.removeAll(cycle.getEdges());

	  return edgesEnteringCycle;
	}
	
}
