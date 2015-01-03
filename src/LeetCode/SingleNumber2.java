package LeetCode;

public class SingleNumber2 {
	public int singleNumber(int[] A) {
		int t1 = 0;
		int t2 = 0;
		int t3 = 0;
		for (int i = 0; i < A.length; ++i) {
			t2 |= t1 & A[i];
			t1 ^= A[i];
			t3 = t1 & t2;
			// 对于ones 和 twos 把出现了3次的位置设置为0 （取反之后1的位置为0）
			t1 &= ~t3;
			t2 &= ~t3;
		}
		return t1;
	}
}
