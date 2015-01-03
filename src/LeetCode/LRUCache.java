package LeetCode;

import java.util.HashMap;

public class LRUCache {
	class CacheDLLNode {
		int key;
		int value;
		CacheDLLNode next;
		CacheDLLNode prev;

		public CacheDLLNode(int kv, int vv, CacheDLLNode nv, CacheDLLNode pv) {
			this.key = kv;
			this.value = vv;
			this.next = nv;
			this.prev = pv;
		}
	}

	HashMap<Integer, CacheDLLNode> map;
	CacheDLLNode head;
	int capacity;
	int size;

	private void insertToHead(CacheDLLNode newNode) {
		CacheDLLNode head = this.head;
		CacheDLLNode second = this.head.next;
		newNode.prev = head;
		head.next = newNode;
		newNode.next = second;
		second.prev = newNode;
	}

	private void removeNode(CacheDLLNode toBeRemoved) {
		CacheDLLNode previousNode = toBeRemoved.prev;
		CacheDLLNode nextNode = toBeRemoved.next;
		previousNode.next = nextNode;
		nextNode.prev = previousNode;
	}

	private void renewNode(CacheDLLNode toBeRenewed) {
		removeNode(toBeRenewed);
		insertToHead(toBeRenewed);
	}

	private void invalidNode(CacheDLLNode toBeInvalid) {
		this.map.remove(toBeInvalid.key);
		removeNode(toBeInvalid);
	}

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.map = new HashMap<Integer, CacheDLLNode>();

		CacheDLLNode newNode = new CacheDLLNode(-1, -1, null, null);
		newNode.prev = newNode;
		newNode.next = newNode;
		this.head = newNode;
	}

	public int get(int key) {
		if (this.map.containsKey(key)) {
			CacheDLLNode queriedNode = this.map.get(key);
			int retValue = queriedNode.value;
			renewNode(queriedNode);
			return retValue;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		if (this.map.containsKey(key)) {
			CacheDLLNode existNode = this.map.get(key);
			existNode.value = value;
			renewNode(existNode);
		} else {
			if (size >= capacity) {
				CacheDLLNode toBeRemoved = this.head.prev;
				invalidNode(toBeRemoved);
				size -= 1;
			}
			CacheDLLNode newNode = new CacheDLLNode(key, value, null, null);
			insertToHead(newNode);
			this.map.put(key, newNode);
			size += 1;
		}
	}
}
