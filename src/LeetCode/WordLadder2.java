package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class WordLadder2 {

	public static HashMap<String, List<String>> preprocessGraph(String start, String end, Set<String> dict) {
		dict.add(start);
		dict.add(end);
		int wordLen = start.length();
		HashMap<String, List<String>> ret = new HashMap<String, List<String>>();
		char[] wcs = new char[wordLen];
		for (String curWord : dict) {
			if (curWord.length() != wordLen) {
				continue;
			}
			List<String> neighbors = new ArrayList<String>();
			// Copy string to char array
			for (int i = 0; i < wordLen; ++i) {
				wcs[i] = curWord.charAt(i);
			}
			//
			for (int i = 0; i < wordLen; ++i) {
				for (char c = 'a'; c <= 'z'; ++c) {
					if (wcs[i] == c) {
						continue;
					}
					char original = wcs[i];
					wcs[i] = c;
					String possibleNeighbor = new String(wcs);
					if (dict.contains(possibleNeighbor)) {
						neighbors.add(possibleNeighbor);
					}
					wcs[i] = original;
				}
			}
			ret.put(curWord, neighbors);
		}
		return ret;
	}

	public static HashMap<String, List<String>> getRoadMaps(String start, String end, HashMap<String, List<String>> graph) {
		HashMap<String, Integer> wayPoint = new HashMap<String, Integer>();
		HashMap<String, List<String>> path = new HashMap<String, List<String>>();

		Queue<String> q = new ArrayDeque<String>();
		q.add(start);
		int steps = -1;
		// path.put(start, new ArrayList<String>());
		wayPoint.put(start, 0);

		while (q.size() > 0 && !wayPoint.containsKey(end)) {
			int qsz = q.size();
			steps += 1;
			for (int i = 0; i < qsz; ++i) {
				String curWord = q.poll();
				List<String> allNeighbors = new ArrayList<String>();
				if (graph.containsKey(curWord)) {
					allNeighbors = graph.get(curWord);
				}
				for (String curNeighbor : allNeighbors) {
					if (wayPoint.containsKey(curNeighbor)) {
						int neighborPos = wayPoint.get(curNeighbor);
						if (neighborPos <= steps) {
							continue;
						}
					}

					wayPoint.put(curNeighbor, steps + 1);
					if (!path.containsKey(curWord)) {
						path.put(curWord, new ArrayList<String>());
					}
					List<String> prevs = path.get(curWord);
					if (!prevs.contains(curNeighbor)) {
						prevs.add(curNeighbor);
					}
					q.add(curNeighbor);
				}
			}
		}
		return path;
	}

	public static List<List<String>> getPaths(HashMap<String, List<String>> slnGraphs, String start, String end) {
		List<List<String>> ret = new ArrayList<List<String>>();
		Stack<String> path = new Stack<String>();
		visitNode(slnGraphs, start, end, path, ret);
		return ret;
	}

	public static void visitNode(HashMap<String, List<String>> slnGraph, String curWord, String end, Stack<String> path, List<List<String>> ret) {
		if (curWord.equals(end)) {
			path.add(curWord);
			ret.add(new ArrayList<String>(path));
			path.pop();
			return;
		}
		// push current word
		if (!slnGraph.containsKey(curWord)) {
			return;
		}
		path.push(curWord);
		List<String> nextNodes = slnGraph.get(curWord);
		for (String nextNode : nextNodes) {
			visitNode(slnGraph, nextNode, end, path, ret);
		}
		path.pop();
	}

	public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
		HashMap<String, List<String>> graph = preprocessGraph(start, end, dict);
		HashMap<String, List<String>> solutionGraph = getRoadMaps(start, end, graph);
		List<List<String>> ret = getPaths(solutionGraph, start, end);
		return ret;
	}

	public static void main(String[] args) {
		// String[] allwds = new String[] { "ted", "tex", "red", "tax", "tad", "den", "rex", "pee" };
		String[] allwds = new String[] { "a", "b", "c" };
		Set<String> dict = new HashSet<String>();
		for (int i = 0; i < allwds.length; ++i) {
			dict.add(allwds[i]);
		}

		String start = "a";
		String end = "c";
		List<List<String>> ret = findLadders(start, end, dict);
		System.out.println(String.format("%d.", ret.size()));
	}
}
