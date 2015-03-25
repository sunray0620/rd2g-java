package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> ret = new ArrayList<Interval>();
		Interval curInterval = newInterval;

		for (Interval itrInterval : intervals) {
			int compareValue = compareInterval(curInterval, itrInterval);
			if (compareValue < 0) {
				ret.add(curInterval);
				curInterval = itrInterval;
			} else if (compareValue > 0) {
				ret.add(itrInterval);
			} else {
				Interval mergedInterval = mergeTwoInterval(curInterval, itrInterval);
				curInterval = mergedInterval;
			}
		}
		ret.add(curInterval);
		return ret;
	}

	private int compareInterval(Interval left, Interval right) {
		if (left.end < right.start) {
			return -1;
		} else if (left.start > right.end) {
			return 1;
		} else {
			return 0;
		}
	}

	private Interval mergeTwoInterval(Interval interval1, Interval interval2) {
		Interval newInterval = new Interval();
		newInterval.start = Math.min(interval1.start, interval2.start);
		newInterval.end = Math.max(interval1.end, interval2.end);
		return newInterval;
	}
}
