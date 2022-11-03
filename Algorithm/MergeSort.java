import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] n = { 8, 1, 5, 11, 9, 4, 10, 7, 2, 6, 3 };
		mergeSort(n);
		System.out.println(Arrays.toString(n));
	}

	public static void mergeSort(int[] n) {
		int[] sorted = new int[n.length];
		mergeSortRecur(n, sorted, 0, n.length - 1);
	}

	private static void mergeSortRecur(int[] n, int[] sorted, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSortRecur(n, sorted, low, mid);
			mergeSortRecur(n, sorted, mid + 1, high);
			merge(n, sorted, low, mid, high);
		}
	}

	private static void merge(int[] n, int[] sorted, int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		int k = low;

		while (i <= mid && j <= high) {
			if (n[i] < n[j])
				sorted[k++] = n[i++];
			else
				sorted[k++] = n[j++];
		}

		if (i <= mid)
			while (i <= mid)
				sorted[k++] = n[i++];
		else
			while (j <= high)
				sorted[k++] = n[j++];

		for (int t = low; t <= high; t++)
			n[t] = sorted[t];
	}
}
