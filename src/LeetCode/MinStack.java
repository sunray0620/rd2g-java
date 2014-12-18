package LeetCode;

import java.util.Stack;

public class MinStack {
	/*
	 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
	 * push(x) -- Push element x onto stack.
	 * pop() -- Removes the element on top of the stack.
	 * top() -- Get the top element.
	 * getMin() -- Retrieve the minimum element in the stack.
	 */
	Stack<Integer> s = new Stack<Integer>();
	Stack<Integer> sm = new Stack<Integer>();

	public void push(int x) {
		s.push(x);
		if (sm.isEmpty() || x <= sm.peek()) {
			sm.push(x);
		}
	}

	public void pop() {
		int popValue = s.pop();
		if (popValue == sm.peek()) {
			sm.pop();
		}
	}

	public int top() {
		return s.peek();
	}

	public int getMin() {
		return sm.peek();
	}

}