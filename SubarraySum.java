public class SubarraySum {

    public static void main(String[] args) {
        int[] myArr = {-2, -5, 6, -2, -3, 1, 5, -6};

        int maxSum = findMaxSubarraySum(myArr);

        System.out.println("Maximum contiguous subarray sum = " + maxSum + ".");
    }

    private static int findMaxSubarraySum(int[] arr) {

        // Kadane's Algorithm
        
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    private static int max(int a, int b) {
        if (b > a) {
            return b;
        } else {
            return a;
        }
    }
}