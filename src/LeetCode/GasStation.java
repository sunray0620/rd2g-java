package LeetCode;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int N = gas.length;
		int minGas = Integer.MAX_VALUE;
		int minStation = -1;
		int curStatus = 0;

		for (int i = 0; i < N; ++i) {
			curStatus += (gas[i] - cost[i]);
			if (curStatus <= minGas) {
				minGas = curStatus;
				minStation = i;
			}
		}

		if (curStatus >= 0) {
			return (minStation + 1) % N;
		} else {
			return -1;
		}
	}
}
