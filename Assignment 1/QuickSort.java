public class QuickSort {

    public static void main(String[] args) {
        int[] myArr = {4, 2, 6, 9, 2};
        System.out.print("Unsorted array : ");
        printArray(myArr, ", ");
        iterativeQuickSort(myArr, 0, myArr.length - 1);
        System.out.print("\nIterative sorting : ");
        printArray(myArr, ", ");
        System.out.print("\nRecursive sorting : ");
        printArray(myArr, ", ");
    }

    public static void recursiveQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            recursiveQuickSort(arr, low, pi - 1);
            recursiveQuickSort(arr, pi + 1, high);
        }
    }

    public static void iterativeQuickSort(int[] arr, int low, int high) {
        int[] stack = new int[high - low + 1];
        int top = -1;

        stack[++top] = low;
        stack[++top] = high;

        while (top >= 0) {
            high = stack[top--];
            low = stack[top--];

            int pi = partition(arr, low, high);

            if (pi - 1 > low) {
                stack[++top] = low;
                stack[++top] = pi - 1;
            }
            if (pi + 1 < high) {
                stack[++top] = pi + 1;
                stack[++top] = high;
            }
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    private static void printArray(int[] arr, String sep) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            System.out.print(arr[i] + sep);
        System.out.print(arr[n - 1]);
    }
}
