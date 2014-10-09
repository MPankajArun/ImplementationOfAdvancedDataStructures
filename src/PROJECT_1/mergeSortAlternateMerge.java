package PROJECT_1;

import java.util.Random;

public class mergeSortAlternateMerge {

	public static void mergeSort(int[] inpuArr, int[] auxArray,
			int low, int high) {
		if (high <= low) {
			return;
		}
		int mid = low + (high - low) / 2;

		mergeSort(auxArray, inpuArr, low, mid);
		mergeSort(auxArray, inpuArr, mid + 1, high);
		merge(inpuArr, auxArray, low, mid, high);
	}

	public static void merge(int[] source, int[] destination, int low,
			int middle, int high) {

		int firstIndex = low;
		int secondIndex = middle + 1;
		for (int k = low; k <= high; k++) {
			if (firstIndex > middle) {
				destination[k] = source[secondIndex++];
			} else if (secondIndex > high) {
				destination[k] = source[firstIndex++];
			} else if (source[secondIndex] < source[firstIndex]) {
				destination[k] = source[secondIndex++];
			} else {
				destination[k] = source[firstIndex++];
			}
		}

	}

	public static void main(String[] args) {


	}

	public static Integer[] generateRandomNumbers(int n) {
		Integer[] a = new Integer[n];
		Random random = new Random();
		for (int i = 0; i < a.length; i++)
			a[i] = ((n < 100) ? random.nextInt(100) : random.nextInt());
		return a;
	}

}
