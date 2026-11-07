import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Step 1: Registry banayi jahan Key ek sorted string hogi aur Value groups honge
        Map<String, List<String>> map = new HashMap<>();
        
        // Step 2: Array ke har ek word par loop chalaya
        for (String word : strs) {
            
            // Step 3: Word ko character array mein badla aur sort kiya
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = new String(charArray); // sortedKey ban gayi (e.g., "aet")
            
            // Step 4: Agar key pehle se nahi hai, toh naya group (List) banao
            if (!map.containsKey(sortedKey)) {
                map.put(sortedKey, new ArrayList<>());
            }
            
            // Original word ko us sorted key wale group mein add kar do
            map.get(sortedKey).add(word);
        }
        
        // Step 5: Map ki saari values (jo ki lists ka group hain) return kar do
        return new ArrayList<>(map.values());
    }
}
