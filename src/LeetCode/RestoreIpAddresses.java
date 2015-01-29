package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RestoreIpAddresses {

	public List<String> restoreIpAddresses(String s) {
		List<String> rets = new ArrayList<String>();
		if (s.length() == 0) {
			return rets;
		}
		Deque<Integer> curRet = new ArrayDeque<Integer>();
		char[] sc = s.toCharArray();
		restoreIpFromHere(sc, 0, curRet, rets);
		return rets;
	}

	private void restoreIpFromHere(char[] sc, int startPos, Deque<Integer> curRet, List<String> rets) {
		if (startPos == sc.length && curRet.size() == 4) {
			StringBuilder sb = new StringBuilder();
			for (int ipsec : curRet) {
				sb.append(ipsec);
				sb.append('.');
			}
			rets.add(sb.substring(0, sb.length() - 1).toString());
		}

		if (curRet.size() == 4) {
			return;
		}

		for (int endPos = startPos; endPos < sc.length; ++endPos) {
			String ipSecStr = new String(sc, startPos, endPos - startPos + 1);
			int ipSecInt = getValidIpSec(ipSecStr);
			if (ipSecInt == -1) {
				break;
			}
			curRet.add(ipSecInt);
			restoreIpFromHere(sc, endPos + 1, curRet, rets);
			curRet.removeLast();
		}
	}

	private int getValidIpSec(String s) {
		if (s.charAt(0) == '0' && s.length() > 1) {
			return -1;
		}
		int ipSecInt = Integer.parseInt(s);
		if (ipSecInt > 255) {
			return -1;
		}
		return ipSecInt;
	}

}
