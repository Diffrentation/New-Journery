class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int currentSum = 0;
        
        // Step 1: Calculate the sum of the first 'k' elements
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        
        int maxSum = currentSum;
        
        // Step 2: Slide the window from index 'k' to the end
        for (int i = k; i < nums.length; i++) {
            currentSum = currentSum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, currentSum);
        }
        
        // Return the average as a double
        return (double) maxSum / k;
    }
}