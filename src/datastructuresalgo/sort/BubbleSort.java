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


    public static void main(String[] args) {
        int[] myArray = {14,5,30,9,24,34};

        insertionSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }
}
