import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        int[] myArr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};

        // Divide-and-conquer part
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter target element : ");
        int key = scanner.nextInt();
        System.out.print("\nDivide-and-conquer answer : ");
        System.out.printf("%d is present at index %d of the array.", key, DnQBinarySearch(myArr, key));

        // Iterative and recursive portion
        int len = myArr.length - 1;
        System.out.print("\nIterative answer : ");
        System.out.print(iterativeBinarySearch(myArr, 23));
        System.out.print("\nRecursive answer : ");
        System.out.print(recursiveBinarySearch(myArr, 0, len, 23));
        
    }

    private static int iterativeBinarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            int testNum = arr[mid];

            if (testNum == target) {
                return mid;
            }
            if (testNum < target) {
                low = mid + 1; // take the right part
            } else {
                high = mid - 1; // take the left part
            }
        }
        return -1; // default case
    }

    private static int recursiveBinarySearch(int[] arr, int low, int high, int target) {
        if (low <= high) {
            int mid = low + (high - low)/2;
            int testNum = arr[mid];
            if (testNum == target) {
                return mid;
            }
            if (testNum < target) {
                return recursiveBinarySearch(arr, mid + 1, high, target);
                // undershoot
            } else {
                return recursiveBinarySearch(arr, low, mid - 1, target);
                // overshoot
            }
        }
        return -1; // default case
    }
    
    private static int DnQBinarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low)/2; // prevents overflow
            int testNum = arr[mid];
            
            if (testNum == target) {
                return mid;
            }
            if (testNum < target) {
                low = mid + 1; // take the right part
            } else {
                high = mid - 1; // take the left part
            }
        }
        return -1; // default case
    }
    
}

// Enter target element : 23
// 23 is present at index 5 of the array.
// === Code Execution Successful ===
