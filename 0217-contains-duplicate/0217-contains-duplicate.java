import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Ek khali HashSet banaya un numbers ko yaad rakhne ke liye jo hum dekh chuke hain
        Set<Integer> set = new HashSet<>();
        
        // Array ke har ek element par baari-baari jaane ke liye loop chalaya
        for(int i = 0; i < nums.length; i++){
            
            // Check kiya ki kya current number pehle se humare set (registry) mein maujood hai?
            if(set.contains(nums[i])){
                // Agar haan, toh iska matlab duplicate mil gaya! Yahin se true return kar do
                return true;
            }
            else{
                // Agar nahi, toh is naye number ko set mein add kar do taaki aage kaam aaye
                set.add(nums[i]);
            }
        }
        // Agar poora loop khatam ho gaya aur koi duplicate nahi mila, toh false return kar do
        return false;
    }
}
