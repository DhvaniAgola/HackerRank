import java.util.LinkedHashMap;

public class LRUCacheProblem {

	public static void main(String[] args) {
		LRUCache lru = new LRUCache(2);
		lru.put(1, 1); // cache is {1=1}
		lru.put(2, 2); // cache is {1=1, 2=2}
		System.out.println(lru.get(1));    // return 1
		lru.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		System.out.println(lru.get(2));    // returns -1 (not found)
		lru.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		System.out.println(lru.get(1));    // return -1 (not found)
		System.out.println(lru.get(3));    // return 3
		System.out.println(lru.get(4));    // return 4
	}
}

class LRUCache {

	LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
	int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			int val = map.remove(key);
			map.put(key, val);
			return val;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			map.remove(key);
		}
		map.put(key, value);
		if (map.size() > capacity)
			map.remove(map.keySet().iterator().next());
	}
}
