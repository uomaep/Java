
public class BinarySearchRecur {

	public static void main(String[] args) {
		int[] n = { 1, 2, 5, 8, 9, 10, 21, 38 };
		int index = binarySearch(n, 10);
		System.out.println((index == -1) ? "None" : index);
	}

	public static int binarySearch(int[] n, int key) {
		return binarySearchRecur(n, 0, n.length - 1, key);
	}

	private static int binarySearchRecur(int[] n, int low, int high, int key) {
		if (low <= high) {
			int mid = (low + high) / 2;
			if (key == n[mid])
				return mid;
			else if (key < n[mid])
				return binarySearchRecur(n, low, mid - 1, key);
			else
				return binarySearchRecur(n, mid + 1, high, key);
		}
		return -1;
	}

}
