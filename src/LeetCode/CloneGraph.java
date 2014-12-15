package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class CloneGraph {

	// Definition for undirected graph.
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};

	HashSet<Integer> seenLabels; // = new HashSet<Integer>();
	HashMap<Integer, UndirectedGraphNode> nodesMap; // = new HashMap<Integer, CloneGraph.UndirectedGraphNode>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode srcHead) {
		if (srcHead == null)
			return null;
		seenLabels = new HashSet<Integer>();
		nodesMap = new HashMap<Integer, UndirectedGraphNode>();

		UndirectedGraphNode dstHead = new UndirectedGraphNode(srcHead.label);
		visitNode(srcHead, dstHead);
		return dstHead;
	}

	private void visitNode(UndirectedGraphNode srcNode, UndirectedGraphNode dstNode) {
		// If seen, return.
		if (seenLabels.contains(srcNode.label)) {
			return;
		}

		seenLabels.add(srcNode.label);
		nodesMap.put(dstNode.label, dstNode);
		// Iterate all neighbors
		for (UndirectedGraphNode curSrcNeighbor : srcNode.neighbors) {
			int curSrcNeighborLabel = curSrcNeighbor.label;
			// If this neighbor does not exist, create it.
			if (!nodesMap.containsKey(curSrcNeighborLabel)) {
				UndirectedGraphNode newNeighbor = new UndirectedGraphNode(curSrcNeighborLabel);
				nodesMap.put(curSrcNeighborLabel, newNeighbor);
			}
			// Find the neighbor
			UndirectedGraphNode dstNeighbor = nodesMap.get(curSrcNeighborLabel);
			dstNode.neighbors.add(dstNeighbor);
			// DFS
			visitNode(curSrcNeighbor, dstNeighbor);
		}
	}

}
