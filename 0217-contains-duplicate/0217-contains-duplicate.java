import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Step 1: Create an empty HashSet to keep track of numbers we have already seen.
        // We use a Set instead of a Map because we only need to check for presence, 
        // and we don't care about the index of the numbers.
        Set<Integer> seenNumbers = new HashSet<>();
        
        // Step 2: Loop through the array from the beginning to the end.
        for (int i = 0; i < nums.length; i++) {
            
            // Step 3: Check if the current number is already present in our set.
            if (seenNumbers.contains(nums[i])) {
                // If it is already there, it means we found a duplicate!
                // We return true immediately and stop the program.
                return true;
            } else {
                // Step 4: If the number is not in the set, it's the first time we are seeing it.
                // So, we add it to our set so future elements can check against it.
                seenNumbers.add(nums[i]);
            }
        }
        
        // Step 5: If the loop finishes completely, it means we scanned the whole array
        // and did not find any number repeating. So, we return false.
        return false;
    }
}
