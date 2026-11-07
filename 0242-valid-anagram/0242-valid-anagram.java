import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        // Check if both strings are equal in length
        // Agar dono ki length barabar nahi hai, toh anagram nahi ho sakte
        if(s.length() != t.length()){
            return false;
        }
        
        // Registry (Map) banaya jahan Key = Character aur Value = uska Count hoga
        Map<Character, Integer> map = new HashMap<>();
        
        // Loop 1: Pehli string 's' ke saare characters ka count map mein badhayein
        for(int i = 0; i < s.length(); i++){
            // Let's get the character from string 's'
            char ch = s.charAt(i);
            
            // Check if character is already in the map
            if(map.containsKey(ch)){
                // Find existing datacount and increment it by 1
                int prevCount = map.get(ch);
                map.put(ch, prevCount + 1);
            }
            else{
                // Agar character pehli baar aaya hai, toh count 1 set karein
                map.put(ch, 1);
            }
        }
        
        // Loop 2: (FIXED) Dusri string 't' ke characters ko check karke count ghatayein
        for(int j = 0; j < t.length(); j++){
            // Let's get the character from string 't'
            char ch = t.charAt(j);
            
            // Agar 't' ka koi character map mein hai hi nahi, toh anagram nahi hai
            if(!map.containsKey(ch)){
                return false;
            }
            
            // Find existing datacount and decrement it by 1
            int prevCount = map.get(ch);
            map.put(ch, prevCount - 1);
            
            // Jab kisi character ka count kam hote-hote 0 ho jaye, toh use remove kar dein
            if(map.get(ch) == 0){
                map.remove(ch);
            }
        }
        
        // Agar map perfectly khali hai, toh true (Anagram hai), nahi toh false
        return map.isEmpty();
    }
}
