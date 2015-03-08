package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDnaSequences {

	public List<String> findRepeatedDnaSequences(String s) {
		List<String> ans = new ArrayList<String>();
		HashSet<String> sset = new HashSet<String>();
		char[] scs = s.toCharArray();
		for (int i = 0; i < scs.length - 9; ++i) {
			String curs = new String(scs, i, 10);
			if (sset.contains(curs)) {
				ans.add(curs);
			} else {
				sset.add(curs);
			}
		}
		return ans;
	}
}
