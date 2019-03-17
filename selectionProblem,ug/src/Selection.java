import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Selection {
	public static int getSelection(List<Integer> list, int k) {

		if (list.size() == 1)
			return list.get(0);

		int medianOfMedians = getMedianOfMedians(list);
		int position = getPart(list, medianOfMedians);

		if (position == k)
			return medianOfMedians;
		else if (k < position)
			return getSelection(list.subList(0, position), k);
		else
			return getSelection(list.subList(position + 1, list.size()), k - position - 1);
	}

	private static int getMedianOfMedians(List<Integer> list) {
		List<Integer> medians = new ArrayList<Integer>();

		int shortListSize = (int) Math.ceil(list.size() / 5.0);

		for (int i = 0; i < shortListSize; i++) {
			List<Integer> newShortMedianList;
			if ((i + 1) * 5 > list.size()) {
				newShortMedianList = list.subList(i * 5, list.size());
			} else {
				newShortMedianList = list.subList(i * 5, (i + 1) * 5);
			}
			MergeSort.sort(newShortMedianList);
			medians.add(newShortMedianList.get(newShortMedianList.size() / 2));
		}
		return getSelection(medians, medians.size() / 2);
	}

	private static void change(List<Integer> list, int left, int right) {
		int end = list.get(left);
		list.set(left, list.get(right));
		list.set(right, end);
	}

	private static int getPart(List<Integer> list, int x) {
		int l = 0;
		int size = list.size() - 1;
		int i;
		for (i = l; i < size; i++)
			if (list.get(i) == x)
				break;
		change(list, i, size);

		i = l;
		for (int j = l; j <= size - 1; j++) {
			if (list.get(j) <= x) {
				change(list, i, j);
				i++;
			}
		}
		change(list, i, size);
		return i;
	}
}