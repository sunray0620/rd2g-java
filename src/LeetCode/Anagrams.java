package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {

	public List<String> anagrams(String[] strs) {
		HashMap<String, List<String>> anagramMap = new HashMap<String, List<String>>();
		char[] wt = new char[100];
		for (String str : strs) {
			int strlen = str.length();
			for (int i = 0; i < strlen; ++i) {
				wt[i] = str.charAt(i);
			}
			Arrays.sort(wt, 0, strlen);
			String sortedString = new String(wt, 0, strlen);
			if (!anagramMap.containsKey(sortedString)) {
				anagramMap.put(sortedString, new ArrayList<String>());
			}
			List<String> curList = anagramMap.get(sortedString);
			curList.add(str);
		}

		List<String> ret = new ArrayList<String>();
		for (List<String> anagramGroup : anagramMap.values()) {
			if (anagramGroup.size() > 1) {
				ret.addAll(anagramGroup);
			}
		}
		return ret;
	}

}
