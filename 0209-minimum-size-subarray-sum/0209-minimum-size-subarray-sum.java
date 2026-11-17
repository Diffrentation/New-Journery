class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;
        
        // Right pointer se window ko expand karte jao
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            
            // Jab window ka sum target ke barabar ya bada ho jaye
            while (currentSum >= target) {
                // Minimum length update karo
                minLength = Math.min(minLength, right - left + 1);
                
                // Left se element remove karke window ko chhota (shrink) karo
                currentSum -= nums[left];
                left++;
            }
        }
        
        // Agar minLength update nahi hua, toh 0 return karo (kyunki koi subarray nahi mila)
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}