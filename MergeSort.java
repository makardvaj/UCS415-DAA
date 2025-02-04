public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array : ");
        printArray(arr, ", ");
        System.out.println();

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array : ");
        printArray(arr, ", ");
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left)/2; // prevents overflow

            mergeSort(arr, left, mid); // sort left half
            mergeSort(arr, mid + 1, right); //sort right half

            merge(arr, left, mid, right); // merge the sorted halves
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1; // size of 1st subarray
        int n2 = right - mid; // size of 2nd subarray

        int[] L = new int[n1]; // temporary left array
        int[] R = new int[n2]; // temporary right array

        // copying data to temporary arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        
        // merging the temporary arrays
        int i = 0, j = 0; // initial index of 1st and 2nd arrays
        int k = left; // initial index of merged subarray
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of L
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy any remaining elements of R
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private static void printArray(int[] arr, String sep) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            System.out.print(arr[i] + sep);
        System.out.print(arr[n - 1]);
    }
}