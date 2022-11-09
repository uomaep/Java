import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {

		int[] n = { 8, 1, 5, 9, 3, 7, 4, 6, 2 };
		quickSort(n);
		System.out.println(Arrays.toString(n));

	}

	public static void quickSort(int[] n) {
		quickSortRecur(n, 0, n.length - 1);
	}

	private static void quickSortRecur(int[] n, int low, int high) {
		if (low < high) {
			int pivotPoint = partition(n, low, high);
			quickSortRecur(n, low, pivotPoint - 1);
			quickSortRecur(n, pivotPoint + 1, high);
		}
	}

	private static int partition(int[] n, int low, int high) {
		int pivot = n[low];
		int j = low;
		for (int i = low + 1; i <= high; i++) {
			if (n[i] < pivot) {
				j++;
				int tmp = n[i];
				n[i] = n[j];
				n[j] = tmp;
			}
		}
		int tmp = n[j];
		n[j] = n[low];
		n[low] = tmp;
		return j;
	}

}
