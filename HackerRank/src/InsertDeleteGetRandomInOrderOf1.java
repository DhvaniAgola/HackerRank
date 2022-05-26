import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InsertDeleteGetRandomInOrderOf1 {
	public static void main(String[] args) {
		RandomizedSet r = new RandomizedSet();

		System.out.println(r.insert(1));
		System.out.println(r.remove(2));
		System.out.println(r.insert(2));
		System.out.println(r.getRandom());
		System.out.println(r.remove(1));
		System.out.println(r.insert(2));
		System.out.println(r.getRandom());

	}
}

class RandomizedSet {

	List<Integer> set = new ArrayList<>();
	HashMap<Integer, Integer> valToIndex = new HashMap<>();

	public RandomizedSet() {

	}

	public boolean insert(int val) {
		if (set.contains(val))
			return false;
		set.add(val);
		valToIndex.put(val, set.size() - 1);
		return true;
	}

	public boolean remove(int val) {
		if (set.contains(val)) {
			int index = valToIndex.get(val);
			int lastEle = set.get(set.size() - 1);
			set.set(index, lastEle);
			set.remove(set.size() - 1);
			valToIndex.put(lastEle, index);
			valToIndex.remove(val);
			return true;
		}
		return false;
	}

	public int getRandom() {
		return valToIndex.keySet().iterator().next();
	}
}