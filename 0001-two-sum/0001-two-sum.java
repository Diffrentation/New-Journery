import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Step 1: Create an empty HashMap (Registry)
        Map<Integer, Integer> map = new HashMap<>();
        
        // Step 2: Loop through the array (Only one loop!)
        for (int i = 0; i < nums.length; i++) {
            // Step 3: Calculate the required partner
            int partner = target - nums[i];
            
            // Step 4: Check if the partner is already in our registry
            if (map.containsKey(partner)) {
                // Partner found! Return their index and current index.
                return new int[] { map.get(partner), i };
            }
            
            // Partner not found. Register the current number and index.
            map.put(nums[i], i);
        }
        
        // If no solution is found
        return null;
    }
}
