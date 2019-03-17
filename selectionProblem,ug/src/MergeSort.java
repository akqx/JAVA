import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	public static void sort(List<Integer> list) {
		if (list.size() < 2) {
			return;
		}
		int mid = list.size() / 2;
		List<Integer> left = new ArrayList<Integer>(list.subList(0, mid));
		List<Integer> right = new ArrayList<Integer>(list.subList(mid, list.size()));

		sort(left);
		sort(right);
		merge(left, right, list);
	}

	private static void merge(List<Integer> left, List<Integer> right, List<Integer> list) {
		int leftInt = 0;
		int rightInt = 0;
		int listInt = 0;

		while (leftInt < left.size() && rightInt < right.size()) {
			if (left.get(leftInt) < right.get(rightInt)) {
				list.set(listInt++, left.get(leftInt++));
			} else {
				list.set(listInt++, right.get(rightInt++));
			}
		}
		while (leftInt < left.size()) {
			list.set(listInt++, left.get(leftInt++));
		}
		while (rightInt < right.size()) {
			list.set(listInt++, right.get(rightInt++));
		}
	}
}