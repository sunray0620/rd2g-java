package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static HashMap<String, List<String>> getRoadMaps(String start, String end, Set<String> dict) {
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

	public static int ladderLength(String start, String end, Set<String> dict) {
		HashMap<String, List<String>> roadMap = getRoadMaps(start, end, dict);
		HashSet<String> used = new HashSet<String>();

		Queue<String> q = new ArrayDeque<String>();
		q.add(start);
		used.add(start);
		int steps = -1;
		while (q.size() > 0) {
			int qsz = q.size();
			steps += 1;
			for (int i = 0; i < qsz; ++i) {
				String curWord = q.poll();
				List<String> allNeighbors = new ArrayList<String>();
				if (roadMap.containsKey(curWord)) {
					allNeighbors = roadMap.get(curWord);
				}
				for (String curNeighbor : allNeighbors) {
					if (used.contains(curNeighbor)) {
						continue;
					}
					if (curNeighbor.equals(end)) {
						return steps + 2;
					}
					used.add(curNeighbor);
					q.add(curNeighbor);
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");

		String start = "hit";
		String end = "cog";
		int ret = ladderLength(start, end, dict);
		System.out.println(String.format("%d.", ret));
	}
}
