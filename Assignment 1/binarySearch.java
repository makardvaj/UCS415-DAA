public class binarySearch {
    
    public static void main(String[] args) {

        int[] myArr = {-8, -5, -3, -2, -1, 0, 1, 2, 4, 5, 7, 9, 11, 16};
        int len = myArr.length - 1;
        
        System.out.println(iterativeBinarySearch(myArr, 4));
        System.out.println(recursiveBinarySearch(myArr, 0, len, -2));
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
}
