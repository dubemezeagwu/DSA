package datastructuresalgo.sort;

import java.util.Arrays;

public class BubbleSort {

    // Bubble-sort
    public static void bubbleSort(int[] array) {
        // Outer loop: Starts at the end of the array and moves towards the beginning
        for (int i = array.length - 1; i > 0; i--) {
            // Inner loop: Starts at the beginning of the array and moves towards index i
            for (int j = 0; j < i; j++) {
                // Check if the current element is greater than the adjacent element
                if (array[j] > array[j+1]) {
                    // If the elements are in the wrong order, swap them
                    // Store the current element in a temporary variable
                    int temp = array[j];
                    // Move the smaller element (adjacent element) to the current position
                    array[j] = array[j+1];
                    // Move the larger element (stored in temp) to the adjacent position
                    array[j+1] = temp;
                }
            }
        }
    }

    // Selection-sort
    public static void selectionSort(int[] array) {
        // Outer loop: Iterate through all elements in the array
        for (int i = 0; i < array.length; i++) {
            // Initialize minIndex to store the index of the smallest element found
            int minIndex = i;
            // Inner loop: Iterate through the remaining unsorted elements
            for (int j = i + 1; j < array.length; j++) {
                // Check if the current element is smaller than the element at minIndex
                if (array[j] < array[minIndex]) {
                    // Update minIndex with the index of the new smallest element found
                    minIndex = j;
                }
            }
            // Check if the smallest element found is not already in its correct position
            if (i != minIndex) {
                // Swap the smallest element found with the element at the current boundary
                // Store the element at the current boundary in a temporary variable
                int temp = array[i];
                // Move the smallest element found to its correct position in the sorted part
                array[i] = array[minIndex];
                // Move the element previously at the boundary to the position of the smallest element
                array[minIndex] = temp;
            }
        }
    }


    // Insertion-sort
    public static void insertionSort(int[] array) {
        // Outer loop: Iterate through all elements in the array, starting from the second element
        for (int i = 1; i < array.length; i++) {
            // Store the first element in the unsorted part of the array in a temporary variable
            int temp = array[i];
            // Initialize j to store the index of the last element in the sorted part of the array
            int j = i - 1;
            // Inner loop: Check whether the temporary value should be inserted in the sorted part
            while (j > -1 && temp < array[j]) {
                // Shift the element at index j one position to the right in the sorted part
                array[j+1] = array[j];
                // Assign the temporary value to the element at the index j
                array[j] = temp;
                // Decrement j to move towards the beginning of the sorted part of the array
                j--;
            }
        }
    }

    public static int[] merge(int[] array1, int[] array2) {
        // Create a new combined array with a size equal to the sum
        // of the lengths of the input arrays
        int[] combined = new int[array1.length + array2.length];

        // Initialize index, i, and j to keep track of positions
        // in combined, array1, and array2 respectively
        int index = 0;
        int i = 0;
        int j = 0;

        // Merge elements from both arrays until one of them reaches its end
        while (i < array1.length && j < array2.length) {
            // If the current element in array1 is smaller, add it to the combined array
            if (array1[i] < array2[j]) {
                combined[index] = array1[i];
                index++;
                i++;
            } else {
                // Otherwise, add the current element from array2 to the combined array
                combined[index] = array2[j];
                index++;
                j++;
            }
        }

        // If there are remaining elements in array1, add them to the combined array
        while (i < array1.length) {
            combined[index] = array1[i];
            index++;
            i++;
        }

        // If there are remaining elements in array2, add them to the combined array
        while (j < array2.length) {
            combined[index] = array2[j];
            index++;
            j++;
        }

        // Return the final merged and sorted combined array
        return combined;
    }

    public static int[] mergeSort(int[] array) {
        // Base case: If the input array has only one element, it
        // is already sorted, so return the array as is.
        if (array.length == 1) return array;

        // Find the middle index of the array by dividing its length by 2.
        int midIndex = array.length/2;

        // Recursively call the mergeSort method on the left half of the array.
        // The Arrays.copyOfRange method is used to create a new array containing
        // the elements from index 0 (inclusive) to the middle index (exclusive).
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));

        // Recursively call the mergeSort method on the right half of the array.
        // The Arrays.copyOfRange method is used to create a new array containing the
        // elements from the middle index (inclusive) to the end of the array (exclusive).
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        // Merge the two sorted halves (left and right) using the merge method,
        // and return the resulting sorted array.
        return merge(left, right);
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public static int pivot(int[] array, int pivotIndex, int endIndex) {
        // Initialize the swap index as the given pivot index
        int swapIndex = pivotIndex;

        // Iterate through the array from the element next to
        // the pivot until the end index
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            // If the current element is smaller than the pivot element,
            // increment the swap index and swap the current element
            // with the element at the swap index
            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }

        // After iterating through the array, swap the pivot element
        // with the element at the final swap index
        // This places the pivot element in its correct position in the sorted array
        swap(array, pivotIndex, swapIndex);

        // Return the swap index, which is the new position of the pivot element
        return swapIndex;
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        // Base case: If the left index is less than the right index, continue sorting
        if (left < right) {
            // Partition the array using the pivot function, and get the new pivot index
            int pivotIndex = pivot(array, left, right);

            // Recursively call quickSortHelper on the
            // left subarray (elements before the pivot)
            quickSortHelper(array, left, pivotIndex - 1);

            // Recursively call quickSortHelper on the
            // right subarray (elements after the pivot)
            quickSortHelper(array, pivotIndex + 1, right);
        }
    }



    public static void main(String[] args) {
        int[] myArray = {14,5,30,9,24,34};

        insertionSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }
}
