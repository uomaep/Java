public class BinarySearch {

	public static void main(String[] args) {
		int[] n = { 1, 2, 5, 8, 9, 10, 21, 38 };
		int index = binarySearch(n, 10);
		System.out.println((index == -1) ? "None" : index);
	}

	public static int binarySearch(int[] n, int key) {
		int low = 0;
		int high = n.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (key == n[mid])
				return mid;
			else if (key < n[mid])
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

}
