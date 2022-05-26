public class test {

	public static void main(String[] args) {
		int[] arr = {1, -1, -1, 1, 1, -1, 1, -1, -1, -1, 1, 1, -1, 1};
		int firstNegative = -1;
		int lastNegative = -1;

		int mul = 1;

		for (int i = 0, j = arr.length - 1; i <= j; i++, j--) {
			if (i == j) {
				mul *= arr[i];
			} else {
				mul *= arr[i];
				mul *= arr[j];
			}
			if (arr[i] == -1 && firstNegative == -1) {
				firstNegative = i;
			}
			if (arr[j] == -1 && lastNegative == -1) {
				lastNegative = j;
			}
		}

		if (mul == 1)
			System.out.println(arr.length);
		else {
			System.out.println(Math.max(arr.length - 1 - firstNegative, lastNegative));
		}
	}

}
