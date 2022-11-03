public class BinarySearch {

	public static void main(String[] args) {
		int[] n = { 1, 2, 5, 8, 9, 10, 21, 38 };
		int index = binarySearch(n, 10);
		System.out.println((index == -1) ? "None" : index);
	}

	public static int binarySearch(int[] n, int key) { //binary search의 전제 조건은 정렬된 배열이어야 한다. 시간복잡도 O(logN)
		int low = 0;
		int high = n.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (key == n[mid]) // 찾았을 경우 그 인덱스 리턴
				return mid;
			else if (key < n[mid])
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1; // 배열 안에 key가 없을 경우
	}

}
