package ARRAYS_AND_STRINGS;

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

		// Scanner reader = new Scanner(System.in);
		Integer[] input = new Integer[20];
		input = generateRandomNumbers(20);
		// int index = 0;
		// System.out.println("Please enter numbers to sort : ");
		// while (reader.hasNext())
		// {
		// input[index] = Integer.valueOf(reader.nextInt());
		// index++;
		// }
		/*int[] aux = input.clone();
		mergeSort(aux, input, 0, input.length - 1);
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}*/
		// reader.close();
	}

	public static Integer[] generateRandomNumbers(int n) {
		Integer[] a = new Integer[n];
		Random random = new Random();
		for (int i = 0; i < a.length; i++)
			a[i] = ((n < 100) ? random.nextInt(100) : random.nextInt());
		return a;
	}

}
