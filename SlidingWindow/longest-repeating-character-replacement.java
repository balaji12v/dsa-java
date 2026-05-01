// Problem: Longest Repeating Character Replacement (LC 424)

// Pattern: Sliding Window (Variable)

// Approach:
// 1. Use two pointers (left, right)
// 2. Track frequency of characters
// 3. Maintain maxFreq
// 4. Shrink window if (window size - maxFreq > k)

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int l=0;
        int maxfreq =0;
        int maxlen =0;
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
            maxfreq = Math.max(maxfreq,hm.get(s.charAt(i)));
            while((i-l+1)-maxfreq>k){
                hm.put(s.charAt(l),hm.get(s.charAt(l))-1);
                l++;
            }
            maxlen =Math.max(maxlen,i-l+1); 
        }
        return maxlen;
    }
}
