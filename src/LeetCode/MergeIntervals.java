package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {
		int intervalSize = intervals.size();
		if (intervals == null || intervalSize <= 1) {
			return intervals;
		}

		List<Interval> ret = new ArrayList<Interval>();
		Collections.sort(intervals, new IntervalComparator());
		Interval prevInterval = intervals.get(0);

		for (int i = 1; i < intervalSize; ++i) {
			Interval curInterval = intervals.get(i);

			int compareValue = compareInterval(prevInterval, curInterval);
			if (compareValue < 0) {
				ret.add(prevInterval);
				prevInterval = curInterval;
			} else if (compareValue > 0) {
				ret.add(curInterval);
			} else {
				Interval mergedInterval = mergeTwoInterval(prevInterval, curInterval);
				prevInterval = mergedInterval;
			}
		}
		if (prevInterval != null) {
			ret.add(prevInterval);
		}
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

	class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
	}

}
